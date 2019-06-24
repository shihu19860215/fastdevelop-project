package com.msh.fastdevelop.sys.client.vo;

import com.msh.fastdevelop.sys.client.po.SmsTemplatePO;
import java.util.Date;
import com.msh.frame.client.base.BaseQO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-18 20:51:33
 */
@ApiModel
public class SmsTemplateVO extends SmsTemplatePO {

	public SmsTemplateVO(){}
	public SmsTemplateVO(SmsTemplatePO smsTemplatePO){
		this.setId(smsTemplatePO.getId());
		this.setTitle(smsTemplatePO.getTitle());
		this.setContent(smsTemplatePO.getContent());
		this.setSendDate(smsTemplatePO.getSendDate());
		this.setSendTime(smsTemplatePO.getSendTime());
		this.setType(smsTemplatePO.getType());
		this.setStatus(smsTemplatePO.getStatus());
		this.setUpdateVersion(smsTemplatePO.getUpdateVersion());
		this.setCreateTime(smsTemplatePO.getCreateTime());
		this.setUpdateTime(smsTemplatePO.getUpdateTime());
	}
}


