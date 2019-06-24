package com.msh.fastdevelop.sys.client.po;


import java.util.Date;
import com.msh.frame.client.base.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-18 20:51:33
 */
@ApiModel
public class CustomerActivityMappingPO extends BasePO{
	@ApiModelProperty("客户id")
	private Long customerId;

	@ApiModelProperty("活动id")
	private Long activityId;

	@ApiModelProperty("")
	private Integer status;

	@ApiModelProperty("")
	private Integer updateVersion;

	@ApiModelProperty("")
	private Date createTime;

	@ApiModelProperty("")
	private Date updateTime;


	public void setCustomerId(Long value) {
		this.customerId = value;
	}

	public Long getCustomerId() {
		return this.customerId;
	}

	public void setActivityId(Long value) {
		this.activityId = value;
	}

	public Long getActivityId() {
		return this.activityId;
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
		sb.append("CustomerActivityMappingPO{");
		if(null!=id){
			if(nullFlag){
				sb.append(",id=").append(id);
			}else {
				sb.append("id=").append(id);
				nullFlag=true;
			}
		}
		if(null!=customerId){
			if(nullFlag){
				sb.append(",customerId=").append(customerId);
			}else {
				sb.append("customerId=").append(customerId);
				nullFlag=true;
			}
		}
		if(null!=activityId){
			if(nullFlag){
				sb.append(",activityId=").append(activityId);
			}else {
				sb.append("activityId=").append(activityId);
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



