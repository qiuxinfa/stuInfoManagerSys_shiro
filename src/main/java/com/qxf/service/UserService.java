package com.qxf.service;

import com.github.pagehelper.PageInfo;
import com.qxf.pojo.TSysDict;
import com.qxf.pojo.User;

import java.util.List;

public interface UserService extends IService<User> {
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

	PageInfo<User> selectByPage(User user, int start, int length);

	User selectByUsername(String username);

	void delUser(String userid);
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
