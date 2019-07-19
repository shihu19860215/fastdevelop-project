package com.msh.fastdevelop.sys.client.po;


import java.util.Date;
import com.msh.frame.client.base.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-19 18:16:57
 */
@ApiModel
public class AuthorityPO extends BasePO{
	@ApiModelProperty("权限名")
	private String name;

	@ApiModelProperty("编号")
	private String code;

	@ApiModelProperty("父权限")
	private Long parentId;

	@ApiModelProperty("层级")
	private Integer layer;

	@ApiModelProperty("类型")
	private Integer type;

	@ApiModelProperty("排序值")
	private Integer sort;

	@ApiModelProperty("图标")
	private String icon;



	public void setName(String value) {
		this.name = value;
	}

	public String getName() {
		return this.name;
	}

	public void setCode(String value) {
		this.code = value;
	}

	public String getCode() {
		return this.code;
	}

	public void setParentId(Long value) {
		this.parentId = value;
	}

	public Long getParentId() {
		return this.parentId;
	}

	public void setLayer(Integer value) {
		this.layer = value;
	}

	public Integer getLayer() {
		return this.layer;
	}

	public void setType(Integer value) {
		this.type = value;
	}

	public Integer getType() {
		return this.type;
	}

	public void setSort(Integer value) {
		this.sort = value;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setIcon(String value) {
		this.icon = value;
	}

	public String getIcon() {
		return this.icon;
	}



	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		boolean nullFlag=false;
		sb.append("AuthorityPO{");
		if(null!=id){
			if(nullFlag){
				sb.append(",id=").append(id);
			}else {
				sb.append("id=").append(id);
				nullFlag=true;
			}
		}
		if(null!=name){
			if(nullFlag){
				sb.append(",name=").append(name);
			}else {
				sb.append("name=").append(name);
				nullFlag=true;
			}
		}
		if(null!=code){
			if(nullFlag){
				sb.append(",code=").append(code);
			}else {
				sb.append("code=").append(code);
				nullFlag=true;
			}
		}
		if(null!=parentId){
			if(nullFlag){
				sb.append(",parentId=").append(parentId);
			}else {
				sb.append("parentId=").append(parentId);
				nullFlag=true;
			}
		}
		if(null!=layer){
			if(nullFlag){
				sb.append(",layer=").append(layer);
			}else {
				sb.append("layer=").append(layer);
				nullFlag=true;
			}
		}
		if(null!=type){
			if(nullFlag){
				sb.append(",type=").append(type);
			}else {
				sb.append("type=").append(type);
				nullFlag=true;
			}
		}
		if(null!=sort){
			if(nullFlag){
				sb.append(",sort=").append(sort);
			}else {
				sb.append("sort=").append(sort);
				nullFlag=true;
			}
		}
		if(null!=icon){
			if(nullFlag){
				sb.append(",icon=").append(icon);
			}else {
				sb.append("icon=").append(icon);
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
		sb.append('}');
		return sb.toString();
	}
}



