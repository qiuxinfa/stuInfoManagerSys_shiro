package com.qxf.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qxf.mapper.StudentMapper;
import com.qxf.pojo.Clazz;
import com.qxf.pojo.Institute;
import com.qxf.pojo.Major;
import com.qxf.pojo.Student;
import com.qxf.service.StudentService;

@Service
public class StudentServiceImpl extends BaseService<Student> implements StudentService{

	@Autowired(required=false)
	private StudentMapper studentMapper;

	@Override
	public PageInfo<Student> selectByPage(Student student, int start, int length) {
		int page = start/length+1;
		//分页查询
		PageHelper.startPage(page, length);
		List<Student> studentList = studentMapper.findAllStudent(student);
		return new PageInfo<>(studentList);
	}

	public List<Student> findAllStudent(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.findAllStudent(student);
	}

	public Student findStudentById(String id) {
		// TODO Auto-generated method stub
		return studentMapper.findStudentById(id);
	}

	public Student findStudentByName(String name) {
		// TODO Auto-generated method stub
		return studentMapper.findStudentByName(name);
	}

	public Integer deleteStudentById(String id) {
		// TODO Auto-generated method stub
		return studentMapper.deleteStudentById(id);
	}

	public Integer updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.updateStudent(student);
	}

	public Integer addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.addStudent(student);
	}

	public List<Institute> getInstituteList() {
		// TODO Auto-generated method stub
		return studentMapper.getInstituteList();
	}

	public List<Major> getMajorList(Major major) {
		// TODO Auto-generated method stub
		return studentMapper.getMajorList(major);
	}

	public List<Clazz> getClazzList(Clazz clazz) {
		// TODO Auto-generated method stub
		return studentMapper.getClazzList(clazz);
	}

	
}
