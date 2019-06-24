package com.msh.fastdevelop.sys.client.po;


import java.util.Date;
import com.msh.frame.client.base.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-18 20:51:33
 */
@ApiModel
public class AreaPO extends BasePO{
	@ApiModelProperty("行政简码")
	private Integer simpleCode;

	@ApiModelProperty("简地址")
	private String simpleAddr;

	@ApiModelProperty("全路径地址")
	private String fullAddr;

	@ApiModelProperty("等级")
	private Integer layer;

	@ApiModelProperty("父编码")
	private Long parentCode;

	@ApiModelProperty("省")
	private String province;

	@ApiModelProperty("城市")
	private String city;

	@ApiModelProperty("区域")
	private String area;

	@ApiModelProperty("状态")
	private Integer status;

	@ApiModelProperty("创建时间")
	private Date createTime;

	@ApiModelProperty("更新时间")
	private Date updateTime;


	public void setSimpleCode(Integer value) {
		this.simpleCode = value;
	}

	public Integer getSimpleCode() {
		return this.simpleCode;
	}

	public void setSimpleAddr(String value) {
		this.simpleAddr = value;
	}

	public String getSimpleAddr() {
		return this.simpleAddr;
	}

	public void setFullAddr(String value) {
		this.fullAddr = value;
	}

	public String getFullAddr() {
		return this.fullAddr;
	}

	public void setLayer(Integer value) {
		this.layer = value;
	}

	public Integer getLayer() {
		return this.layer;
	}

	public void setParentCode(Long value) {
		this.parentCode = value;
	}

	public Long getParentCode() {
		return this.parentCode;
	}

	public void setProvince(String value) {
		this.province = value;
	}

	public String getProvince() {
		return this.province;
	}

	public void setCity(String value) {
		this.city = value;
	}

	public String getCity() {
		return this.city;
	}

	public void setArea(String value) {
		this.area = value;
	}

	public String getArea() {
		return this.area;
	}

	public void setStatus(Integer value) {
		this.status = value;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setCreateTime(Date value) {
		this.createTime = value;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setUpdateTime(Date value) {
		this.updateTime = value;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}


	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		boolean nullFlag=false;
		sb.append("AreaPO{");
		if(null!=id){
			if(nullFlag){
				sb.append(",id=").append(id);
			}else {
				sb.append("id=").append(id);
				nullFlag=true;
			}
		}
		if(null!=simpleCode){
			if(nullFlag){
				sb.append(",simpleCode=").append(simpleCode);
			}else {
				sb.append("simpleCode=").append(simpleCode);
				nullFlag=true;
			}
		}
		if(null!=simpleAddr){
			if(nullFlag){
				sb.append(",simpleAddr=").append(simpleAddr);
			}else {
				sb.append("simpleAddr=").append(simpleAddr);
				nullFlag=true;
			}
		}
		if(null!=fullAddr){
			if(nullFlag){
				sb.append(",fullAddr=").append(fullAddr);
			}else {
				sb.append("fullAddr=").append(fullAddr);
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
		if(null!=parentCode){
			if(nullFlag){
				sb.append(",parentCode=").append(parentCode);
			}else {
				sb.append("parentCode=").append(parentCode);
				nullFlag=true;
			}
		}
		if(null!=province){
			if(nullFlag){
				sb.append(",province=").append(province);
			}else {
				sb.append("province=").append(province);
				nullFlag=true;
			}
		}
		if(null!=city){
			if(nullFlag){
				sb.append(",city=").append(city);
			}else {
				sb.append("city=").append(city);
				nullFlag=true;
			}
		}
		if(null!=area){
			if(nullFlag){
				sb.append(",area=").append(area);
			}else {
				sb.append("area=").append(area);
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



