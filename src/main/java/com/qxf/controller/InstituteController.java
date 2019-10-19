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
import com.qxf.pojo.Institute;
import com.qxf.service.InstituteService;

@Controller
public class InstituteController {
	@Autowired
	private InstituteService instituteService;

	@RequestMapping("/getAllInstitute")
	@ResponseBody
	public  Map<String,Object> getAllInstitute(Institute institute, String draw,
									  @RequestParam(required = false, defaultValue = "1") int start,
									  @RequestParam(required = false, defaultValue = "10") int length){

		Map<String,Object> map = new HashMap<>();
		PageInfo<Institute> pageInfo = instituteService.selectByPage(institute, start, length);
		map.put("draw",draw);
		map.put("recordsTotal",pageInfo.getTotal());
		map.put("recordsFiltered",pageInfo.getTotal());
		map.put("data", pageInfo.getList());
		return map;
	}

	/**
	 * 查找全部学院
	 * @param model
	 * @return
	 */
	 @ResponseBody
	 @RequestMapping("/findAllInstitute")
	    public String findAllInstitute(Institute institute) {
		    System.out.println("查找条件--->"+institute);
	        List<Institute> list = instituteService.findAllInstitute(institute);
	        String jsonString = JSON.toJSONString(list);
	        return jsonString;
	    }
    /**
     * 根据id查询学院
     * @param sid
     * @return
     */
    //ajax查询数据
    @ResponseBody
    @RequestMapping("/findInstituteById")
    public Institute findInstituteById(@RequestParam("id") String id) {
        return instituteService.findInstituteById(id);
    }

    /**
     * 根据姓名模糊查找学院
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping("/findInstituteByName")
    public Institute findInstituteByName(@RequestParam("name") String name) {
        return instituteService.findInstituteByName(name);
    }
    
    @ResponseBody
    @RequestMapping("/deleteInstituteById")
    public String deleteInstituteById(String id) {
    	Integer flag = instituteService.deleteInstituteById(id);
    	if(flag>0) {
    		return "success";
    	}else {
    		return "error";
    	}
    }
	
    @ResponseBody
    @RequestMapping("/updateInstitute")
    public String updateinstitute(Institute institute) {
    	Integer flag = instituteService.updateInstitute(institute);
    	String msg = "";
    	if(flag>0) {
    		msg = "success";
    	}else {
    		msg = "error";
    	}
    	return msg;
    }
    
    @ResponseBody
    @RequestMapping("/addInstitute")
    public String addInstitute(Institute institute) {
    	String id = UUID.randomUUID().toString().replace("-", "");
    	institute.setId(id);
    	Integer flag = instituteService.addInstitute(institute);
    	if(flag>0) {
    		return "success";
    	}else {
    		return "error";
    	}
    }
    
}
