package cn.lm.hello.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.lm.hello.exceptions.CustomException;
import util.ResCode;

@RestController
public class HelloController{
	
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping("/a")
	public Map<String, Object> hello(String name) {
		logger.info("你好, {}", name);
		Map<String, Object> map = new HashMap<>();
		map.put("hello", "hello");
		return map;
	}
	
	@RequestMapping("/exception")
	public void test() {
		throw new CustomException(ResCode.ERROR);
	}
	
	@RequestMapping("/login")
	public void login(HttpServletRequest request) {
		request.getSession().setAttribute("user", "");
	}
	
}