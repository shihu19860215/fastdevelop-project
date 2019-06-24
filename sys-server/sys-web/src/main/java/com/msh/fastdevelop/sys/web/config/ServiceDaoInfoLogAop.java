package com.msh.fastdevelop.sys.web.config;

import com.msh.frame.common.log.RequestInfo;
import com.msh.frame.web.util.HttpServletRequestUtil;
import com.msh.frame.web.util.RequestInfoUtil;
import com.msh.fastdevelop.sys.service.config.AbstractServiceDaoInfoLogAsperct;
import org.springframework.stereotype.Component;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-18 20:51:33
 */
@Component
public class ServiceDaoInfoLogAop extends AbstractServiceDaoInfoLogAsperct {
    @Override
    protected RequestInfo getRequestInfo() {
        return RequestInfoUtil.getRequestInfo(HttpServletRequestUtil.getCurrentRequest());
    }
}
