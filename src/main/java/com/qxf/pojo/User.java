package com.qxf.pojo;

import java.io.Serializable;

/**
 * 用户表
 * @author Administrator
 *
 */
public class User implements Serializable{
	private String id;
	private String username;
	private String password;
	private Integer userType;
	private Integer enable;

	public User() {
		
	}
	
	public User(String id, String username, String password, Integer userType) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.userType = userType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", userType=" + userType +
				", enable=" + enable +
				'}';
	}
}
