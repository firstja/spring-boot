package com.baidu.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan(basePackages= {"com.baidu.demo.mapper"})//整合mybatis的启动方式
//三种启动方式
@EnableAsync   //开启异步方式
//异步的底层实现方式是多线程
public class SpringBoot3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot3Application.class, args);
	}
	
	

}


