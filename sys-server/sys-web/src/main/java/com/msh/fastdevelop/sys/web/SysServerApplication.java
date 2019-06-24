package com.msh.fastdevelop.sys.web;

import com.alibaba.fastjson.parser.ParserConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-18 20:51:33
 */
@SpringBootApplication
@ComponentScan({"com.msh"})
@MapperScan(basePackages = "com.msh.fastdevelop.sys.service.dao")
@EnableTransactionManagement
@ServletComponentScan
public class SysServerApplication{
	public static void main(String[] args) throws Exception {
		ParserConfig.getGlobalInstance().addAccept("com.msh");
		/**
		 * 程序启动入口
		 * 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
		 */
		try {
			SpringApplication.run(SysServerApplication.class, args);
		}catch (Exception e){
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
