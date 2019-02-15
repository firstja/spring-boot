package com.baidu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.demo.entity.Dog;
import com.baidu.demo.service.DogService;

/**
 * 标识当前类所有的方法全返回数据
 * @author asus
 *
 */
@RestController 
public class DogController {

	@Autowired
	private DogService dogService;

	/**
	 * 初始化建议
	 */
	@InitBinder
	public void initBinder(DataBinder dataBinder) {
		dataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
	}
	
	
	@RequestMapping("/selectAll")
	public List<Dog> selectAll(){
		return dogService.selectAll();
	}
	
	
	

}
