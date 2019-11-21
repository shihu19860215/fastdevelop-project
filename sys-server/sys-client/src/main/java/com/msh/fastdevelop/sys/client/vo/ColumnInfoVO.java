package com.msh.fastdevelop.sys.client.vo;

import com.msh.fastdevelop.sys.client.po.ColumnDictPO;
import com.msh.fastdevelop.sys.client.po.ColumnInfoPO;
import java.util.Date;
import java.util.List;

import com.msh.frame.client.base.BaseQO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-11-14 16:17:56
 */
@ApiModel
@Data
public class ColumnInfoVO extends ColumnInfoPO {
	private List<ColumnDictPO> columnDictPOList;

	public ColumnInfoVO(){}
	public ColumnInfoVO(ColumnInfoPO columnInfoPO){
		this.setId(columnInfoPO.getId());
		this.setTableName(columnInfoPO.getTableName());
		this.setColumnName(columnInfoPO.getColumnName());
		this.setTitle(columnInfoPO.getTitle());
		this.setStatus(columnInfoPO.getStatus());
		this.setUpdateVersion(columnInfoPO.getUpdateVersion());
		this.setCreateTime(columnInfoPO.getCreateTime());
		this.setUpdateTime(columnInfoPO.getUpdateTime());
	}
}


