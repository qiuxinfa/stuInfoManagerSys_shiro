package com.qxf.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.qxf.pojo.Course;
import com.qxf.service.CourseService;

@Controller
public class CourseController {
	@Autowired
	private CourseService courseService;

	@RequestMapping("/getAllCourse")
	@ResponseBody
	public Map<String,Object> getAllMajor(Course course, String draw,
										  @RequestParam(required = false, defaultValue = "1") int start,
										  @RequestParam(required = false, defaultValue = "10") int length){

		Map<String,Object> map = new HashMap<>();
		PageInfo<Course> pageInfo = courseService.selectByPage(course, start, length);
		map.put("draw",draw);
		map.put("recordsTotal",pageInfo.getTotal());
		map.put("recordsFiltered",pageInfo.getTotal());
		map.put("data", pageInfo.getList());
		return map;
	}

	/**
	 * 查找全部课程
	 * @param model
	 * @return
	 */
	 @ResponseBody
	 @RequestMapping("/findAllCourse")
	    public String findAllcourse(Course course) {
		    System.out.println("查找条件--->"+course);
	        List<Course> list = courseService.findAllCourse(course);
	        String jsonString = JSON.toJSONString(list);
	        return jsonString;
	    }
    /**
     * 根据id查询课程
     * @param sid
     * @return
     */
    //ajax查询数据
    @ResponseBody
    @RequestMapping("/findCourseById")
    public Course findCourseById(@RequestParam("id") String id) {
        return courseService.findCourseById(id);
    }

    /**
     * 根据姓名模糊查找课程
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping("/findCourseByName")
    public Course findCourseByName(@RequestParam("name") String name) {
        return courseService.findCourseByName(name);
    }
    
    @ResponseBody
    @RequestMapping("/deleteCourseById")
    public String deleteCourseById(String id) {
    	Integer flag = courseService.deleteCourseById(id);
    	if(flag>0) {
    		return "success";
    	}else {
    		return "error";
    	}
    }
	
    @ResponseBody
    @RequestMapping("/updateCourse")
    public String updateCourse(Course course) {
    	Integer flag = courseService.updateCourse(course);
    	String msg = "";
    	if(flag>0) {
    		msg = "success";
    	}else {
    		msg = "error";
    	}
    	return msg;
    }
    
    @ResponseBody
    @RequestMapping("/addCourse")
    public String addCourse(Course course) {
    	String id = UUID.randomUUID().toString().replace("-", "");
    	course.setId(id);
    	Integer flag = courseService.addCourse(course);
    	String msg = "";
    	if(flag>0) {
    		msg = "success";
    	}else {
    		msg = "error";
    	}
    	return msg;
    }
    
}
