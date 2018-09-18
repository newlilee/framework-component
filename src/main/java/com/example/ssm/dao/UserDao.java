package com.example.ssm.dao;

import java.util.List;
import java.util.Map;

import com.example.ssm.model.UserModel;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

/**
 * UserDao
 * 
 * @author clx
 */
public interface UserDao {

	/**
	 * save
	 * 
	 * @param user
	 * @return
	 */
	int save(UserModel user);

	/**
	 * deleteById
	 * 
	 * @param id
	 * @return
	 */
	int deleteById(@Param("id") Integer id);

	/**
	 * updateUser
	 * 
	 * @param user
	 * @return
	 */
	int updateUser(UserModel user);

	/**
	 * queryById
	 * 
	 * @param id
	 * @return
	 */
	UserModel queryById(@Param("id") Integer id);

	/**
	 * queryAll
	 * 
	 * @return
	 */
	List<UserModel> queryAll();

	/**
	 * getById
	 * 
	 * @param id
	 * @return
	 */
	@MapKey("id")
	Map<Integer, UserModel> getById(@Param("id") Integer id);
}
