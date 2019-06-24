package com.msh.fastdevelop.sys.service.service.impl;;

import com.msh.fastdevelop.sys.client.vo.RoleVO;
import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.fastdevelop.sys.client.po.RoleAuthorityMappingPO;
import com.msh.fastdevelop.sys.client.qo.RoleAuthorityMappingQO;
import com.msh.fastdevelop.sys.client.vo.RoleAuthorityMappingVO;
import com.msh.fastdevelop.sys.service.dao.RoleAuthorityMappingDao;
import com.msh.fastdevelop.sys.service.service.RoleAuthorityMappingService;
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
public class RoleAuthorityMappingServiceImpl extends BaseServiceImpl<RoleAuthorityMappingPO,RoleAuthorityMappingQO> implements RoleAuthorityMappingService {
    @Autowired
    private RoleAuthorityMappingDao roleAuthorityMappingDao;
    @Autowired
    private RoleAuthorityMappingService roleAuthorityMappingService;
    @Autowired
    private IdGenerateable idGenerateable;

    @Override
    public CommonResult<List<RoleAuthorityMappingPO>> list(RoleAuthorityMappingQO param) {
        param.setEgtStatus(0);
        return super.list(param);
    }

    @Override
    public CommonResult<Boolean> insert(RoleAuthorityMappingPO param) {
        param.setId(idGenerateable.getUniqueID());
        return super.insert(param);
    }

    @Override
    public CommonResult<Boolean> insertCollection(Collection<RoleAuthorityMappingPO> param) {
        Iterator<RoleAuthorityMappingPO> iterator = param.iterator();
        while(iterator.hasNext()){
            iterator.next().setId(idGenerateable.getUniqueID());
        }
        return super.insertCollection(param);
    }

    @Override
    public CommonResult<Boolean> logicDelete(Long param) {
        long result = roleAuthorityMappingDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_EXPIRE);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<RoleAuthorityMappingVO>> listRoleAuthorityMappingVO(RoleAuthorityMappingQO param) {
        List<RoleAuthorityMappingPO> roleAuthorityMappingPOList = roleAuthorityMappingService.list(param).getResult();
        if(null == roleAuthorityMappingPOList || roleAuthorityMappingPOList.size() == 0) {
            return CommonResult.successReturn(CollectionUtils.EMPTY_LIST);
        }
        List<RoleAuthorityMappingVO> roleAuthorityMappingVOList = new ArrayList<>(roleAuthorityMappingPOList.size());
        for(RoleAuthorityMappingPO roleAuthorityMappingPO: roleAuthorityMappingPOList){
            RoleAuthorityMappingVO roleAuthorityMappingVO = new RoleAuthorityMappingVO(roleAuthorityMappingPO);
            roleAuthorityMappingVOList.add(roleAuthorityMappingVO);
        }

        return CommonResult.successReturn(roleAuthorityMappingVOList);
    }

    @Override
    public CommonResult<Boolean> deleteByUserId(long param) {
        long result = roleAuthorityMappingDao.deleteByUserId(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_EXPIRE);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    @Transactional
    public CommonResult<Boolean> updateRoleAuth(RoleVO roleVO) {
        if(null == roleVO.getId()){
            return CommonResult.errorReturn(CommonCode.PARAM_ERROR.getCode(),"参数错误,没有角色id");
        }
        RoleAuthorityMappingQO sysRoleAuthorityMappingQO = new RoleAuthorityMappingQO();
        sysRoleAuthorityMappingQO.setRoleId(roleVO.getId());
        CommonResult<List<RoleAuthorityMappingPO>> sysRoleAuthorityMappingPOListCommonResult = roleAuthorityMappingService.list(sysRoleAuthorityMappingQO);
        List<RoleAuthorityMappingPO> sysRoleAuthorityMappingPOList = sysRoleAuthorityMappingPOListCommonResult.getResult();
        Set<Long> dbAuthorityIds = new HashSet<>();
        Set<Long> newAuthorityIds = roleVO.getAuthIds();
        if(null != sysRoleAuthorityMappingPOList && sysRoleAuthorityMappingPOList.size() > 0){
            for(RoleAuthorityMappingPO sysRoleAuthorityMappingPO: sysRoleAuthorityMappingPOList){
                dbAuthorityIds.add(sysRoleAuthorityMappingPO.getAuthorityId());
            }
        }

        if(!CollectionUtils.equals(dbAuthorityIds, newAuthorityIds)){
            if(dbAuthorityIds.size()>0){
                roleAuthorityMappingService.deleteByUserId(roleVO.getId());
            }
            if(null != newAuthorityIds && newAuthorityIds.size()>0){
                List<RoleAuthorityMappingPO> list = new ArrayList<>(newAuthorityIds.size());
                for(Long aId :newAuthorityIds){
                    RoleAuthorityMappingPO sysRoleAuthorityMappingPO = new RoleAuthorityMappingPO();
                    sysRoleAuthorityMappingPO.setId(idGenerateable.getUniqueID());
                    sysRoleAuthorityMappingPO.setRoleId(roleVO.getId());
                    sysRoleAuthorityMappingPO.setAuthorityId(aId);
                    list.add(sysRoleAuthorityMappingPO);
                }
                roleAuthorityMappingService.insertCollection(list);
            }
        }
        return CommonResult.successReturn(true);
    }
}
