package com.msh.fastdevelop.sys.client.vo;

import com.msh.fastdevelop.sys.client.po.RolePO;
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
public class RoleVO extends RolePO {
	private Set<Long> authIds;

	public RoleVO(){}
	public RoleVO(RolePO rolePO){
		this.setId(rolePO.getId());
		this.setName(rolePO.getName());
		this.setStatus(rolePO.getStatus());
		this.setUpdateVersion(rolePO.getUpdateVersion());
		this.setCreateTime(rolePO.getCreateTime());
		this.setUpdateTime(rolePO.getUpdateTime());
	}
}


