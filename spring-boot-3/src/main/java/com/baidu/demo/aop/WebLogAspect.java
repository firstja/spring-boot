package com.baidu.demo.aop;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * aop技术使用日志
 * @author asus
 *
 */
@Component
@Aspect
public class WebLogAspect {
	private static Logger logger=LoggerFactory.getLogger(WebLogAspect.class);

	@Pointcut("execution(public * com.baidu.demo.controller.*.*(..))")
	public void webLog() {}
	
	/**
	 * 前置通知
	 */
	@Before(value="webLog()")
	public void doBefore(JoinPoint joinPoint)throws Exception{
		//接收到请求,记录请求内容
		ServletRequestAttributes requestAttributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		//获取到请求
		HttpServletRequest request=requestAttributes.getRequest();
		//记录下请求内容
		logger.info("URL:"+request.getRequestURL().toString());
		logger.info("HTTP-Method:"+request.getMethod().toString());
		logger.info("IP:"+request.getRemoteAddr()); 
		Enumeration<String> enu=request.getParameterNames();
		while(enu.hasMoreElements()) {//是否还有更多的元素
			String name=enu.nextElement();
			logger.info("name:{},value:{}",name,request.getParameter(name));
		}
	}
	
	/**
	 * 后置通知
	 */
	@AfterReturning(returning="ret",pointcut="webLog()")
	public void doAfter(Object ret) {
		logger.info("RESPONSE:"+ret);
	}
	
	
	
}
