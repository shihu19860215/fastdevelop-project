package com.msh.fastdevelop.sys.service.define;


import com.msh.frame.client.common.CommonCode;

public class CommonCodeDef extends CommonCode {
    public static CommonCode URL_ERROR = new CommonCodeDef(400100, "错误的url");
    public static CommonCode NO_LOGIN = new CommonCodeDef(400101, "未登录");
    public static CommonCode NO_AUTH = new CommonCodeDef(400102, "没有权限");
    public static CommonCode IS_LOGIN = new CommonCodeDef(400103, "已经登录");
    public static CommonCode USERNAME_PASSWORD_ERROR = new CommonCodeDef(400104, "用户名或密码错误");
    public static CommonCode USER_DISABLE = new CommonCodeDef(400105, "用户已被禁用");

    private CommonCodeDef(Integer code, String message) {
        super(code, message);
    }
}
