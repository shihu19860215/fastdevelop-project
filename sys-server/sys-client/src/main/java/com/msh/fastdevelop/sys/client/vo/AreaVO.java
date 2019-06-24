package com.msh.fastdevelop.sys.client.vo;

import com.msh.fastdevelop.sys.client.po.AreaPO;
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
public class AreaVO extends AreaPO {

	public AreaVO(){}
	public AreaVO(AreaPO areaPO){
		this.setId(areaPO.getId());
		this.setSimpleCode(areaPO.getSimpleCode());
		this.setSimpleAddr(areaPO.getSimpleAddr());
		this.setFullAddr(areaPO.getFullAddr());
		this.setLayer(areaPO.getLayer());
		this.setParentCode(areaPO.getParentCode());
		this.setProvince(areaPO.getProvince());
		this.setCity(areaPO.getCity());
		this.setArea(areaPO.getArea());
		this.setStatus(areaPO.getStatus());
		this.setCreateTime(areaPO.getCreateTime());
		this.setUpdateTime(areaPO.getUpdateTime());
	}
}


