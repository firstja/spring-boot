package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Dog;
import com.example.demo.service.DogService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DogController {

	@Autowired
	private DogService dogService;
	/**
	 * 赋值初始化建议
	 * @param dataBinder
	 */
	@InitBinder
	public void initBinder(DataBinder dataBinder) {
		dataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
	}
	
	@RequestMapping("/creatDog")
	public String creatDog(String d_name,Integer d_age) {
		dogService.createDog(d_name, d_age);
		return "整合jdbcTemplate";
	}
	
	@RequestMapping("/selectAll")
	public List<Dog> selectAll(){
		return dogService.selectAll();
	}
	
	@RequestMapping("/selectAll1")
	public List<Dog> selectAll1() throws Exception{
		List<Dog> dogs=dogService.selectAll1();
		return dogs;
		
	}
	
	@RequestMapping("/useThread")
	public String useThread() {
		log.info("#1#");
		dogService.useThread();
		log.info("#4#");
		return "success";
	}
	
}
