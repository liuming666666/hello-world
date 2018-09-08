package cn.lm.hello.factory.shape;

import cn.lm.hello.factory.Shape;
import util.SLF4JUtil;

/**
 * 长方形
 * @author l1093
 *
 */
public class Rectangle extends Shape{

	@Override
	public Shape draw() {
		SLF4JUtil.info("rectangle");
		return null;
	}

}
