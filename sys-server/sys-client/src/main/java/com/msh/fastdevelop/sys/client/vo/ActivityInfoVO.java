package com.msh.fastdevelop.sys.client.vo;

import com.msh.fastdevelop.sys.client.po.ActivityInfoPO;
import java.util.Date;
import com.msh.frame.client.base.BaseQO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-18 20:51:33
 */
@ApiModel
public class ActivityInfoVO extends ActivityInfoPO {

	public ActivityInfoVO(){}
	public ActivityInfoVO(ActivityInfoPO activityInfoPO){
		this.setId(activityInfoPO.getId());
		this.setName(activityInfoPO.getName());
		this.setNature(activityInfoPO.getNature());
		this.setActivityTime(activityInfoPO.getActivityTime());
		this.setContacts(activityInfoPO.getContacts());
		this.setStatus(activityInfoPO.getStatus());
		this.setUpdateVersion(activityInfoPO.getUpdateVersion());
		this.setCreateTime(activityInfoPO.getCreateTime());
		this.setUpdateTime(activityInfoPO.getUpdateTime());
	}
}


