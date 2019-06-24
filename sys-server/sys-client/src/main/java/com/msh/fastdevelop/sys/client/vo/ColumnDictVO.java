package com.msh.fastdevelop.sys.client.vo;

import com.msh.fastdevelop.sys.client.po.ColumnDictPO;
import java.util.Date;
import com.msh.frame.client.base.BaseQO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-19 20:58:20
 */
@ApiModel
public class ColumnDictVO extends ColumnDictPO {

	public ColumnDictVO(){}
	public ColumnDictVO(ColumnDictPO columnDictPO){
		this.setId(columnDictPO.getId());
		this.setTableName(columnDictPO.getTableName());
		this.setColumnName(columnDictPO.getColumnName());
		this.setDatabaseValue(columnDictPO.getDatabaseValue());
		this.setMeaning(columnDictPO.getMeaning());
		this.setStatus(columnDictPO.getStatus());
		this.setUpdateVersion(columnDictPO.getUpdateVersion());
		this.setCreateTime(columnDictPO.getCreateTime());
		this.setUpdateTime(columnDictPO.getUpdateTime());
	}
}


