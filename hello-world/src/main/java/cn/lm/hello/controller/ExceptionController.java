package cn.lm.hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cn.lm.hello.exceptions.CustomException;
import util.ResCode;
import util.Result;
import util.ResultUtil;

/**
 * 全局异常处理
 * @author l1093
 *
 */
@RestControllerAdvice
public class ExceptionController {
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);
	
	@ExceptionHandler
	public Result<?> exception(Throwable t) {
		if(t instanceof CustomException) {
			logger.error("自定义异常", t);
			ResCode resCode = ((CustomException) t).getResCode();
			if(resCode != null) {
				return ResultUtil.error(resCode);
			}
		}
		logger.error("未知异常", t);
		return ResultUtil.error(ResCode.ERROR);
	}
	
}
