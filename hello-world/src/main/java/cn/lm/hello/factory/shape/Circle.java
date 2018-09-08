package cn.lm.hello.factory.shape;

import cn.lm.hello.factory.Shape;
import util.SLF4JUtil;

/**
 * 圆形
 * @author l1093
 *
 */
public class Circle extends Shape{

	@Override
	public Shape draw() {
		SLF4JUtil.info("circle");
		return null;
	}

}
