package com.msh.fastdevelop.sys.client.model;

import com.msh.fastdevelop.sys.client.vo.AuthorityVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class UserInfo {
    @ApiModelProperty("用户id")
    private Long userId;
    @ApiModelProperty("昵称")
    private String nickName;
    @ApiModelProperty("权限id")
    private Set<Long> authIds;
    @ApiModelProperty("url权限")
    private Set<String> authUrls;
    @ApiModelProperty("菜单列表")
    private List<AuthorityVO> menuList;

    public UserInfo() {
    }
}
