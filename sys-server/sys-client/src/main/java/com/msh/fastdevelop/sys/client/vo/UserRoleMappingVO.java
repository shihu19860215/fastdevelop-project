package com.msh.fastdevelop.sys.client.vo;

import com.msh.fastdevelop.sys.client.po.UserRoleMappingPO;
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
public class UserRoleMappingVO extends UserRoleMappingPO {

	public UserRoleMappingVO(){}
	public UserRoleMappingVO(UserRoleMappingPO userRoleMappingPO){
		this.setId(userRoleMappingPO.getId());
		this.setUserId(userRoleMappingPO.getUserId());
		this.setRoleId(userRoleMappingPO.getRoleId());
		this.setStatus(userRoleMappingPO.getStatus());
		this.setUpdateVersion(userRoleMappingPO.getUpdateVersion());
		this.setCreateTime(userRoleMappingPO.getCreateTime());
		this.setUpdateTime(userRoleMappingPO.getUpdateTime());
	}
}


