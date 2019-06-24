package com.msh.fastdevelop.sys.service.service.impl;;

import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.fastdevelop.sys.client.po.AreaPO;
import com.msh.fastdevelop.sys.client.qo.AreaQO;
import com.msh.fastdevelop.sys.client.vo.AreaVO;
import com.msh.fastdevelop.sys.service.dao.AreaDao;
import com.msh.fastdevelop.sys.service.service.AreaService;
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
public class AreaServiceImpl extends BaseServiceImpl<AreaPO,AreaQO> implements AreaService {
    @Autowired
    private AreaDao areaDao;
    @Autowired
    private AreaService areaService;
    @Autowired
    private IdGenerateable idGenerateable;

    @Override
    public CommonResult<List<AreaPO>> list(AreaQO param) {
        param.setEgtStatus(0);
        return super.list(param);
    }

    @Override
    public CommonResult<Boolean> insert(AreaPO param) {
        param.setId(idGenerateable.getUniqueID());
        return super.insert(param);
    }

    @Override
    public CommonResult<Boolean> insertCollection(Collection<AreaPO> param) {
        Iterator<AreaPO> iterator = param.iterator();
        while(iterator.hasNext()){
            iterator.next().setId(idGenerateable.getUniqueID());
        }
        return super.insertCollection(param);
    }

    @Override
    public CommonResult<Boolean> logicDelete(Long param) {
        long result = areaDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_EXPIRE);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<AreaVO>> listAreaVO(AreaQO param) {
        List<AreaPO> areaPOList = areaService.list(param).getResult();
        if(null == areaPOList || areaPOList.size() == 0) {
            return CommonResult.successReturn(CollectionUtils.EMPTY_LIST);
        }
        List<AreaVO> areaVOList = new ArrayList<>(areaPOList.size());
        for(AreaPO areaPO: areaPOList){
            AreaVO areaVO = new AreaVO(areaPO);
            areaVOList.add(areaVO);
        }

        return CommonResult.successReturn(areaVOList);
    }
}
