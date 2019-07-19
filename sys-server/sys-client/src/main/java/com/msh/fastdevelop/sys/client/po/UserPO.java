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
public class UserPO extends BasePO{
	@ApiModelProperty("用户名")
	private String username;

	@ApiModelProperty("密码")
	private String password;

	@ApiModelProperty("昵称")
	private String nickname;


	public void setUsername(String value) {
		this.username = value;
	}

	public String getUsername() {
		return this.username;
	}

	public void setPassword(String value) {
		this.password = value;
	}

	public String getPassword() {
		return this.password;
	}

	public void setNickname(String value) {
		this.nickname = value;
	}

	public String getNickname() {
		return this.nickname;
	}


	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		boolean nullFlag=false;
		sb.append("UserPO{");
		if(null!=id){
			if(nullFlag){
				sb.append(",id=").append(id);
			}else {
				sb.append("id=").append(id);
				nullFlag=true;
			}
		}
		if(null!=username){
			if(nullFlag){
				sb.append(",username=").append(username);
			}else {
				sb.append("username=").append(username);
				nullFlag=true;
			}
		}
		if(null!=password){
			if(nullFlag){
				sb.append(",password=").append(password);
			}else {
				sb.append("password=").append(password);
				nullFlag=true;
			}
		}
		if(null!=nickname){
			if(nullFlag){
				sb.append(",nickname=").append(nickname);
			}else {
				sb.append("nickname=").append(nickname);
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



