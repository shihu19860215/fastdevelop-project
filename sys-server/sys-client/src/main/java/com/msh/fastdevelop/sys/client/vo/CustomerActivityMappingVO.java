package com.msh.fastdevelop.sys.client.vo;

import com.msh.fastdevelop.sys.client.po.CustomerActivityMappingPO;
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
public class CustomerActivityMappingVO extends CustomerActivityMappingPO {

	public CustomerActivityMappingVO(){}
	public CustomerActivityMappingVO(CustomerActivityMappingPO customerActivityMappingPO){
		this.setId(customerActivityMappingPO.getId());
		this.setCustomerId(customerActivityMappingPO.getCustomerId());
		this.setActivityId(customerActivityMappingPO.getActivityId());
		this.setStatus(customerActivityMappingPO.getStatus());
		this.setUpdateVersion(customerActivityMappingPO.getUpdateVersion());
		this.setCreateTime(customerActivityMappingPO.getCreateTime());
		this.setUpdateTime(customerActivityMappingPO.getUpdateTime());
	}
}


