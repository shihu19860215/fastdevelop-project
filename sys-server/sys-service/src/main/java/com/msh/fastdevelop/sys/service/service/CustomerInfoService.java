package com.msh.fastdevelop.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.fastdevelop.sys.client.po.CustomerInfoPO;
import com.msh.fastdevelop.sys.client.qo.CustomerInfoQO;
import com.msh.fastdevelop.sys.client.vo.CustomerInfoVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-18 20:51:33
 */
public interface CustomerInfoService extends BaseService<CustomerInfoPO,CustomerInfoQO> {
        CommonResult<Boolean> logicDelete(Long id);
        CommonResult<List<CustomerInfoVO>> listCustomerInfoVO(CustomerInfoQO param);
}
