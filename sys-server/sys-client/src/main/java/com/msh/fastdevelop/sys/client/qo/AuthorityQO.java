package com.msh.fastdevelop.sys.client.qo;

import java.util.Date;
import java.util.Set;

import com.msh.frame.client.base.BaseQO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-19 18:16:57
 */
@ApiModel
@Data
public class AuthorityQO extends BaseQO {
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

	@ApiModelProperty("状态")
	private Integer status;

	@ApiModelProperty("更新版本")
	private Integer updateVersion;

	@ApiModelProperty("创建时间")
	private Date createTime;

	@ApiModelProperty("更新时间")
	private Date updateTime;

    @ApiModelProperty("大于等于status")
    private Integer egtStatus;

	@ApiModelProperty("in查询")
    private Set<Long> inIds;

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



