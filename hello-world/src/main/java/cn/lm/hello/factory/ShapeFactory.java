package cn.lm.hello.factory;

import util.SLF4JUtil;

/**
 * @author l1093
 * 图形创建工厂
 *
 */
public class ShapeFactory {

	/**
	 * 获取图形
	 * @param c
	 * @return
	 */
	public static Shape getShape(Class<? extends Shape> c) {
		try {
			return c.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			SLF4JUtil.error("工厂创建对象失败",e);
		}
		return null;
	};
	
}
