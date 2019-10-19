package com.qxf.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qxf.mapper.CourseMapper;
import com.qxf.pojo.Course;
import com.qxf.service.CourseService;

@Service
public class CourseServiceImpl extends BaseService<Course> implements CourseService{
    @Autowired
	private CourseMapper courseMapper;

    @Override
	public PageInfo<Course> selectByPage(Course course, int start, int length){
		int page = start/length+1;
		//分页查询
		PageHelper.startPage(page, length);
		List<Course> list = courseMapper.findAllCourse(course);
		return new PageInfo<>(list);
	}

	public List<Course> findAllCourse(Course course) {
		// TODO Auto-generated method stub
		return courseMapper.findAllCourse(course);
	}

	public Course findCourseById(String id) {
		// TODO Auto-generated method stub
		return courseMapper.findCourseById(id);
	}

	public Course findCourseByName(String name) {
		// TODO Auto-generated method stub
		return courseMapper.findCourseByName(name);
	}

	public Integer deleteCourseById(String id) {
		// TODO Auto-generated method stub
		return courseMapper.deleteCourseById(id);
	}

	public Integer updateCourse(Course course) {
		// TODO Auto-generated method stub
		return courseMapper.updateCourse(course);
	}

	public Integer addCourse(Course course) {
		// TODO Auto-generated method stub
		return courseMapper.addCourse(course);
	}

}
