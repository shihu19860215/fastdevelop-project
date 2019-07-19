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
public class AuditConfigurePO extends BasePO{
	@ApiModelProperty("类名")
	private String className;

	@ApiModelProperty("字段名")
	private String fieldName;

	@ApiModelProperty("实际意思")
	private String meaning;



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

	public void setMeaning(String value) {
		this.meaning = value;
	}

	public String getMeaning() {
		return this.meaning;
	}



	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		boolean nullFlag=false;
		sb.append("AuditConfigurePO{");
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
		if(null!=meaning){
			if(nullFlag){
				sb.append(",meaning=").append(meaning);
			}else {
				sb.append("meaning=").append(meaning);
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



