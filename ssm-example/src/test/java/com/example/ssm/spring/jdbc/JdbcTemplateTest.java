package com.example.ssm.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author clx
 */
public class JdbcTemplateTest {

	private static JdbcTemplate jdbcTemplate;

	@BeforeClass
	public static void setUp() {
		String url = "jdbc:hsqldb:mem:test";
		String userName = "c";
		String pwd = "";
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, userName, pwd);
		dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Test
	public void testByAnonymous() {
		String sql = "select * from INFORMATION_SCHEMA.SYSTEM_TABLES";
		jdbcTemplate.query(sql, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				String result = rs.getString("TABLE_NAME");
				System.out.println("table_name:" + result);
			}
		});
	}

	@Test
	public void testByLambda() {
		String sql = "select * from INFORMATION_SCHEMA.SYSTEM_TABLES";
		jdbcTemplate.query(sql, (ResultSet rs) -> {
			String result = rs.getString("TABLE_NAME");
			System.out.println("table_name:" + result);
		});
	}
}
