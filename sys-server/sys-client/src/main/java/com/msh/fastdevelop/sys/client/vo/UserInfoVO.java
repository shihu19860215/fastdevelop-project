package com.msh.fastdevelop.sys.client.vo;

import com.msh.fastdevelop.sys.client.model.UserInfo;
import com.msh.fastdevelop.sys.client.po.UserPO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class UserInfoVO {
    private Long userId;
    private String nickName;
    private Set<Long> authIds;
    private List<AuthorityVO> menuList;

    public UserInfoVO() {
    }

    public UserInfoVO(UserInfo userInfo) {
        this.userId = userInfo.getUserId();
        this.nickName = userInfo.getNickName();
        this.authIds = userInfo.getAuthIds();
        this.menuList = userInfo.getMenuList();
    }
}
