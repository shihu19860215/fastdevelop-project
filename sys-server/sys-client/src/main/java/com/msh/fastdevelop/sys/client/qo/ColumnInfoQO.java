package com.msh.fastdevelop.sys.client.qo;

import java.util.Date;
import com.msh.frame.client.base.BaseQO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-11-14 16:17:56
 */
@ApiModel
@Data
public class ColumnInfoQO extends BaseQO {
	@ApiModelProperty("表名")
	private String tableName;

	@ApiModelProperty("字段名")
	private String columnName;

	@ApiModelProperty("标题")
	private String title;

	@ApiModelProperty("状态")
	private Integer status;

	@ApiModelProperty("更新版本")
	private Integer updateVersion;

	@ApiModelProperty("创建时间")
	private Date createTime;

	@ApiModelProperty("更新时间")
	private Date updateTime;

    @ApiModelProperty("大于等于status")
    private Integer egtStatus;

@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		boolean nullFlag=false;
		sb.append("ColumnInfoPO{");
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
		if(null!=title){
		if(nullFlag){
		sb.append(",title=").append(title);
		}else {
		sb.append("title=").append(title);
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
		if(null!=page){
			if(nullFlag){
				sb.append(",page=").append(page);
			}else {
				sb.append("page=").append(page);
			}
		}
		sb.append('}');
		return sb.toString();
		}
}



