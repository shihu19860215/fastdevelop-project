package com.msh.fastdevelop.sys.web.config;

import com.msh.fastdevelop.sys.service.service.AuthorityUrlService;
import com.msh.fastdevelop.sys.web.filter.AuthorityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @author: wangqiaobin
 * @date : 2018/8/25
 */
@Configuration
public class FilterConfiguration {
    @Autowired
    private AuthorityUrlService authorityUrlService;
    @Bean
    public FilterRegistrationBean authorityFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new AuthorityFilter(authorityUrlService));
        registration.addUrlPatterns("/*");
        registration.setName("authority_request");
        registration.setOrder(Integer.MAX_VALUE - 1);
        return registration;
    }


}
