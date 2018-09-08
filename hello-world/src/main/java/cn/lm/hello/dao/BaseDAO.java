package cn.lm.hello.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import util.SLF4JUtil;

/**
 * 基础连接实现
 * @author l1093
 *
 */
public class BaseDAO {
	
	private static Connection c = null;
	
	//加载驱动
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://67.218.135.182:3306/lm?serverTimezone=UTC&characterEncoding=UTF-8",
					"root","123456");
		} catch (ClassNotFoundException e) {
			SLF4JUtil.error("加载mysql驱动失败",e);
		} catch (SQLException e) {
			SLF4JUtil.error("获取数据库连接失败",e);
		}
	}
	
	/**
	 * 获取连接
	 * @return
	 */
	public Connection getConnection() {
		return c;
	}
	
}
