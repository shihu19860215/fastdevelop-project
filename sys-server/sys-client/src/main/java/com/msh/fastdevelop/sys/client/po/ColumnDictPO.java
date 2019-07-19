package com.msh.fastdevelop.sys.client.po;


import java.util.Date;
import com.msh.frame.client.base.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-19 20:58:20
 */
@ApiModel
public class ColumnDictPO extends BasePO{
	@ApiModelProperty("表名")
	private String tableName;

	@ApiModelProperty("字段名")
	private String columnName;

	@ApiModelProperty("数据库值")
	private Integer databaseValue;

	@ApiModelProperty("实际意思")
	private String meaning;



	public void setTableName(String value) {
		this.tableName = value;
	}

	public String getTableName() {
		return this.tableName;
	}

	public void setColumnName(String value) {
		this.columnName = value;
	}

	public String getColumnName() {
		return this.columnName;
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
		if(null!=tableName){
			if(nullFlag){
				sb.append(",tableName=").append(tableName);
			}else {
				sb.append("tableName=").append(tableName);
				nullFlag=true;
			}
		}
		if(null!=columnName){
			if(nullFlag){
				sb.append(",columnName=").append(columnName);
			}else {
				sb.append("columnName=").append(columnName);
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



