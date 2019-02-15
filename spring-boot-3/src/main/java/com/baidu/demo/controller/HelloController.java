package com.baidu.demo.controller;

import javax.print.DocFlavor.STRING;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.demo.service.TestService;

@RestController
public class HelloController {
	
	//自定义参数
	@Value(value="${name}")
	private String name;
	
	@Value(value="${http_url}")
	private String url;
	
	

	@Autowired
	private TestService testService;
	
	private static Logger logger=LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping("/hello")
	public String hello(int num) {
		int i=1;
		i=i/num;
		System.out.println(i);
		
		logger.info("spring boot");
		System.out.println("访问到当前方法");
		return "spring boot log4j";
	}	
	
	
	@RequestMapping("/async1")
	@Async   //需要执行异步方法上加入
	public String async1() {
		System.out.println("1");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testService.testAsync();
		System.out.println("4");
		return "spring";
	}
	
	
	@RequestMapping("/getValue")
	public String getValue() {
		return this.getName();
	}
	
	/**
	 * 多环境配置,区分不同环境的配置文件信息
	 */
	//注意分布式配置中心
	@RequestMapping("/getHttpUrl")
	public String getHttpUrl() {
		return this.getUrl();
	}

	
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
	
	
}
