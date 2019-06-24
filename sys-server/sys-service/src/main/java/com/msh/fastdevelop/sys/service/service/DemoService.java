package com.msh.fastdevelop.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.fastdevelop.sys.client.po.DemoPO;
import com.msh.fastdevelop.sys.client.qo.DemoQO;
import com.msh.fastdevelop.sys.client.vo.DemoVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-18 20:51:33
 */
public interface DemoService extends BaseService<DemoPO,DemoQO> {
        CommonResult<Boolean> logicDelete(Long id);
        CommonResult<List<DemoVO>> listDemoVO(DemoQO param);
}
