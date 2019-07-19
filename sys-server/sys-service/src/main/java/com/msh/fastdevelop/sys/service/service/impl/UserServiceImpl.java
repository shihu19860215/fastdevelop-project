package com.msh.fastdevelop.sys.service.service.impl;;

import com.msh.fastdevelop.sys.client.model.UserInfo;
import com.msh.fastdevelop.sys.client.po.*;
import com.msh.fastdevelop.sys.client.qo.*;
import com.msh.fastdevelop.sys.client.vo.AuthorityVO;
import com.msh.fastdevelop.sys.service.define.CommonCodeDef;
import com.msh.fastdevelop.sys.service.service.*;
import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.fastdevelop.sys.client.vo.UserVO;
import com.msh.fastdevelop.sys.service.dao.UserDao;
import com.msh.frame.client.common.CommonResult;
import com.msh.frame.client.common.CommonCode;
import com.msh.frame.common.common.IdGenerateable;
import com.msh.frame.common.util.CollectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-19 17:19:49
 */
@Service
@Slf4j
public class UserServiceImpl extends BaseServiceImpl<UserPO,UserQO> implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleMappingService userRoleMappingService;
    @Autowired
    private RoleAuthorityMappingService roleAuthorityMappingService;
    @Autowired
    private AuthorityUrlService authorityUrlService;
    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private AuditService auditService;

    @Override
    public CommonResult<Boolean> update(UserPO param) {
        UserPO userPO = userService.get(param.getId()).getResult();
        auditService.audit(param, userPO);
        return super.update(param);
    }

    @Override
    public CommonResult<Boolean> delete(long param) {
        userRoleMappingService.deleteByUserId(param);
        return super.delete(param);
    }

    @Override
    public CommonResult<List<UserPO>> list(UserQO param) {
        if(null == param.getStatus()){
            param.setEgtStatus(0);
        }
        return super.list(param);
    }

    @Override
    public CommonResult<Boolean> insert(UserPO param) {
        return super.insert(param);
    }

    @Override
    public CommonResult<Boolean> insertCollection(Collection<UserPO> param) {
        return super.insertCollection(param);
    }

    @Override
    public CommonResult<Boolean> logicDelete(Long param) {
        long result = userDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_EXPIRE);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<UserVO>> listUserVO(UserQO param) {
        List<UserPO> userPOList = userService.list(param).getResult();
        if(null == userPOList || userPOList.size() == 0) {
            return CommonResult.successReturn(CollectionUtils.EMPTY_LIST);
        }
        List<UserVO> userVOList = new ArrayList<>(userPOList.size());
        for(UserPO userPO: userPOList){
            UserVO userVO = new UserVO(userPO);
            userVOList.add(userVO);
        }

        this.setUserRoles(userVOList);

        return CommonResult.successReturn(userVOList);
    }
    private void setUserRoles(List<UserVO> userVOList){
        Set<Long> userIds = new HashSet<>();
        for(UserVO userVO: userVOList){
            userIds.add(userVO.getId());
        }
        if(userIds.size() > 0){
            UserRoleMappingQO userRoleMappingQO = new UserRoleMappingQO();
            userRoleMappingQO.setInUserIds(userIds);
            List<UserRoleMappingPO> userRoleMappingPOList = userRoleMappingService.list(userRoleMappingQO).getResult();
            if(null != userRoleMappingPOList){
                Map<Long,Set<Long>> map = new HashMap<>();
                for(UserRoleMappingPO userRoleMappingPO: userRoleMappingPOList){
                    Set<Long> longSet = map.get(userRoleMappingPO.getUserId());
                    if(null == longSet){
                        longSet = new HashSet<>();
                        map.put(userRoleMappingPO.getUserId(), longSet);
                    }
                    longSet.add(userRoleMappingPO.getRoleId());
                }
                for(UserVO userVO: userVOList){
                    Set<Long> longSet = map.get(userVO.getId());
                    if(null == longSet){
                        longSet = CollectionUtils.EMPTY_SET;
                    }
                    userVO.setRoleIds(longSet);
                }
            }
        }
    }

    @Override
    @Transactional
    public CommonResult<Boolean> updateSysUserVO(UserVO userVO) {
        UserRoleMappingQO sysUserRoleMappingQO = new UserRoleMappingQO();
        sysUserRoleMappingQO.setUserId(userVO.getId());
        CommonResult<List<UserRoleMappingPO>> sysUserRoleMappingQOListCommonResult = userRoleMappingService.list(sysUserRoleMappingQO);
        List<UserRoleMappingPO> sysUserRoleMappingPOList = sysUserRoleMappingQOListCommonResult.getResult();
        Set<Long> dbRoleIds = new HashSet<>();
        Set<Long> newRoleIds = userVO.getRoleIds();
        if(null != sysUserRoleMappingPOList && sysUserRoleMappingPOList.size() > 0){
            for(UserRoleMappingPO sysUserRoleMappingPO: sysUserRoleMappingPOList){
                dbRoleIds.add(sysUserRoleMappingPO.getRoleId());
            }
        }

        if(!CollectionUtils.equals(dbRoleIds, newRoleIds)){
            if(dbRoleIds.size()>0){
                userRoleMappingService.deleteByUserId(userVO.getId());
            }
            if(null != newRoleIds && newRoleIds.size()>0){
                List<UserRoleMappingPO> list = new ArrayList<>(newRoleIds.size());
                for(Long rId :newRoleIds){
                    UserRoleMappingPO sysUserRoleMappingPO = new UserRoleMappingPO();
                    sysUserRoleMappingPO.setUserId(userVO.getId());
                    sysUserRoleMappingPO.setRoleId(rId);
                    list.add(sysUserRoleMappingPO);
                }
                userRoleMappingService.insertCollection(list);
            }
        }
        return userService.update(userVO);
    }

    @Override
    @Transactional
    public CommonResult<Boolean> insertSysUserVO(UserVO userVO) {
        userVO.setPassword("123456");
        CommonResult<Boolean> result = this.insert(userVO);
        Set<Long> newRoleIds = userVO.getRoleIds();
        if(null != newRoleIds && newRoleIds.size()>0){
            List<UserRoleMappingPO> list = new ArrayList<>(newRoleIds.size());
            for(Long rId :newRoleIds){
                UserRoleMappingPO userRoleMappingPO = new UserRoleMappingPO();
                userRoleMappingPO.setUserId(userVO.getId());
                userRoleMappingPO.setRoleId(rId);
                list.add(userRoleMappingPO);
            }
            userRoleMappingService.insertCollection(list);
        }
        return result;
    }


    @Override
    public CommonResult<UserInfo> getUserInfo(String username, String password) {
        UserQO userQO = new UserQO();
        userQO.setUsername(username);
        userQO.setPassword(password);
        UserPO userPO = userService.listOne(userQO).getResult();
        if(null == userPO){
            return CommonResult.errorReturn(CommonCodeDef.USERNAME_PASSWORD_ERROR);
        }
        if(0 == userPO.getStatus()){
            return CommonResult.errorReturn(CommonCodeDef.USER_DISABLE);
        }

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userPO.getId());
        userInfo.setNickName(userPO.getNickname());
        Set<Long> authIds = null;
        UserRoleMappingQO userRoleMappingQO = new UserRoleMappingQO();
        userRoleMappingQO.setUserId(userPO.getId());
        List<UserRoleMappingPO> userRoleMappingPOList = userRoleMappingService.list(userRoleMappingQO).getResult();
        if(null != userRoleMappingPOList && userRoleMappingPOList.size()>0){
            Set<Long> roleIds = new HashSet<>();
            for(UserRoleMappingPO userRoleMappingPO: userRoleMappingPOList){
                roleIds.add(userRoleMappingPO.getRoleId());
            }

            RoleQO roleQO = new RoleQO();
            roleQO.setInIds(roleIds);
            roleQO.setStatus(1);
            List<RolePO> rolePOList = roleService.list(roleQO).getResult();
            if(null != rolePOList && rolePOList.size()>0){
                roleIds = new HashSet<>();
                for(RolePO rolePO: rolePOList){
                    roleIds.add(rolePO.getId());
                }

                RoleAuthorityMappingQO roleAuthorityMappingQO = new RoleAuthorityMappingQO();
                roleAuthorityMappingQO.setInRoleIds(roleIds);
                List<RoleAuthorityMappingPO> roleAuthorityMappingPOList = roleAuthorityMappingService.list(roleAuthorityMappingQO).getResult();
                if(null != roleAuthorityMappingPOList && roleAuthorityMappingPOList.size()>0){
                    authIds = new HashSet<>();
                    for(RoleAuthorityMappingPO roleAuthorityMappingPO: roleAuthorityMappingPOList){
                        authIds.add(roleAuthorityMappingPO.getAuthorityId());
                    }
                }
            }
        }
        if(null == authIds){
            authIds = CollectionUtils.EMPTY_SET;
        }
        userInfo.setAuthIds(authIds);

        Set<String> authUrls = null;
        if(null != authIds && authIds.size()>0){
            AuthorityUrlQO authorityUrlQO = new AuthorityUrlQO();
            authorityUrlQO.setInAuthIds(authIds);
            List<AuthorityUrlPO> authorityUrlPOList = authorityUrlService.list(authorityUrlQO).getResult();
            if(null != authorityUrlPOList && authorityUrlPOList.size()>0){
                authUrls = new HashSet<>(authorityUrlPOList.size()*2);
                for(AuthorityUrlPO authorityUrlPO: authorityUrlPOList){
                    authUrls.add(authorityUrlPO.getUrl());
                }
            }
        }
        if(null == authUrls){
            authUrls = CollectionUtils.EMPTY_SET;
        }
        userInfo.setAuthUrls(authUrls);


        List<AuthorityVO> authorityVOList = null;
        if(userPO.getId() > 1){
            if(authIds.size() > 0){
                AuthorityQO authorityQO = new AuthorityQO();
                authorityQO.setType(1);
                authorityQO.setInIds(authIds);
                authorityVOList = authorityService.listAuthorityVO(authorityQO).getResult();
            }
        }else {
            AuthorityQO authorityQO = new AuthorityQO();
            authorityQO.setType(1);
            authorityVOList = authorityService.listAuthorityVO(authorityQO).getResult();
        }
        if(null == authorityVOList){
            authorityVOList = CollectionUtils.EMPTY_LIST;
        }
        userInfo.setMenuList(authorityVOList);

        return CommonResult.successReturn(userInfo);
    }
}
