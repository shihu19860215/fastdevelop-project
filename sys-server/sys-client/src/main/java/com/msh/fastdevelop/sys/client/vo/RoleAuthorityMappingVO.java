package com.msh.fastdevelop.sys.client.vo;

import com.msh.fastdevelop.sys.client.po.RoleAuthorityMappingPO;
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
public class RoleAuthorityMappingVO extends RoleAuthorityMappingPO {

	public RoleAuthorityMappingVO(){}
	public RoleAuthorityMappingVO(RoleAuthorityMappingPO roleAuthorityMappingPO){
		this.setId(roleAuthorityMappingPO.getId());
		this.setRoleId(roleAuthorityMappingPO.getRoleId());
		this.setAuthorityId(roleAuthorityMappingPO.getAuthorityId());
		this.setStatus(roleAuthorityMappingPO.getStatus());
		this.setUpdateVersion(roleAuthorityMappingPO.getUpdateVersion());
		this.setCreateTime(roleAuthorityMappingPO.getCreateTime());
		this.setUpdateTime(roleAuthorityMappingPO.getUpdateTime());
	}
}


