package com.msh.fastdevelop.sys.client.qo;

import java.util.Date;
import com.msh.frame.client.base.BaseQO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-18 20:51:33
 */
@ApiModel
@Data
public class ActivityInfoQO extends BaseQO {
	@ApiModelProperty("活动名称")
	private String name;

	@ApiModelProperty("活动性质")
	private String nature;

	@ApiModelProperty("活动时间")
	private Date activityTime;

	@ApiModelProperty("对接人")
	private String contacts;

	@ApiModelProperty("")
	private Integer status;

	@ApiModelProperty("")
	private Integer updateVersion;

	@ApiModelProperty("")
	private Date createTime;

	@ApiModelProperty("")
	private Date updateTime;

    @ApiModelProperty("大于等于status")
    private Integer egtStatus;

@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		boolean nullFlag=false;
		sb.append("ActivityInfoPO{");
		if(null!=id){
		if(nullFlag){
		sb.append(",id=").append(id);
		}else {
		sb.append("id=").append(id);
		nullFlag=true;
		}
		}
		if(null!=name){
		if(nullFlag){
		sb.append(",name=").append(name);
		}else {
		sb.append("name=").append(name);
		nullFlag=true;
		}
		}
		if(null!=nature){
		if(nullFlag){
		sb.append(",nature=").append(nature);
		}else {
		sb.append("nature=").append(nature);
		nullFlag=true;
		}
		}
		if(null!=activityTime){
		if(nullFlag){
		sb.append(",activityTime=").append(activityTime);
		}else {
		sb.append("activityTime=").append(activityTime);
		nullFlag=true;
		}
		}
		if(null!=contacts){
		if(nullFlag){
		sb.append(",contacts=").append(contacts);
		}else {
		sb.append("contacts=").append(contacts);
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



