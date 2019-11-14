package com.msh.fastdevelop.sys.client.vo;

import com.msh.fastdevelop.sys.client.po.AuditPO;
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
public class AuditVO extends AuditPO {
	@ApiModelProperty("实际意思")
	private String meaning;

	public AuditVO(){}
	public AuditVO(AuditPO auditPO){
		this.setId(auditPO.getId());
		this.setClassName(auditPO.getClassName());
		this.setFieldName(auditPO.getFieldName());
		this.setPrimaryKeyId(auditPO.getPrimaryKeyId());
		this.setBeforeValue(auditPO.getBeforeValue());
		this.setAfterValue(auditPO.getAfterValue());
		this.setOperatorId(auditPO.getOperatorId());
		this.setComment(auditPO.getComment());
		this.setStatus(auditPO.getStatus());
		this.setUpdateVersion(auditPO.getUpdateVersion());
		this.setCreateTime(auditPO.getCreateTime());
		this.setUpdateTime(auditPO.getUpdateTime());
	}
}


