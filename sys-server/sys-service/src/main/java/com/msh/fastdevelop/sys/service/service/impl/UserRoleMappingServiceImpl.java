package com.msh.fastdevelop.sys.service.service.impl;;

import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.fastdevelop.sys.client.po.UserRoleMappingPO;
import com.msh.fastdevelop.sys.client.qo.UserRoleMappingQO;
import com.msh.fastdevelop.sys.client.vo.UserRoleMappingVO;
import com.msh.fastdevelop.sys.service.dao.UserRoleMappingDao;
import com.msh.fastdevelop.sys.service.service.UserRoleMappingService;
import com.msh.frame.client.common.CommonResult;
import com.msh.frame.client.common.CommonCode;
import com.msh.frame.common.common.IdGenerateable;
import com.msh.frame.common.util.CollectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-19 17:19:49
 */
@Service
@Slf4j
public class UserRoleMappingServiceImpl extends BaseServiceImpl<UserRoleMappingPO,UserRoleMappingQO> implements UserRoleMappingService {
    @Autowired
    private UserRoleMappingDao userRoleMappingDao;
    @Autowired
    private UserRoleMappingService userRoleMappingService;

    @Override
    public CommonResult<List<UserRoleMappingPO>> list(UserRoleMappingQO param) {
        if(null == param.getStatus()){
            param.setEgtStatus(0);
        }
        return super.list(param);
    }

    @Override
    public CommonResult<Boolean> insert(UserRoleMappingPO param) {
        return super.insert(param);
    }

    @Override
    public CommonResult<Boolean> insertCollection(Collection<UserRoleMappingPO> param) {
        return super.insertCollection(param);
    }

    @Override
    public CommonResult<Boolean> logicDelete(Long param) {
        long result = userRoleMappingDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_EXPIRE);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<UserRoleMappingVO>> listUserRoleMappingVO(UserRoleMappingQO param) {
        List<UserRoleMappingPO> userRoleMappingPOList = userRoleMappingService.list(param).getResult();
        if(null == userRoleMappingPOList || userRoleMappingPOList.size() == 0) {
            return CommonResult.successReturn(CollectionUtils.EMPTY_LIST);
        }
        List<UserRoleMappingVO> userRoleMappingVOList = new ArrayList<>(userRoleMappingPOList.size());
        for(UserRoleMappingPO userRoleMappingPO: userRoleMappingPOList){
            UserRoleMappingVO userRoleMappingVO = new UserRoleMappingVO(userRoleMappingPO);
            userRoleMappingVOList.add(userRoleMappingVO);
        }

        return CommonResult.successReturn(userRoleMappingVOList);
    }

    @Override
    public CommonResult<Boolean> deleteByUserId(long param) {
        long result = userRoleMappingDao.deleteByUserId(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_EXPIRE);
        } else {
            return CommonResult.successReturn(true);
        }
    }
}
