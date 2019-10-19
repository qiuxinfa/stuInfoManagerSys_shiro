package com.qxf.pojo;

import java.io.Serializable;

/**
 * 学院表
 * @author Administrator
 *
 */
public class Institute implements Serializable{
	private String id;
	private String name;
	
	public Institute() {
		
	}

	public Institute(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Institute [id=" + id + ", name=" + name + "]";
	}
	
	
}
