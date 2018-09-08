package cn.lm.hello.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 登陆拦截器
 * @author l1093
 *
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

	
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getSession().getAttribute("user") == null) {
			logger.info("进入拦截器");
			request.getRequestDispatcher("/view/login.html").forward(request, response);
			// 没有登陆
			return false;
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
}
