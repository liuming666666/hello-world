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
import util.Result;
import util.ResultUtil;

@RestController
@RequestMapping("/")
public class HelloController{
	
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping("/exception")
	public void test() {
		throw new CustomException(ResCode.ERROR);
	}
	
	@RequestMapping("/login")
	public Result<?> login(HttpServletRequest request) {
		request.getSession().setAttribute("user", "");
		return ResultUtil.success(null);
	}
	
}