package com.msh.fastdevelop.sys.web.util;

import com.msh.fastdevelop.sys.client.model.UserInfo;

import javax.servlet.http.HttpSession;

public class SessionUtil {
    public static UserInfo getUserInfo(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        return userInfo;
    }
}
