package com.msh.fastdevelop.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.fastdevelop.sys.client.po.CustomerActivityMappingPO;
import com.msh.fastdevelop.sys.client.qo.CustomerActivityMappingQO;
import com.msh.fastdevelop.sys.client.vo.CustomerActivityMappingVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-18 20:51:33
 */
public interface CustomerActivityMappingService extends BaseService<CustomerActivityMappingPO,CustomerActivityMappingQO> {
        CommonResult<Boolean> logicDelete(Long id);
        CommonResult<List<CustomerActivityMappingVO>> listCustomerActivityMappingVO(CustomerActivityMappingQO param);
}
