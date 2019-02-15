package com.example.demo.entity;

import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;

import lombok.Data;

/**
 * Dog数据表对应的实体
 * @author asus
 *
 */
@Data
public class Dog {
	/**
	 * 成员变量
	 */
	private Integer d_id;
	private String d_name;
	private Integer d_age;
	
//	空的构造器
	public Dog() {}
	
}
