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
import com.qxf.pojo.Clazz;
import com.qxf.service.ClazzService;

@Controller
public class ClazzController {
	@Autowired
	private ClazzService clazzService;

	@RequestMapping("/getAllClazz")
	@ResponseBody
	public Map<String,Object> getAllMajor(Clazz clazz, String draw,
										  @RequestParam(required = false, defaultValue = "1") int start,
										  @RequestParam(required = false, defaultValue = "10") int length){

		Map<String,Object> map = new HashMap<>();
		PageInfo<Clazz> pageInfo = clazzService.selectByPage(clazz, start, length);
		map.put("draw",draw);
		map.put("recordsTotal",pageInfo.getTotal());
		map.put("recordsFiltered",pageInfo.getTotal());
		map.put("data", pageInfo.getList());
		return map;
	}
	/**
	 * 查找全部班级
	 * @param model
	 * @return
	 */
	 @ResponseBody
	 @RequestMapping("/findAllClazz")
	    public String findAllClazz(Clazz clazz) {
		    System.out.println("查找条件--->"+clazz);
	        List<Clazz> list = clazzService.findAllClazz(clazz);
	        String jsonString = JSON.toJSONString(list);
	        return jsonString;
	    }
    /**
     * 根据id查询班级
     * @param sid
     * @return
     */
    //ajax查询数据
    @ResponseBody
    @RequestMapping("/findClazzById")
    public Clazz findClazzById(@RequestParam("id") String id) {
    	System.out.println("查找学号--->"+id);
        return clazzService.findClazzById(id);
    }

    /**
     * 根据姓名模糊查找班级
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping("/findClazzByName")
    public Clazz findclazzByName(@RequestParam("name") String name) {
        return clazzService.findClazzByName(name);
    }
    
    @ResponseBody
    @RequestMapping("/deleteClazzById")
    public String deleteClazzById(String id) {
    	Integer flag = clazzService.deleteClazzById(id);
    	if(flag>0) {
    		return "success";
    	}else {
    		return "error";
    	}
    }
	
    @ResponseBody
    @RequestMapping("/updateClazz")
    public String updateClazz(Clazz clazz) {
    	Integer flag = clazzService.updateClazz(clazz);
    	String msg = "";
    	if(flag>0) {
    		msg = "success";
    	}else {
    		msg = "error";
    	}
    	return msg;
    }
    
    @ResponseBody
    @RequestMapping("/addClazz")
    public String addClazz(Clazz clazz) {
    	String id = UUID.randomUUID().toString().replace("-", "");
    	clazz.setId(id);
    	Integer flag = clazzService.addClazz(clazz);
    	String msg = "";
    	if(flag>0) {
    		msg = "success";
    	}else {
    		msg = "error";
    	}
    	return msg;
    }
    
}
