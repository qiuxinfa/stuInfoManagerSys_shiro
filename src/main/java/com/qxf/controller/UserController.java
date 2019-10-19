package com.qxf.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.qxf.pojo.TSysDict;
import com.qxf.pojo.UserRole;
import com.qxf.service.UserRoleService;
import com.qxf.util.PasswordHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qxf.pojo.User;
import com.qxf.service.UserService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@Resource
	private UserRoleService userRoleService;

	@RequestMapping("/userLogin")
	public String userLogin(User user) {
		User u = userService.findUser(user);
		if(u==null) {
			return "0";
		}else {
			return "1";
		}
	}

	@RequestMapping("/register")
	public String addUser(User user) {
		String id = UUID.randomUUID().toString().replace("-", "");
		user.setId(id);
		int flag = userService.addUser(user);
		if(flag>0) {
			return "1";
		}else {
			return "0";
		}
	}

	@RequestMapping
	public Map<String,Object> getAll(User user, String draw,
									 @RequestParam(required = false, defaultValue = "1") int start,
									 @RequestParam(required = false, defaultValue = "10") int length){
		Map<String,Object> map = new HashMap<>();
		PageInfo<User> pageInfo = userService.selectByPage(user, start, length);
		System.out.println("pageInfo.getTotal():"+pageInfo.getTotal());
		map.put("draw",draw);
		map.put("recordsTotal",pageInfo.getTotal());
		map.put("recordsFiltered",pageInfo.getTotal());
		map.put("data", pageInfo.getList());
		return map;
	}


	/**
	 * 保存用户角色
	 * @param userRole 用户角色
	 *  	  此处获取的参数的角色id是以 “,” 分隔的字符串
	 * @return
	 */
	@RequestMapping("/saveUserRoles")
	public String saveUserRoles(UserRole userRole){
		if(StringUtils.isEmpty(userRole.getUserId()))
			return "error";
		try {
			userRoleService.addUserRole(userRole);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@RequestMapping(value = "/add")
	public String add(User user) {
		User u = userService.selectByUsername(user.getUsername());
		if(u != null)
			return "error";
		try {
			PasswordHelper passwordHelper = new PasswordHelper();
			passwordHelper.encryptPassword(user);
			String id = UUID.randomUUID().toString().replace("-", "");
			user.setId(id);
			//保存用户
			userService.save(user);
			//向用户-角色表插入数据
			UserRole userRole = new UserRole();
			id = UUID.randomUUID().toString().replace("-", "");
			userRole.setId(id);
			userRole.setUserId(user.getId());
			userRole.setRoleId(""+user.getUserType());
			userRoleService.save(userRole);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@RequestMapping(value = "/delete")
	public String delete(String id){
		try{
			userService.delUser(id);
			return "success";
		}catch (Exception e){
			e.printStackTrace();
			return "fail";
		}
	}

	@RequestMapping("/update")
	public String update(User user){
		try {
			int flag = userService.updateUser(user);
			if(flag>0){
				return "success";
			}else{
				return "fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@RequestMapping("/get")
	public User get(String id){
		User u = null;
		try {
			u = userService.getUserById(id);
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			return u;
		}
	}

	@RequestMapping("/findUserTypeList")
	public String findUserTypeList(){
		List<TSysDict> userTypeList = userService.findUserTypeList();
		String jsonString = JSON.toJSONString(userTypeList);
		return jsonString;
	}

	@RequestMapping("/findEnableList")
	public String findEnableList(){
		List<TSysDict> enableList = userService.findEnableList();
		String jsonString = JSON.toJSONString(enableList);
		return jsonString;
	}


}
