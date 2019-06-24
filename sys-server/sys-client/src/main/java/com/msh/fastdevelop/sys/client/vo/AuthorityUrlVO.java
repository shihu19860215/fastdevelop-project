package com.msh.fastdevelop.sys.client.vo;

import com.msh.fastdevelop.sys.client.po.AuthorityUrlPO;
import java.util.Date;
import com.msh.frame.client.base.BaseQO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-19 18:16:57
 */
@ApiModel
@Data
public class AuthorityUrlVO extends AuthorityUrlPO {
	@ApiModelProperty("链接权限")
	private String linkAuthMeaning;
	@ApiModelProperty("权限名")
	private String authorityName;

	public AuthorityUrlVO(){}
	public AuthorityUrlVO(AuthorityUrlPO authorityUrlPO){
		this.setId(authorityUrlPO.getId());
		this.setAuthorityId(authorityUrlPO.getAuthorityId());
		this.setUrl(authorityUrlPO.getUrl());
		this.setLinkAuth(authorityUrlPO.getLinkAuth());
		this.setStatus(authorityUrlPO.getStatus());
		this.setUpdateVersion(authorityUrlPO.getUpdateVersion());
		this.setCreateTime(authorityUrlPO.getCreateTime());
		this.setUpdateTime(authorityUrlPO.getUpdateTime());
	}
}


