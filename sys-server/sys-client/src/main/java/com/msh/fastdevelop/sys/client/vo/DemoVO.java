package com.msh.fastdevelop.sys.client.vo;

import com.msh.fastdevelop.sys.client.po.DemoPO;
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
public class DemoVO extends DemoPO {

	public DemoVO(){}
	public DemoVO(DemoPO demoPO){
		this.setId(demoPO.getId());
		this.setStatus(demoPO.getStatus());
		this.setUpdateVersion(demoPO.getUpdateVersion());
		this.setCreateTime(demoPO.getCreateTime());
		this.setUpdateTime(demoPO.getUpdateTime());
	}
}


