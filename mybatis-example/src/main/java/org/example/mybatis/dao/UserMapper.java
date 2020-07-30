package org.example.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.example.mybatis.model.UserModel;

/**
 * @author clx at 2016年3月22日 下午4:15:35
 */
public interface UserMapper {
	/**
	 * save
	 * 
	 * @param user
	 * @return
	 */
	int save(UserModel user);

	/**
	 * delete by id
	 * 
	 * @param id
	 * @return
	 */
	int deleteById(@Param("id") Integer id);

	/**
	 * update
	 * 
	 * @param user
	 * @return
	 */
	int updateUser(UserModel user);

	/**
	 * query
	 * 
	 * @param id
	 * @return
	 */
	UserModel queryById(@Param("id") Integer id);

	/**
	 * query
	 * 
	 * @return
	 */
	List<UserModel> queryAll();

	/**
	 * get by id
	 * 
	 * @param id
	 * @return
	 */
	@MapKey("id")
	Map<Integer, UserModel> getById(@Param("id") Integer id);
}
