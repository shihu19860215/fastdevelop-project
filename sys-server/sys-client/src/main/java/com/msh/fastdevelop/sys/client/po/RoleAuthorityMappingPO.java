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
public class RoleAuthorityMappingPO extends BasePO{
	@ApiModelProperty("角色id")
	private Long roleId;

	@ApiModelProperty("权限id")
	private Long authorityId;



	public void setRoleId(Long value) {
		this.roleId = value;
	}

	public Long getRoleId() {
		return this.roleId;
	}

	public void setAuthorityId(Long value) {
		this.authorityId = value;
	}

	public Long getAuthorityId() {
		return this.authorityId;
	}



	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		boolean nullFlag=false;
		sb.append("RoleAuthorityMappingPO{");
		if(null!=id){
			if(nullFlag){
				sb.append(",id=").append(id);
			}else {
				sb.append("id=").append(id);
				nullFlag=true;
			}
		}
		if(null!=roleId){
			if(nullFlag){
				sb.append(",roleId=").append(roleId);
			}else {
				sb.append("roleId=").append(roleId);
				nullFlag=true;
			}
		}
		if(null!=authorityId){
			if(nullFlag){
				sb.append(",authorityId=").append(authorityId);
			}else {
				sb.append("authorityId=").append(authorityId);
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



