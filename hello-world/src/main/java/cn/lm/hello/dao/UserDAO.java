package cn.lm.hello.dao;

import java.sql.SQLException;
import java.sql.Statement;

import cn.lm.hello.entity.User;

/**
 * 用户数据访问对象
 * @author l1093
 *
 */
public class UserDAO extends BaseDAO{
	
	/**
	 * 增加记录
	 * @param user
	 * @throws SQLException 
	 */
	public int insert(User user) throws SQLException {
		Statement statement = super.getConnection().createStatement();
		String sql = "insert into user values(null,'刘明');";
		return statement.executeUpdate(sql);
	}
	
}
