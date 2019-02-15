package com.baidu.demo.entity;

public class Dog {
	private Integer id;
	private String d_name;
	private Integer d_age;
	/**
	 * @param id
	 * @param d_name
	 * @param d_age
	 */
	public Dog(Integer id, String d_name, Integer d_age) {
		super();
		this.id = id;
		this.d_name = d_name;
		this.d_age = d_age;
	}
	/**
	 * 
	 */
	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public Integer getD_age() {
		return d_age;
	}
	public void setD_age(Integer d_age) {
		this.d_age = d_age;
	}
	@Override
	public String toString() {
		return "Dog [id=" + id + ", d_name=" + d_name + ", d_age=" + d_age + "]";
	}
	
	
	
}
