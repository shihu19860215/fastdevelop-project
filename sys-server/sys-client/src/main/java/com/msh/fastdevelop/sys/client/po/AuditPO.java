package com.msh.fastdevelop.sys.client.po;


import java.util.Date;
import com.msh.frame.client.base.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-29 14:15:29
 */
@ApiModel
public class AuditPO extends BasePO{
	@ApiModelProperty("类名")
	private String className;

	@ApiModelProperty("字段名")
	private String fieldName;

	@ApiModelProperty("主键id")
	private Long primaryKeyId;

	@ApiModelProperty("修改前值")
	private String beforeValue;

	@ApiModelProperty("修改后值")
	private String afterValue;


	@ApiModelProperty("备注")
	private String comment;



	public void setClassName(String value) {
		this.className = value;
	}

	public String getClassName() {
		return this.className;
	}

	public void setFieldName(String value) {
		this.fieldName = value;
	}

	public String getFieldName() {
		return this.fieldName;
	}

	public void setPrimaryKeyId(Long value) {
		this.primaryKeyId = value;
	}

	public Long getPrimaryKeyId() {
		return this.primaryKeyId;
	}

	public void setBeforeValue(String value) {
		this.beforeValue = value;
	}

	public String getBeforeValue() {
		return this.beforeValue;
	}

	public void setAfterValue(String value) {
		this.afterValue = value;
	}

	public String getAfterValue() {
		return this.afterValue;
	}

	public void setComment(String value) {
		this.comment = value;
	}

	public String getComment() {
		return this.comment;
	}


	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		boolean nullFlag=false;
		sb.append("AuditPO{");
		if(null!=id){
			if(nullFlag){
				sb.append(",id=").append(id);
			}else {
				sb.append("id=").append(id);
				nullFlag=true;
			}
		}
		if(null!=className){
			if(nullFlag){
				sb.append(",className=").append(className);
			}else {
				sb.append("className=").append(className);
				nullFlag=true;
			}
		}
		if(null!=fieldName){
			if(nullFlag){
				sb.append(",fieldName=").append(fieldName);
			}else {
				sb.append("fieldName=").append(fieldName);
				nullFlag=true;
			}
		}
		if(null!=primaryKeyId){
			if(nullFlag){
				sb.append(",primaryKeyId=").append(primaryKeyId);
			}else {
				sb.append("primaryKeyId=").append(primaryKeyId);
				nullFlag=true;
			}
		}
		if(null!=beforeValue){
			if(nullFlag){
				sb.append(",beforeValue=").append(beforeValue);
			}else {
				sb.append("beforeValue=").append(beforeValue);
				nullFlag=true;
			}
		}
		if(null!=afterValue){
			if(nullFlag){
				sb.append(",afterValue=").append(afterValue);
			}else {
				sb.append("afterValue=").append(afterValue);
				nullFlag=true;
			}
		}
		if(null!=operatorId){
			if(nullFlag){
				sb.append(",operatorId=").append(operatorId);
			}else {
				sb.append("operatorId=").append(operatorId);
				nullFlag=true;
			}
		}
		if(null!=comment){
			if(nullFlag){
				sb.append(",comment=").append(comment);
			}else {
				sb.append("comment=").append(comment);
				nullFlag=true;
			}
		}
		if(null!=status){
			if(nullFlag){
				sb.append(",status=").append(status);
			}else {
				sb.append("status=").append(status);
				nullFlag=true;
			}
		}
		if(null!=updateVersion){
			if(nullFlag){
				sb.append(",updateVersion=").append(updateVersion);
			}else {
				sb.append("updateVersion=").append(updateVersion);
				nullFlag=true;
			}
		}
		if(null!=createTime){
			if(nullFlag){
				sb.append(",createTime=").append(createTime);
			}else {
				sb.append("createTime=").append(createTime);
				nullFlag=true;
			}
		}
		if(null!=updateTime){
			if(nullFlag){
				sb.append(",updateTime=").append(updateTime);
			}else {
				sb.append("updateTime=").append(updateTime);
				nullFlag=true;
			}
		}
		sb.append('}');
		return sb.toString();
	}
}



