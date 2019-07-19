package com.msh.fastdevelop.sys.client.qo;

import java.util.Collection;
import java.util.Date;
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
public class RoleQO extends BaseQO {
	@ApiModelProperty("角色名")
	private String name;

    @ApiModelProperty("大于等于status")
    private Integer egtStatus;

	@ApiModelProperty("in查询Id")
    private Collection<Long> inIds;
}



