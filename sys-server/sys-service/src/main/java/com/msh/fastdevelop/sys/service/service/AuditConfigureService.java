package com.msh.fastdevelop.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.fastdevelop.sys.client.po.AuditConfigurePO;
import com.msh.fastdevelop.sys.client.qo.AuditConfigureQO;
import com.msh.fastdevelop.sys.client.vo.AuditConfigureVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-29 14:15:29
 */
public interface AuditConfigureService extends BaseService<AuditConfigurePO,AuditConfigureQO> {
        CommonResult<Boolean> logicDelete(Long id);
        CommonResult<List<AuditConfigureVO>> listAuditConfigureVO(AuditConfigureQO param);
}
