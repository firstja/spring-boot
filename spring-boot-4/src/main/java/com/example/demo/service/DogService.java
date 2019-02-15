package com.example.demo.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DogMapper;
import com.example.demo.entity.Dog;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DogService {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DogMapper dogMapper;
	
	
	public void createDog(String d_name,Integer d_age) {
		//jdbcTemplate update方法,执行CUD
		jdbcTemplate.update("insert into dog(d_name,d_age) values(?,?)",d_name,d_age);
		
	}
	
	
	public List<Dog> selectAll(){
		List<Dog> dogs=jdbcTemplate.query("select * from dog",new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Dog dog=new Dog();
				dog.setD_id(rs.getInt("d_id"));
				dog.setD_name(rs.getString("d_name"));
				dog.setD_age(rs.getInt("d_age"));
				return dog;
			}
			
		});
		return dogs;
	}
	
	
	
	public List<Dog> selectAll1() throws Exception{
		List<Dog> dogs=dogMapper.selectAll();
		
		return dogs;
		
	}
	
	
	
	//异步调用,底层使用多线程的技术

	@Async   //添加注解,使用异步调用
	public void useThread() {
		log.info("##02##");
		try {
			Thread.sleep(5 * 1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		log.info("##03##");
	}
}
