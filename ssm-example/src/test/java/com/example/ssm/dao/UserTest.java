package com.example.ssm.dao;

import java.io.Reader;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.ssm.enums.GenderEnum;
import com.example.ssm.model.UserModel;

/**
 * @author clx at 2016年3月22日 下午4:15:35
 */
public class UserTest {

	private static final Logger logger = LoggerFactory.getLogger(UserTest.class);
	private static SqlSessionFactory sqlSessionFactory;

	static {
		try (Reader reader = Resources.getResourceAsReader("com.example.mybatis/mybatis/mybatis-config.xml")) {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			logger.error("init failed.", e);
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	@Test
	public void insertTest() {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			UserDao dao = session.getMapper(UserDao.class);
			UserModel user = new UserModel();
			user.setId(1);
			user.setName("Rose");
			user.setAge(18);
			user.setGender(GenderEnum.FEMALE);
			user.setBirthday(System.currentTimeMillis());
			user.setAddress("I'm living in earth~");
			dao.save(user);
			session.commit();
		} catch (Exception e) {
			logger.error("insert err.", e);
		}
	}

	@Test
	public void getOneTest() {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			UserDao dao = session.getMapper(UserDao.class);
			UserModel user = dao.queryById(1);
			System.out.println(user);
		} catch (Exception e) {
			logger.error("query err.", e);
		}
	}

	@Test
	public void deleteById() {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			UserDao dao = session.getMapper(UserDao.class);
			dao.deleteById(0);
			session.commit();
		} catch (Exception e) {
			logger.error("delete err.", e);
		}
	}

	@Test
	public void updateTest() {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			UserDao dao = session.getMapper(UserDao.class);
			UserModel user = new UserModel();
			user.setId(1);
			user.setName("Jack");
			user.setAge(18);
			user.setGender(GenderEnum.MALE);
			user.setBirthday(System.currentTimeMillis());
			user.setAddress("I'm living in earth~");
			dao.updateUser(user);
			session.commit();
		} catch (Exception e) {
			logger.error("update err.", e);
		}
	}

	@Test
	public void getByIdTest() {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			UserDao mapper = session.getMapper(UserDao.class);
			Map<Integer, UserModel> userMap = mapper.getById(1);
			System.out.println(userMap);
		} catch (Exception e) {
			logger.error("query err.", e);
		}
	}
}
