package com.msh.fastdevelop.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.fastdevelop.sys.client.po.ColumnInfoPO;
import com.msh.fastdevelop.sys.client.qo.ColumnInfoQO;
import com.msh.fastdevelop.sys.client.vo.ColumnInfoVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-11-14 16:17:56
 */
public interface ColumnInfoService extends BaseService<ColumnInfoPO,ColumnInfoQO> {
        CommonResult<Boolean> logicDelete(Long id);
        CommonResult<List<ColumnInfoVO>> listColumnInfoVO(ColumnInfoQO param);
        CommonResult<ColumnInfoVO> getColumnInfoVO(String tableName, String columnName);

}
