package com.msh.fastdevelop.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.fastdevelop.sys.client.po.EmailTemplatePO;
import com.msh.fastdevelop.sys.client.qo.EmailTemplateQO;
import com.msh.fastdevelop.sys.client.vo.EmailTemplateVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-18 20:51:33
 */
public interface EmailTemplateService extends BaseService<EmailTemplatePO,EmailTemplateQO> {
        CommonResult<Boolean> logicDelete(Long id);
        CommonResult<List<EmailTemplateVO>> listEmailTemplateVO(EmailTemplateQO param);
}
