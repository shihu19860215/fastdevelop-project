package com.msh.fastdevelop.sys.web.filter;

import com.msh.fastdevelop.sys.client.model.UserInfo;
import com.msh.fastdevelop.sys.service.define.CommonCodeDef;
import com.msh.fastdevelop.sys.service.service.AuthorityUrlService;
import com.msh.fastdevelop.sys.web.util.SessionUtil;
import com.msh.frame.client.common.CommonResult;
import com.msh.frame.web.util.HttpServletResponseUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class AuthorityFilter implements Filter {
    private AuthorityUrlService authorityUrlService;

    public AuthorityFilter(AuthorityUrlService authorityUrlService) {
        this.authorityUrlService = authorityUrlService;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        UserInfo userInfo = SessionUtil.getUserInfo(request.getSession());
        if(null != userInfo && 1L ==userInfo.getUserId()){
            userInfo.getAuthIds().add(1L);
            filterChain.doFilter(request, servletResponse);
            return;
        }
        Map<String, Integer> urlAuthMap = authorityUrlService.getUrlAuthIdMap().getResult();
        String uri =request.getRequestURI();
        Integer linkAuth = urlAuthMap.get(uri);
        if(null == linkAuth){
            HttpServletResponseUtil.outJson(CommonResult.errorReturn(CommonCodeDef.URL_ERROR),response);
            return;
        }
        switch (linkAuth){
            case 1:{
                userInfo = SessionUtil.getUserInfo(request.getSession());
                if(null == userInfo){
                    HttpServletResponseUtil.outJson(CommonResult.errorReturn(CommonCodeDef.NO_LOGIN),response);
                    return;
                }
                if(!userInfo.getAuthUrls().contains(uri)){
                    HttpServletResponseUtil.outJson(CommonResult.errorReturn(CommonCodeDef.NO_AUTH),response);
                    return;
                }
                break;
            }
            case 2:{
                userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
                if(null == userInfo){
                    HttpServletResponseUtil.outJson(CommonResult.errorReturn(CommonCodeDef.NO_LOGIN),response);
                    return;
                }
                break;
            }
            case 3:{
                break;
            }
            case 4:{
                userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
                if(null != userInfo){
                    HttpServletResponseUtil.outJson(CommonResult.successReturn(CommonCodeDef.IS_LOGIN),response);
                    return;
                }
                break;
            }
            case 5:{
                userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
                if(null == userInfo){
                    HttpServletResponseUtil.outJson(CommonResult.errorReturn(CommonCodeDef.NO_LOGIN),response);
                    return;
                }
                break;
            }default:{
                HttpServletResponseUtil.outJson(CommonResult.errorReturn(CommonCodeDef.URL_ERROR),response);
                return;
            }
        }

        filterChain.doFilter(request, servletResponse);
    }


    @Override
    public void destroy() {

    }

}
