package cn.lm.hello.pojo;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import cn.lm.hello.dao.UserDAO;
import cn.lm.hello.factory.ShapeFactory;
import cn.lm.hello.factory.shape.Circle;
import util.SLF4JUtil;

public class HelloTest extends BaseTest{

	@Autowired
	DriverManagerDataSource driverManagerDataSource;
	
	@Autowired
	Hello hello;
	
	@Autowired
	UserDAO userDAO;
	
	@Test
	public void test() throws SQLException {
		new JdbcTemplate(driverManagerDataSource).execute("insert into user values(null,'盖伦');");
		//userDAO.insert(null);
		SLF4JUtil.info(hello.getName());
	}
	
	@Test
	public void test1() throws SQLException {
		ShapeFactory.getShape(Circle.class).draw();
	}
	
}
