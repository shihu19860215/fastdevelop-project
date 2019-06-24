package com.msh.fastdevelop.sys.client.vo;

import com.msh.fastdevelop.sys.client.po.EmailTemplatePO;
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
public class EmailTemplateVO extends EmailTemplatePO {

	public EmailTemplateVO(){}
	public EmailTemplateVO(EmailTemplatePO emailTemplatePO){
		this.setId(emailTemplatePO.getId());
		this.setTitle(emailTemplatePO.getTitle());
		this.setContent(emailTemplatePO.getContent());
		this.setStatus(emailTemplatePO.getStatus());
		this.setUpdateVersion(emailTemplatePO.getUpdateVersion());
		this.setCreateTime(emailTemplatePO.getCreateTime());
		this.setUpdateTime(emailTemplatePO.getUpdateTime());
	}
}


