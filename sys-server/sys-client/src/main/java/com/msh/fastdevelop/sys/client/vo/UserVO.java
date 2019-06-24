package com.msh.fastdevelop.sys.client.vo;

import com.msh.fastdevelop.sys.client.po.UserPO;
import java.util.Date;
import java.util.Set;

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
public class UserVO extends UserPO {
	@ApiModelProperty("权限id")
	private Set<Long> roleIds;

	public UserVO(){}
	public UserVO(UserPO userPO){
		this.setId(userPO.getId());
		this.setUsername(userPO.getUsername());
		this.setNickname(userPO.getNickname());
		this.setStatus(userPO.getStatus());
		this.setUpdateVersion(userPO.getUpdateVersion());
		this.setCreateTime(userPO.getCreateTime());
		this.setUpdateTime(userPO.getUpdateTime());
	}
}


