package com.msh.fastdevelop.sys.client.qo;

import java.util.Date;
import com.msh.frame.client.base.BaseQO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-24 20:24:20
 */
@ApiModel
@Data
public class AreaQO extends BaseQO {
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

    @ApiModelProperty("大于等于status")
    private Integer egtStatus;

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
		if(null!=page){
			if(nullFlag){
				sb.append(",page=").append(page);
			}else {
				sb.append("page=").append(page);
			}
		}
		sb.append('}');
		return sb.toString();
		}
}



