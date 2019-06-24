package com.msh.fastdevelop.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.fastdevelop.sys.client.po.ActivityInfoPO;
import com.msh.fastdevelop.sys.client.qo.ActivityInfoQO;
import com.msh.fastdevelop.sys.client.vo.ActivityInfoVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-18 20:51:33
 */
public interface ActivityInfoService extends BaseService<ActivityInfoPO,ActivityInfoQO> {
        CommonResult<Boolean> logicDelete(Long id);
        CommonResult<List<ActivityInfoVO>> listActivityInfoVO(ActivityInfoQO param);
}
