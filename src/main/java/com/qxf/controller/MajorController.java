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
import com.qxf.pojo.Major;
import com.qxf.service.MajorService;

@Controller
public class MajorController {
	@Autowired
	private MajorService majorService;

	@RequestMapping("/getAllMajor")
	@ResponseBody
	public Map<String,Object> getAllMajor(Major major, String draw,
											  @RequestParam(required = false, defaultValue = "1") int start,
											  @RequestParam(required = false, defaultValue = "10") int length){

		Map<String,Object> map = new HashMap<>();
		PageInfo<Major> pageInfo = majorService.selectByPage(major, start, length);
		map.put("draw",draw);
		map.put("recordsTotal",pageInfo.getTotal());
		map.put("recordsFiltered",pageInfo.getTotal());
		map.put("data", pageInfo.getList());
		return map;
	}

	/**
	 * 查找全部专业
	 * @param model
	 * @return
	 */
	 @ResponseBody
	 @RequestMapping("/findAllMajor")
	    public String findAllMajor(Major major) {
		    System.out.println("查找条件--->"+major);
	        List<Major> list = majorService.findAllMajor(major);
	        String jsonString = JSON.toJSONString(list);
	        return jsonString;
	    }
    /**
     * 根据id查询专业
     * @param sid
     * @return
     */
    //ajax查询数据
    @ResponseBody
    @RequestMapping("/findMajorById")
    public Major findMajorById(@RequestParam("id") String id) {
    	System.out.println("查找学号--->"+id);
        return majorService.findMajorById(id);
    }

    /**
     * 根据姓名模糊查找专业
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping("/findMajorByName")
    public Major findmajorByName(@RequestParam("name") String name) {
        return majorService.findMajorByName(name);
    }
    
    @ResponseBody
    @RequestMapping("/deleteMajorById")
    public String deleteMajorById(String id) {
    	Integer flag = majorService.deleteMajorById(id);
    	if(flag>0) {
    		return "success";
    	}else {
    		return "error";
    	}
    }
	
    @ResponseBody
    @RequestMapping("/updateMajor")
    public String updatemajor(Major major) {
    	Integer flag = majorService.updateMajor(major);
    	String msg = "";
    	if(flag>0) {
    		msg = "success";
    	}else {
    		msg = "error";
    	}
    	return msg;
    }
    
    @ResponseBody
    @RequestMapping("/addMajor")
    public String addMajor(Major major) {
    	String id = UUID.randomUUID().toString().replace("-", "");
    	major.setId(id);
    	Integer flag = majorService.addMajor(major);
    	String msg = "";
    	if(flag>0) {
    		msg = "success";
    	}else {
    		msg = "error";
    	}
    	return msg;
    }
    
}
