package com.baidu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.demo.entity.Dog;
import com.baidu.demo.mapper.DogMapper;

@Service
public class DogService {

	@Autowired
	private DogMapper dogMapper;
	
	/**
	 * 查询所有的dog信息
	 * @return
	 */
	public List<Dog> selectAll(){
		return dogMapper.selectAll();
	}
}
