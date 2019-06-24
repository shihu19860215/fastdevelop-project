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
public class CustomerInfoPO extends BasePO{
	@ApiModelProperty("客户姓名")
	private String name;

	@ApiModelProperty("所在单位")
	private String company;

	@ApiModelProperty("职位")
	private String position;

	@ApiModelProperty("会员性质")
	private Integer member;

	@ApiModelProperty("生日")
	private Date birthday;

	@ApiModelProperty("手机号")
	private String tel;

	@ApiModelProperty("邮箱")
	private String mail;

	@ApiModelProperty("区域id")
	private Long areaId;

	@ApiModelProperty("备用联系人")
	private String spareContacts;

	@ApiModelProperty("评价")
	private String appraise;

	@ApiModelProperty("")
	private Integer status;

	@ApiModelProperty("更新版本")
	private Integer updateVersion;

	@ApiModelProperty("")
	private Date createTime;

	@ApiModelProperty("")
	private Date updateTime;


	public void setName(String value) {
		this.name = value;
	}

	public String getName() {
		return this.name;
	}

	public void setCompany(String value) {
		this.company = value;
	}

	public String getCompany() {
		return this.company;
	}

	public void setPosition(String value) {
		this.position = value;
	}

	public String getPosition() {
		return this.position;
	}

	public void setMember(Integer value) {
		this.member = value;
	}

	public Integer getMember() {
		return this.member;
	}

	public void setBirthday(Date value) {
		this.birthday = value;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setTel(String value) {
		this.tel = value;
	}

	public String getTel() {
		return this.tel;
	}

	public void setMail(String value) {
		this.mail = value;
	}

	public String getMail() {
		return this.mail;
	}

	public void setAreaId(Long value) {
		this.areaId = value;
	}

	public Long getAreaId() {
		return this.areaId;
	}

	public void setSpareContacts(String value) {
		this.spareContacts = value;
	}

	public String getSpareContacts() {
		return this.spareContacts;
	}

	public void setAppraise(String value) {
		this.appraise = value;
	}

	public String getAppraise() {
		return this.appraise;
	}

	public void setStatus(Integer value) {
		this.status = value;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setUpdateVersion(Integer value) {
		this.updateVersion = value;
	}

	public Integer getUpdateVersion() {
		return this.updateVersion;
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
		sb.append("CustomerInfoPO{");
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
		if(null!=company){
			if(nullFlag){
				sb.append(",company=").append(company);
			}else {
				sb.append("company=").append(company);
				nullFlag=true;
			}
		}
		if(null!=position){
			if(nullFlag){
				sb.append(",position=").append(position);
			}else {
				sb.append("position=").append(position);
				nullFlag=true;
			}
		}
		if(null!=member){
			if(nullFlag){
				sb.append(",member=").append(member);
			}else {
				sb.append("member=").append(member);
				nullFlag=true;
			}
		}
		if(null!=birthday){
			if(nullFlag){
				sb.append(",birthday=").append(birthday);
			}else {
				sb.append("birthday=").append(birthday);
				nullFlag=true;
			}
		}
		if(null!=tel){
			if(nullFlag){
				sb.append(",tel=").append(tel);
			}else {
				sb.append("tel=").append(tel);
				nullFlag=true;
			}
		}
		if(null!=mail){
			if(nullFlag){
				sb.append(",mail=").append(mail);
			}else {
				sb.append("mail=").append(mail);
				nullFlag=true;
			}
		}
		if(null!=areaId){
			if(nullFlag){
				sb.append(",areaId=").append(areaId);
			}else {
				sb.append("areaId=").append(areaId);
				nullFlag=true;
			}
		}
		if(null!=spareContacts){
			if(nullFlag){
				sb.append(",spareContacts=").append(spareContacts);
			}else {
				sb.append("spareContacts=").append(spareContacts);
				nullFlag=true;
			}
		}
		if(null!=appraise){
			if(nullFlag){
				sb.append(",appraise=").append(appraise);
			}else {
				sb.append("appraise=").append(appraise);
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



