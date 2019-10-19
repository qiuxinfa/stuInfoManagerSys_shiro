package com.qxf.mapper;

import com.qxf.pojo.TSysDict;
import com.qxf.pojo.User;
import com.qxf.util.MyMapper;

import java.util.List;

public interface UserMapper extends MyMapper<User> {
	public int updateUser(User user);
	public User getUserById(String id);
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public Integer addUser (User user);
	
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public User findUser (User user);

	/**
	 *功能描述：删除用户
	 *@param:
	 *@return:
	 *@auther:
	 *@date:
	 */
	public int deleteUserById(String userId);

	/**
	 *功能描述：用户类型
	 *@param:
	 *@return:
	 *@auther:
	 *@date:
	 */
	public List<TSysDict> findUserTypeList();

	/**
	 *功能描述：是否
	 *@param:
	 *@return:
	 *@auther:
	 *@date:
	 */
	public List<TSysDict> findEnableList();
}
