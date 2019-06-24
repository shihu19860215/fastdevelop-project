package com.msh.fastdevelop.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.fastdevelop.sys.client.po.ColumnDictPO;
import com.msh.fastdevelop.sys.client.qo.ColumnDictQO;
import com.msh.fastdevelop.sys.client.vo.ColumnDictVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-19 20:58:20
 */
public interface ColumnDictService extends BaseService<ColumnDictPO,ColumnDictQO> {
        CommonResult<Boolean> logicDelete(Long id);
        CommonResult<List<ColumnDictVO>> listColumnDictVO(ColumnDictQO param);
}
