package util;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReflectUtil {

	private static final Logger logger = LoggerFactory.getLogger(ReflectUtil.class);
	
	/**
	 *  获取对象属性值ֵ
	 * @param <T>
	 * @param obj
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getFieldValue(Object obj, String name) {
		Class<? extends Object> c = obj.getClass();
		Field field = null;
		Object value = null;
		try {
			field = c.getDeclaredField(name);
			field.setAccessible(true);	//设置访问权限
			try {
				value = field.get(obj);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				logger.error("获取属性{}失败",name);
			}
		} catch (NoSuchFieldException | SecurityException e) {
			logger.error("{}没有这样的属性",c.getName());
		}
		return (T) value;
	}
	
	/**
	 * 设置对象属性值
	 * @param <T>
	 * @param obj
	 * @param name
	 * @param value
	 */
	public static void setFieldValue(Object obj, String name, Object value) {
		Class<? extends Object> c = obj.getClass();
		Field field = null;
		try {
			field = c.getDeclaredField(name);
			field.setAccessible(true);	//设置访问权限
			try {
				field.set(obj, value);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				logger.error("设置属性{}失败",name);
			}
		} catch (NoSuchFieldException | SecurityException e) {
			logger.error("{}没有这样的属性",c.getName());
		}
	}
	
}
