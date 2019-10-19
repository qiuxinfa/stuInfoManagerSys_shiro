package com.qxf.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.qxf.pojo.TSysDict;
import com.qxf.pojo.Teacher;

public interface TeacherService extends IService<Teacher>{
	public PageInfo<Teacher> selectByPage(Teacher teacher, int start, int length);

	public List<TSysDict> findTitleList();
	/**
	 * 查找全部老师
	 * @return
	 */
	public List<Teacher> findAllTeacher(Teacher teacher);
	
	/**
	 * 根据学号查找老师
	 * @param sid
	 * @return
	 */
	public Teacher findTeacherById(String id);
	
	/**
	 * 根据姓名模糊查找老师
	 * @param name
	 * @return
	 */
	public Teacher findTeacherByName(String name);
	
	/**
	 * 根据学号删除老师
	 * @param sid
	 * @return
	 */
	public Integer deleteTeacherById(String id);
	
	/**
	 * 修改老师信息
	 * @param student
	 * @return
	 */
	public Integer updateTeacher(Teacher teacher);
	
	/**
	 * 新增老师
	 * @param student
	 * @return
	 */
	public Integer addTeacher(Teacher teacher);
	
}
