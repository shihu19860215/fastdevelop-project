package com.msh.fastdevelop.sys.client.po;


import java.util.Date;
import com.msh.frame.client.base.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-07-22 14:50:38
 */
@ApiModel
public class ColumnDictPO extends BasePO{
	@ApiModelProperty("字段id")
	private Long columnId;

	@ApiModelProperty("数据库值")
	private Integer databaseValue;

	@ApiModelProperty("实际意思")
	private String meaning;

	@ApiModelProperty("状态")
	private Integer status;

	@ApiModelProperty("更新版本")
	private Integer updateVersion;

	@ApiModelProperty("创建时间")
	private Date createTime;

	@ApiModelProperty("更新时间")
	private Date updateTime;


	public void setColumnId(Long value) {
		this.columnId = value;
	}

	public Long getColumnId() {
		return this.columnId;
	}

	public void setDatabaseValue(Integer value) {
		this.databaseValue = value;
	}

	public Integer getDatabaseValue() {
		return this.databaseValue;
	}

	public void setMeaning(String value) {
		this.meaning = value;
	}

	public String getMeaning() {
		return this.meaning;
	}

	public void setStatus(Integer value) {
		this.status = value;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setUpdateVersion(Integer value) {
		this.updateVersion = value;
	}

	public Integer getUpdateVersion() {
		return this.updateVersion;
	}

	public void setCreateTime(Date value) {
		this.createTime = value;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setUpdateTime(Date value) {
		this.updateTime = value;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}


	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		boolean nullFlag=false;
		sb.append("ColumnDictPO{");
		if(null!=id){
			if(nullFlag){
				sb.append(",id=").append(id);
			}else {
				sb.append("id=").append(id);
				nullFlag=true;
			}
		}
		if(null!=columnId){
			if(nullFlag){
				sb.append(",columnId=").append(columnId);
			}else {
				sb.append("columnId=").append(columnId);
				nullFlag=true;
			}
		}
		if(null!=databaseValue){
			if(nullFlag){
				sb.append(",databaseValue=").append(databaseValue);
			}else {
				sb.append("databaseValue=").append(databaseValue);
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



