package util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.log4j.LogManager;
import org.apache.log4j.spi.LoggerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class SLF4JUtil {
	
	private static Logger logger = null;
	
	private static final String FQCN = SLF4JUtil.class.getName();
	
	static {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(org.apache.log4j.Logger.class);
		enhancer.setCallback(new MethodInterceptor() {

			@Override
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
				if("log".equals(method.getName())) {
					//FQCN
					args[0] = FQCN;
					Object result = proxy.invokeSuper(obj, args);
					return result;
				} else {
					return proxy.invokeSuper(obj, args);
				}
			}
			
		});
		//logger
		org.apache.log4j.Logger loggerProxy = (org.apache.log4j.Logger) enhancer.create(new Class<?>[] {String.class}, new String[] {"root"});
		LoggerRepository loggerRepository = LogManager.getLoggerRepository();	
		org.apache.log4j.spi.LoggerFactory loggerFactory = ReflectUtil.getFieldValue(loggerRepository, "defaultFactory");
		org.apache.log4j.spi.LoggerFactory loggerFactoryProxy = (org.apache.log4j.spi.LoggerFactory) Proxy.newProxyInstance(org.apache.log4j.spi.LoggerFactory.class.getClassLoader(),
				new Class<?>[] {org.apache.log4j.spi.LoggerFactory.class},
				new SLF4JHandler(loggerProxy));
		ReflectUtil.setFieldValue(loggerRepository, "defaultFactory", loggerFactoryProxy);
		logger = LoggerFactory.getLogger(SLF4JUtil.class);	
		ReflectUtil.setFieldValue(loggerRepository, "defaultFactory", loggerFactory);
	}
	
	
	
	
	/**
	 * ����
	 * @author juyi1012
	 *
	 */
	private static class SLF4JHandler implements InvocationHandler {
		
		private org.apache.log4j.Logger loggerProxy;
		
		public SLF4JHandler(org.apache.log4j.Logger loggerProxy) {
			super();
			this.loggerProxy = loggerProxy;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			return loggerProxy;
		}
		
	}
	
	public static void trace(String message) {
		logger.trace(message);
	}
	
	public static void trace(String format, Object...arguments) {
		logger.trace(format, arguments);
	}
	
	public static void debug(String message) {
		logger.debug(message);
	}
	
	public static void debug(String format, Object...arguments) {
		logger.debug(format, arguments);
	}
	
	public static void info(String message) {
		logger.info(message);
	}
	
	public static void info(String format, Object...arguments) {
		logger.info(format, arguments);
	}
	
	public static void warn(String message) {
		logger.warn(message);
	}
	
	public static void warn(String format, Object...arguments) {
		logger.warn(format, arguments);
	}
	
	public static void error(String message) {
		logger.error(message);
	}
	
	public static void error(String format, Object...arguments) {
		logger.error(format, arguments);
	}
	
	public static void error(String format, Throwable t) {
		logger.error(format, t);
	}
	
}
