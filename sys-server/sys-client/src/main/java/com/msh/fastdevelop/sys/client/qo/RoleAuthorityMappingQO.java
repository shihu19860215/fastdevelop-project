package com.msh.fastdevelop.sys.client.qo;

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
public class RoleAuthorityMappingQO extends BaseQO {
	@ApiModelProperty("角色id")
	private Long roleId;

	@ApiModelProperty("权限id")
	private Long authorityId;

	@ApiModelProperty("状态")
	private Integer status;

	@ApiModelProperty("更新版本")
	private Integer updateVersion;

	@ApiModelProperty("创建时间")
	private Date createTime;

	@ApiModelProperty("更新时间")
	private Date updateTime;

    @ApiModelProperty("大于等于status")
    private Integer egtStatus;

	@ApiModelProperty("in角色id")
    private Set<Long> inRoleIds;

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



