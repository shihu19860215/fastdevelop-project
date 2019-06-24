package com.msh.fastdevelop.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.fastdevelop.sys.client.po.SmsTemplatePO;
import com.msh.fastdevelop.sys.client.qo.SmsTemplateQO;
import com.msh.fastdevelop.sys.client.vo.SmsTemplateVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-18 20:51:33
 */
public interface SmsTemplateService extends BaseService<SmsTemplatePO,SmsTemplateQO> {
        CommonResult<Boolean> logicDelete(Long id);
        CommonResult<List<SmsTemplateVO>> listSmsTemplateVO(SmsTemplateQO param);
}
