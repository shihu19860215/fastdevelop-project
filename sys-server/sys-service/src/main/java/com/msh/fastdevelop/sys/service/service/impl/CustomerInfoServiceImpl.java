package com.msh.fastdevelop.sys.service.service.impl;;

import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.fastdevelop.sys.client.po.CustomerInfoPO;
import com.msh.fastdevelop.sys.client.qo.CustomerInfoQO;
import com.msh.fastdevelop.sys.client.vo.CustomerInfoVO;
import com.msh.fastdevelop.sys.service.dao.CustomerInfoDao;
import com.msh.fastdevelop.sys.service.service.CustomerInfoService;
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
public class CustomerInfoServiceImpl extends BaseServiceImpl<CustomerInfoPO,CustomerInfoQO> implements CustomerInfoService {
    @Autowired
    private CustomerInfoDao customerInfoDao;
    @Autowired
    private CustomerInfoService customerInfoService;
    @Autowired
    private IdGenerateable idGenerateable;

    @Override
    public CommonResult<List<CustomerInfoPO>> list(CustomerInfoQO param) {
        param.setEgtStatus(0);
        return super.list(param);
    }

    @Override
    public CommonResult<Boolean> insert(CustomerInfoPO param) {
        param.setId(idGenerateable.getUniqueID());
        return super.insert(param);
    }

    @Override
    public CommonResult<Boolean> insertCollection(Collection<CustomerInfoPO> param) {
        Iterator<CustomerInfoPO> iterator = param.iterator();
        while(iterator.hasNext()){
            iterator.next().setId(idGenerateable.getUniqueID());
        }
        return super.insertCollection(param);
    }

    @Override
    public CommonResult<Boolean> logicDelete(Long param) {
        long result = customerInfoDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_EXPIRE);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<CustomerInfoVO>> listCustomerInfoVO(CustomerInfoQO param) {
        List<CustomerInfoPO> customerInfoPOList = customerInfoService.list(param).getResult();
        if(null == customerInfoPOList || customerInfoPOList.size() == 0) {
            return CommonResult.successReturn(CollectionUtils.EMPTY_LIST);
        }
        List<CustomerInfoVO> customerInfoVOList = new ArrayList<>(customerInfoPOList.size());
        for(CustomerInfoPO customerInfoPO: customerInfoPOList){
            CustomerInfoVO customerInfoVO = new CustomerInfoVO(customerInfoPO);
            customerInfoVOList.add(customerInfoVO);
        }

        return CommonResult.successReturn(customerInfoVOList);
    }
}
