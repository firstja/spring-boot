package com.example.demo.aop;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局捕获异常
 * @author asus
 *
 */
@ControllerAdvice
public class AopCatchException {

	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public Map<String, Object> exceptionHandle(){
		Map<String, Object> map=new HashMap<>();
		map.put("errorCode", "500");
		map.put("errorMsg", "系统错误");
		map.put("error", "你真的很漂亮");
		
		return map;
	}
	
	
}
