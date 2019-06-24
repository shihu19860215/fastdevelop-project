package com.msh.fastdevelop.sys.client.vo;

import com.msh.fastdevelop.sys.client.po.AuthorityPO;
import java.util.Date;
import java.util.List;

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
public class AuthorityVO extends AuthorityPO {
	private String typeMeaning;
	private String parentName;
	private List<AuthorityVO> children;

	public AuthorityVO(){}
	public AuthorityVO(AuthorityPO authorityPO){
		this.setId(authorityPO.getId());
		this.setName(authorityPO.getName());
		this.setCode(authorityPO.getCode());
		this.setParentId(authorityPO.getParentId());
		this.setLayer(authorityPO.getLayer());
		this.setType(authorityPO.getType());
		this.setSort(authorityPO.getSort());
		this.setIcon(authorityPO.getIcon());
		this.setStatus(authorityPO.getStatus());
		this.setUpdateVersion(authorityPO.getUpdateVersion());
		this.setCreateTime(authorityPO.getCreateTime());
		this.setUpdateTime(authorityPO.getUpdateTime());
	}
}


