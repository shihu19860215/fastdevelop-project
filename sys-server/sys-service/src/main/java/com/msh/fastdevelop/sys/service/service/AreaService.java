package com.msh.fastdevelop.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.fastdevelop.sys.client.po.AreaPO;
import com.msh.fastdevelop.sys.client.qo.AreaQO;
import com.msh.fastdevelop.sys.client.vo.AreaVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-24 20:24:20
 */
public interface AreaService extends BaseService<AreaPO,AreaQO> {
        CommonResult<Boolean> logicDelete(Long id);
        CommonResult<List<AreaVO>> listAreaVO(AreaQO param);
}
