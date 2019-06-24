package com.msh.fastdevelop.sys.service.config;

import com.msh.frame.common.aop.aspect.AbstractInfoLoggerAspectAsperct;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;



/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-18 20:51:33
 */
@Aspect
@Order(10)
abstract public class AbstractServiceDaoInfoLogAsperct extends AbstractInfoLoggerAspectAsperct {
    @Override
    @Pointcut("this(com.msh.frame.client.base.BaseService)")
    protected void pointcut() {
    }
}
