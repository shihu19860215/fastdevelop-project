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
public class ActivityInfoPO extends BasePO{
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


	public void setName(String value) {
		this.name = value;
	}

	public String getName() {
		return this.name;
	}

	public void setNature(String value) {
		this.nature = value;
	}

	public String getNature() {
		return this.nature;
	}

	public void setActivityTime(Date value) {
		this.activityTime = value;
	}

	public Date getActivityTime() {
		return this.activityTime;
	}

	public void setContacts(String value) {
		this.contacts = value;
	}

	public String getContacts() {
		return this.contacts;
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
		sb.append('}');
		return sb.toString();
	}
}



