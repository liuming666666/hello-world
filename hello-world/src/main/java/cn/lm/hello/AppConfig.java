package cn.lm.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cn.lm.hello.interceptors.LoginInterceptor;

/**
 * 全局配置
 * @author l1093
 *
 */
@Configuration
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer{

	@Autowired
	private LoginInterceptor loginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
		.addPathPatterns("/**")
		.excludePathPatterns("/view/login.html");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
}
