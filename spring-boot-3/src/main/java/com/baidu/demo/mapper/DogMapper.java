package com.baidu.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baidu.demo.entity.Dog;

@Mapper
public interface DogMapper {

	@Select("select * from dog")
	public List<Dog> selectAll();
	
	
}
