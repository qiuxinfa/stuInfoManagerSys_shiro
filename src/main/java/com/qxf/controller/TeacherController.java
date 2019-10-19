package com.qxf.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.github.pagehelper.PageInfo;
import com.qxf.pojo.TSysDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.qxf.pojo.Teacher;
import com.qxf.service.TeacherService;

@Controller
public class TeacherController {
	@Autowired
	private TeacherService teacherService;

	@RequestMapping("/getAllTeacher")
	@ResponseBody
	public Map<String,Object> getAllMajor(Teacher teacher, String draw,
										  @RequestParam(required = false, defaultValue = "1") int start,
										  @RequestParam(required = false, defaultValue = "10") int length){

		Map<String,Object> map = new HashMap<>();
		PageInfo<Teacher> pageInfo = teacherService.selectByPage(teacher, start, length);
		map.put("draw",draw);
		map.put("recordsTotal",pageInfo.getTotal());
		map.put("recordsFiltered",pageInfo.getTotal());
		map.put("data", pageInfo.getList());
		return map;
	}

	/**
	 * 查找全部老师
	 * @param model
	 * @return
	 */
	 @ResponseBody
	 @RequestMapping("/findAllTeacher")
	    public String findAllTeacher(Teacher teacher) {
		    System.out.println("查找条件--->"+teacher);
	        List<Teacher> list = teacherService.findAllTeacher(teacher);
	        String jsonString = JSON.toJSONString(list);
	        return jsonString;
	    }
    /**
     * 根据id查询老师
     * @param sid
     * @return
     */
    //ajax查询数据
    @ResponseBody
    @RequestMapping("/findTeacherById")
    public Teacher findTeacherById(@RequestParam("id") String id) {
    	System.out.println("查找学号--->"+id);
        return teacherService.findTeacherById(id);
    }

    /**
     * 根据姓名模糊查找老师
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping("/findTeacherByName")
    public Teacher findTeacherByName(@RequestParam("name") String name) {
        return teacherService.findTeacherByName(name);
    }
    
    @ResponseBody
    @RequestMapping("/deleteTeacherById")
    public String deleteTeacherById(String id) {
    	Integer flag = teacherService.deleteTeacherById(id);
    	if(flag>0) {
    		return "success";
    	}else {
    		return "error";
    	}
    }
	
    @ResponseBody
    @RequestMapping("/updateTeacher")
    public String updateTeacher(Teacher teacher) {
    	Integer flag = teacherService.updateTeacher(teacher);
    	String msg = "";
    	if(flag>0) {
    		msg = "success";
    	}else {
    		msg = "error";
    	}
    	return msg;
    }
    
    @ResponseBody
    @RequestMapping("/addTeacher")
    public String addTeacher(Teacher teacher) {
    	String id = UUID.randomUUID().toString().replace("-", "");
    	teacher.setId(id);
    	Integer flag = teacherService.addTeacher(teacher);
    	String msg = "";
    	if(flag>0) {
    		msg = "success";
    	}else {
    		msg = "error";
    	}
    	return msg;
    }
	@RequestMapping("/findTitleList")
	@ResponseBody
	public String findTitleList(){
		List<TSysDict> list = teacherService.findTitleList();
		String jsonString = JSON.toJSONString(list);
		return jsonString;
	}
}
