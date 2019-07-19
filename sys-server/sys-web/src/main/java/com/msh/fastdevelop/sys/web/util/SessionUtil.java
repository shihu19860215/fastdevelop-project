package com.msh.fastdevelop.sys.web.util;

import com.msh.fastdevelop.sys.client.model.UserInfo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

public class SessionUtil {
    public static UserInfo getUserInfo(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        return userInfo;
    }


    public static Long getUserId(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpSession session = requestAttributes.getRequest().getSession();
        UserInfo userInfo = SessionUtil.getUserInfo(session);
        if(null != userInfo){
            return userInfo.getUserId();
        }
        return 0L;
    }
}
