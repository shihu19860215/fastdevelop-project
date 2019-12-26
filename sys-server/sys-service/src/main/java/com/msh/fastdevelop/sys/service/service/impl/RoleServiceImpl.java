package com.msh.fastdevelop.sys.service.service.impl;;

import com.msh.fastdevelop.sys.client.po.UserRoleMappingPO;
import com.msh.fastdevelop.sys.client.qo.RoleAuthorityMappingQO;
import com.msh.fastdevelop.sys.client.qo.UserRoleMappingQO;
import com.msh.fastdevelop.sys.client.vo.RoleAuthorityMappingVO;
import com.msh.fastdevelop.sys.client.vo.UserVO;
import com.msh.fastdevelop.sys.service.service.RoleAuthorityMappingService;
import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.fastdevelop.sys.client.po.RolePO;
import com.msh.fastdevelop.sys.client.qo.RoleQO;
import com.msh.fastdevelop.sys.client.vo.RoleVO;
import com.msh.fastdevelop.sys.service.dao.RoleDao;
import com.msh.fastdevelop.sys.service.service.RoleService;
import com.msh.frame.client.common.CommonResult;
import com.msh.frame.client.common.CommonCode;
import com.msh.frame.interfaces.IdGenerateable;
import com.msh.frame.common.util.CollectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-19 17:19:49
 */
@Service
@Slf4j
public class RoleServiceImpl extends BaseServiceImpl<RolePO,RoleQO> implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleAuthorityMappingService roleAuthorityMappingService;

    @Override
    public CommonResult<List<RolePO>> list(RoleQO param) {
        if(null == param.getStatus()){
            param.setEgtStatus(0);
        }
        return super.list(param);
    }

    @Override
    public CommonResult<Boolean> insert(RolePO param) {
        return super.insert(param);
    }

    @Override
    public CommonResult<Boolean> insertCollection(Collection<RolePO> param) {
        return super.insertCollection(param);
    }

    @Override
    public CommonResult<Boolean> logicDelete(Long param) {
        long result = roleDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_EXPIRE);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<RoleVO>> listRoleVO(RoleQO param) {
        List<RolePO> rolePOList = roleService.list(param).getResult();
        if(null == rolePOList || rolePOList.size() == 0) {
            return CommonResult.successReturn(Collections.emptyList());
        }
        List<RoleVO> roleVOList = new ArrayList<>(rolePOList.size());
        for(RolePO rolePO: rolePOList){
            RoleVO roleVO = new RoleVO(rolePO);
            roleVOList.add(roleVO);
        }

        this.setRoleAuths(roleVOList);

        return CommonResult.successReturn(roleVOList);
    }

    private void setRoleAuths(List<RoleVO> roleVOList){
        Set<Long> roleIds = new HashSet<>();
        for(RoleVO roleVO: roleVOList){
            roleIds.add(roleVO.getId());
        }
        if(roleIds.size() > 0){
            RoleAuthorityMappingQO roleAuthorityMappingQO = new RoleAuthorityMappingQO();
            roleAuthorityMappingQO.setInRoleIds(roleIds);
            List<RoleAuthorityMappingVO> roleAuthorityMappingVOList = roleAuthorityMappingService.listRoleAuthorityMappingVO(roleAuthorityMappingQO).getResult();
            if(null != roleAuthorityMappingVOList){
                Map<Long,Set<Long>> map = new HashMap<>();
                for(RoleAuthorityMappingVO roleAuthorityMappingVO: roleAuthorityMappingVOList){
                    Set<Long> longSet = map.get(roleAuthorityMappingVO.getRoleId());
                    if(null == longSet){
                        longSet = new HashSet<>();
                        map.put(roleAuthorityMappingVO.getRoleId(), longSet);
                    }
                    longSet.add(roleAuthorityMappingVO.getAuthorityId());
                }
                for(RoleVO roleVO: roleVOList){
                    Set<Long> longSet = map.get(roleVO.getId());
                    if(null == longSet){
                        longSet = Collections.emptySet();
                    }
                    roleVO.setAuthIds(longSet);
                }
            }
        }
    }

}
