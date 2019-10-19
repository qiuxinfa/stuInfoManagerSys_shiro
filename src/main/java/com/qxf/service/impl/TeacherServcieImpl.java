package com.qxf.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qxf.pojo.TSysDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qxf.mapper.TeacherMapper;
import com.qxf.pojo.Teacher;
import com.qxf.service.TeacherService;

@Service
public class TeacherServcieImpl extends BaseService<Teacher> implements TeacherService{

	@Autowired(required=false)
	private TeacherMapper teacherMapper;
	@Override
	public PageInfo<Teacher> selectByPage(Teacher teacher, int start, int length){
		int page = start/length+1;
		//分页查询
		PageHelper.startPage(page, length);
		List<Teacher> list = teacherMapper.findAllTeacher(teacher);
		return new PageInfo<>(list);
	}

	@Override
	public List<TSysDict> findTitleList(){
		return teacherMapper.findTitleList();
	}

	public List<Teacher> findAllTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherMapper.findAllTeacher(teacher);
	}

	public Teacher findTeacherById(String id) {
		// TODO Auto-generated method stub
		return teacherMapper.findTeacherById(id);
	}

	public Teacher findTeacherByName(String name) {
		// TODO Auto-generated method stub
		return teacherMapper.findTeacherByName(name);
	}

	public Integer deleteTeacherById(String id) {
		// TODO Auto-generated method stub
		return teacherMapper.deleteTeacherById(id);
	}

	public Integer updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherMapper.updateTeacher(teacher);
	}

	public Integer addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherMapper.addTeacher(teacher);
	}

}
