package com.msh.fastdevelop.sys.service.service;;

import com.msh.frame.client.base.BasePO;
import com.msh.frame.client.base.BaseService;
import com.msh.fastdevelop.sys.client.po.AuditPO;
import com.msh.fastdevelop.sys.client.qo.AuditQO;
import com.msh.fastdevelop.sys.client.vo.AuditVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-29 14:15:29
 */
public interface AuditService extends BaseService<AuditPO,AuditQO> {
        CommonResult<Boolean> logicDelete(Long id);
        CommonResult<List<AuditVO>> listAuditVO(AuditQO param);
        CommonResult<BasePO> audit(BasePO newPO, BasePO oldPO);
}
