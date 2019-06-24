package com.msh.fastdevelop.sys.web.api;

import com.msh.fastdevelop.sys.client.model.UserInfo;
import com.msh.fastdevelop.sys.client.po.UserPO;
import com.msh.fastdevelop.sys.client.qo.UserQO;
import com.msh.fastdevelop.sys.service.define.CommonCodeDef;
import com.msh.fastdevelop.sys.service.service.UserService;
import com.msh.frame.client.common.CommonResult;
import com.msh.frame.web.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;



@Api(description = "登录-api相关接口")
@RestController
@RequestMapping("/api/sys/login")
public class LoginApi extends BaseController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录接口", httpMethod = "GET", notes = "登录接口")
    @RequestMapping("login")
    public CommonResult<Boolean> login(@RequestParam("username")String username, @RequestParam("password")String password, HttpSession session) {
        CommonResult<UserInfo> userInfoCommonResult = userService.getUserInfo(username,password);
        if(null != userInfoCommonResult.getResult()){
            session.setAttribute("userInfo", userInfoCommonResult.getResult());
            return  CommonResult.successReturn(true);
        }
        return  CommonResult.errorReturn(CommonCodeDef.USERNAME_PASSWORD_ERROR);
    }

    @ApiOperation(value = "登出接口", httpMethod = "GET", notes = "登出接口")
    @RequestMapping("loginout")
    public CommonResult<Boolean> loginOut(HttpSession session) {
        session.removeAttribute("userInfo");
        return CommonResult.successReturn(true);
    }
}
