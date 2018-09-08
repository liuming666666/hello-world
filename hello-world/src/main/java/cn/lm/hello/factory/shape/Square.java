package cn.lm.hello.factory.shape;

import cn.lm.hello.factory.Shape;
import util.SLF4JUtil;

/**
 * 正方形
 * @author l1093
 *
 */
public class Square extends Shape{

	@Override
	public Shape draw() {
		SLF4JUtil.info("square");
		return null;
	}

}
