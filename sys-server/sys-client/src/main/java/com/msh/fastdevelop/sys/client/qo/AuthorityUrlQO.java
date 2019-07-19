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
public class AuthorityUrlQO extends BaseQO {
	@ApiModelProperty("权限id")
	private Long authorityId;

	@ApiModelProperty("请求url")
	private String url;

	@ApiModelProperty("连接权限 1拥有权限可访问 2用户登录可访问 3无需登录可访问")
	private Integer linkAuth;

    @ApiModelProperty("大于等于status")
    private Integer egtStatus;


	@ApiModelProperty("in查询")
	private Set<Long> inAuthIds;

	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		boolean nullFlag=false;
		sb.append("AuthorityUrlPO{");
		if(null!=id){
		if(nullFlag){
		sb.append(",id=").append(id);
		}else {
		sb.append("id=").append(id);
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
		if(null!=url){
		if(nullFlag){
		sb.append(",url=").append(url);
		}else {
		sb.append("url=").append(url);
		nullFlag=true;
		}
		}
		if(null!=linkAuth){
		if(nullFlag){
		sb.append(",linkAuth=").append(linkAuth);
		}else {
		sb.append("linkAuth=").append(linkAuth);
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



