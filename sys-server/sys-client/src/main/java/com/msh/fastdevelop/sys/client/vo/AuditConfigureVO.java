package com.msh.fastdevelop.sys.client.vo;

import com.msh.fastdevelop.sys.client.po.AuditConfigurePO;
import java.util.Date;
import com.msh.frame.client.base.BaseQO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-29 14:15:29
 */
@ApiModel
@Data
public class AuditConfigureVO extends AuditConfigurePO {

	public AuditConfigureVO(){}
	public AuditConfigureVO(AuditConfigurePO auditConfigurePO){
		this.setId(auditConfigurePO.getId());
		this.setClassName(auditConfigurePO.getClassName());
		this.setFieldName(auditConfigurePO.getFieldName());
		this.setMeaning(auditConfigurePO.getMeaning());
		this.setStatus(auditConfigurePO.getStatus());
		this.setUpdateVersion(auditConfigurePO.getUpdateVersion());
		this.setCreateTime(auditConfigurePO.getCreateTime());
		this.setUpdateTime(auditConfigurePO.getUpdateTime());
	}
}


