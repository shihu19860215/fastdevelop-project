package com.msh.fastdevelop.sys.client.vo;

import com.msh.fastdevelop.sys.client.po.ColumnDictPO;
import java.util.Date;
import com.msh.frame.client.base.BaseQO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-07-22 14:50:38
 */
@ApiModel
@Data
public class ColumnDictVO extends ColumnDictPO {

	public ColumnDictVO(){}
	public ColumnDictVO(ColumnDictPO columnDictPO){
		this.setId(columnDictPO.getId());
		this.setColumnId(columnDictPO.getColumnId());
		this.setDatabaseValue(columnDictPO.getDatabaseValue());
		this.setMeaning(columnDictPO.getMeaning());
		this.setStatus(columnDictPO.getStatus());
		this.setUpdateVersion(columnDictPO.getUpdateVersion());
		this.setCreateTime(columnDictPO.getCreateTime());
		this.setUpdateTime(columnDictPO.getUpdateTime());
	}
}


