package com.msh.fastdevelop.sys.service.service.impl;;

import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.fastdevelop.sys.client.po.ActivityInfoPO;
import com.msh.fastdevelop.sys.client.qo.ActivityInfoQO;
import com.msh.fastdevelop.sys.client.vo.ActivityInfoVO;
import com.msh.fastdevelop.sys.service.dao.ActivityInfoDao;
import com.msh.fastdevelop.sys.service.service.ActivityInfoService;
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
public class ActivityInfoServiceImpl extends BaseServiceImpl<ActivityInfoPO,ActivityInfoQO> implements ActivityInfoService {
    @Autowired
    private ActivityInfoDao activityInfoDao;
    @Autowired
    private ActivityInfoService activityInfoService;
    @Autowired
    private IdGenerateable idGenerateable;

    @Override
    public CommonResult<List<ActivityInfoPO>> list(ActivityInfoQO param) {
        param.setEgtStatus(0);
        return super.list(param);
    }

    @Override
    public CommonResult<Boolean> insert(ActivityInfoPO param) {
        param.setId(idGenerateable.getUniqueID());
        return super.insert(param);
    }

    @Override
    public CommonResult<Boolean> insertCollection(Collection<ActivityInfoPO> param) {
        Iterator<ActivityInfoPO> iterator = param.iterator();
        while(iterator.hasNext()){
            iterator.next().setId(idGenerateable.getUniqueID());
        }
        return super.insertCollection(param);
    }

    @Override
    public CommonResult<Boolean> logicDelete(Long param) {
        long result = activityInfoDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_EXPIRE);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<ActivityInfoVO>> listActivityInfoVO(ActivityInfoQO param) {
        List<ActivityInfoPO> activityInfoPOList = activityInfoService.list(param).getResult();
        if(null == activityInfoPOList || activityInfoPOList.size() == 0) {
            return CommonResult.successReturn(CollectionUtils.EMPTY_LIST);
        }
        List<ActivityInfoVO> activityInfoVOList = new ArrayList<>(activityInfoPOList.size());
        for(ActivityInfoPO activityInfoPO: activityInfoPOList){
            ActivityInfoVO activityInfoVO = new ActivityInfoVO(activityInfoPO);
            activityInfoVOList.add(activityInfoVO);
        }

        return CommonResult.successReturn(activityInfoVOList);
    }
}
