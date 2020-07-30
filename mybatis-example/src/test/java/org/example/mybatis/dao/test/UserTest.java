package org.example.mybatis.dao.test;

import java.io.Reader;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mybatis.dao.UserMapper;
import org.example.mybatis.model.Gender;
import org.example.mybatis.model.UserModel;
import org.junit.Test;

/**
 * @author clx at 2016年3月22日 下午4:15:35
 */
public class UserTest {

	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("org.example.mybatis/mybatis/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	@Test
	public void insertTest() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper dao = session.getMapper(UserMapper.class);
			UserModel user = new UserModel();
			user.setId(1);
			user.setName("Rose");
			user.setAge(18);
			user.setGender(Gender.female);
			user.setBirthday(System.currentTimeMillis());
			user.setAddress("I'm living in earth~");
			dao.save(user);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Test
	public void getOneTest() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper dao = session.getMapper(UserMapper.class);
			UserModel user = dao.queryById(1);
			System.out.println(user);
		} finally {
			session.close();
		}
	}

	@Test
	public void deleteById() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper dao = session.getMapper(UserMapper.class);
			dao.deleteById(0);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Test
	public void updateTest() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper dao = session.getMapper(UserMapper.class);
			UserModel user = new UserModel();
			user.setId(1);
			user.setName("Jack");
			user.setAge(18);
			user.setGender(Gender.male);
			user.setBirthday(System.currentTimeMillis());
			user.setAddress("I'm living in earth~");
			dao.updateUser(user);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Test
	public void getByIdTest() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			Map<Integer, UserModel> userMap = mapper.getById(1);
			System.out.println(userMap);
		} finally {
			session.close();
		}
	}

}
