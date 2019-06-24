package com.msh.fastdevelop.sys.client.vo;

import com.msh.fastdevelop.sys.client.po.CustomerInfoPO;
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
public class CustomerInfoVO extends CustomerInfoPO {

	public CustomerInfoVO(){}
	public CustomerInfoVO(CustomerInfoPO customerInfoPO){
		this.setId(customerInfoPO.getId());
		this.setName(customerInfoPO.getName());
		this.setCompany(customerInfoPO.getCompany());
		this.setPosition(customerInfoPO.getPosition());
		this.setMember(customerInfoPO.getMember());
		this.setBirthday(customerInfoPO.getBirthday());
		this.setTel(customerInfoPO.getTel());
		this.setMail(customerInfoPO.getMail());
		this.setAreaId(customerInfoPO.getAreaId());
		this.setSpareContacts(customerInfoPO.getSpareContacts());
		this.setAppraise(customerInfoPO.getAppraise());
		this.setStatus(customerInfoPO.getStatus());
		this.setUpdateVersion(customerInfoPO.getUpdateVersion());
		this.setCreateTime(customerInfoPO.getCreateTime());
		this.setUpdateTime(customerInfoPO.getUpdateTime());
	}
}


