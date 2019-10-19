package com.qxf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qxf.mapper.UserRoleMapper;
import com.qxf.pojo.TSysDict;
import com.qxf.pojo.User;
import com.qxf.pojo.UserRole;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qxf.mapper.UserMapper;
import com.qxf.service.UserService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl extends BaseService<User> implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Resource
	private UserRoleMapper userRoleMapper;

	public int updateUser(User user){
		return userMapper.updateUser(user);
	}

	public User getUserById(String id){
		return userMapper.getUserById(id);
	}
	public Integer addUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.addUser(user);
	}

	public User findUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.findUser(user);
	}

	@Override
	public PageInfo<User> selectByPage(User user, int start, int length) {
		int page = start/length+1;
		Example example = new Example(User.class);
		Example.Criteria criteria = example.createCriteria();
		Session session = SecurityUtils.getSubject().getSession();
		User userSession = (User) session.getAttribute("userSession");
		//如果当前登录的是管理员
		if(userSession.getUserType()==1){
			if (StringUtil.isNotEmpty(user.getUsername())) {
				criteria.andLike("username", "%" + user.getUsername() + "%");
			}
			if (StringUtil.isNotEmpty(user.getId())) {
				criteria.andEqualTo("id", user.getId());
			}
			if (user.getEnable()!=null) {
				criteria.andEqualTo("enable", user.getEnable());
			}
		} else{
			//只能查看自己的信息
			criteria.andEqualTo("id", userSession.getId());
		}
		//分页查询
		PageHelper.startPage(page, length);
		List<User> userList = selectByExample(example);
		return new PageInfo<>(userList);
	}

	@Override
	public User selectByUsername(String username) {
		Example example = new Example(User.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("username",username);
		List<User> userList = selectByExample(example);
		if(userList.size()>0){
			return userList.get(0);
		}
		return null;
	}

	@Override
	@Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
	public void delUser(String userid) {
		//删除用户表
		//mapper.deleteByPrimaryKey(userid);
		int flag = userMapper.deleteUserById(userid);
		//删除用户角色表
		if(flag>0){
			Example example = new Example(UserRole.class);
			Example.Criteria criteria = example.createCriteria();
			criteria.andEqualTo("userId",userid);
			userRoleMapper.deleteByExample(example);
		}

	}
	/**
	 *功能描述：用户类型
	 *@param:
	 *@return:
	 *@auther:
	 *@date:
	 */
	public List<TSysDict> findUserTypeList(){
		return userMapper.findUserTypeList();
	}

	/**
	 *功能描述：是否
	 *@param:
	 *@return:
	 *@auther:
	 *@date:
	 */
	public List<TSysDict> findEnableList(){
		return userMapper.findEnableList();
	}
}
