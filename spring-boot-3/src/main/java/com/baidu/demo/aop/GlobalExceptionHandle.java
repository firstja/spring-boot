package com.baidu.demo.aop;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局捕获异常
 * @author asus
 *
 */
@ControllerAdvice
public class GlobalExceptionHandle {

	@ExceptionHandler(value= {RuntimeException.class})
	@ResponseBody
	public Map<String, Object> errorHandle() {
		Map<String, Object> map=new HashMap<>();
		map.put("errorCode", "500");
		map.put("errorMsg", "全部捕获异常,系统错误");
		return map;
	}
	
		
}
