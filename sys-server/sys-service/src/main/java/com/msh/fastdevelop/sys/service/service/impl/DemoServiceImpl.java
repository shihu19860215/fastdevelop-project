package com.msh.fastdevelop.sys.service.service.impl;;

import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.fastdevelop.sys.client.po.DemoPO;
import com.msh.fastdevelop.sys.client.qo.DemoQO;
import com.msh.fastdevelop.sys.client.vo.DemoVO;
import com.msh.fastdevelop.sys.service.dao.DemoDao;
import com.msh.fastdevelop.sys.service.service.DemoService;
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
public class DemoServiceImpl extends BaseServiceImpl<DemoPO,DemoQO> implements DemoService {
    @Autowired
    private DemoDao demoDao;
    @Autowired
    private DemoService demoService;
    @Autowired
    private IdGenerateable idGenerateable;

    @Override
    public CommonResult<List<DemoPO>> list(DemoQO param) {
        param.setEgtStatus(0);
        return super.list(param);
    }

    @Override
    public CommonResult<Boolean> insert(DemoPO param) {
        param.setId(idGenerateable.getUniqueID());
        return super.insert(param);
    }

    @Override
    public CommonResult<Boolean> insertCollection(Collection<DemoPO> param) {
        Iterator<DemoPO> iterator = param.iterator();
        while(iterator.hasNext()){
            iterator.next().setId(idGenerateable.getUniqueID());
        }
        return super.insertCollection(param);
    }

    @Override
    public CommonResult<Boolean> logicDelete(Long param) {
        long result = demoDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_EXPIRE);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<DemoVO>> listDemoVO(DemoQO param) {
        List<DemoPO> demoPOList = demoService.list(param).getResult();
        if(null == demoPOList || demoPOList.size() == 0) {
            return CommonResult.successReturn(CollectionUtils.EMPTY_LIST);
        }
        List<DemoVO> demoVOList = new ArrayList<>(demoPOList.size());
        for(DemoPO demoPO: demoPOList){
            DemoVO demoVO = new DemoVO(demoPO);
            demoVOList.add(demoVO);
        }

        return CommonResult.successReturn(demoVOList);
    }
}
