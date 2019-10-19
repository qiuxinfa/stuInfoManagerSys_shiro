package com.qxf.controller;

import com.github.pagehelper.PageInfo;
import com.qxf.pojo.Perms;
import com.qxf.service.PermsService;
import com.qxf.shiro.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/resources")
public class ResourcesController {

    @Resource
    private PermsService permsService;
    @Resource
    private ShiroService shiroService;

    @RequestMapping
    public Map<String,Object> getAll(Perms resources, String draw,
                                     @RequestParam(required = false, defaultValue = "1") int start,
                                     @RequestParam(required = false, defaultValue = "10") int length){
        Map<String,Object> map = new HashMap<>();
        PageInfo<Perms> pageInfo = permsService.selectByPage(resources, start, length);
        System.out.println("pageInfo.getTotal():"+pageInfo.getTotal());
        map.put("draw",draw);
        map.put("recordsTotal",pageInfo.getTotal());
        map.put("recordsFiltered",pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }

    @RequestMapping("/resourcesWithSelected")
    public List<Perms> resourcesWithSelected(Integer rid){
        return permsService.queryResourcesListWithSelected(rid);
    }

    @RequestMapping("/loadMenu")
    public List<Perms> loadMenu(){
        Map<String,Object> map = new HashMap<>();
        String userid = (String) SecurityUtils.getSubject().getSession().getAttribute("userSessionId");
        map.put("type",1);
        map.put("userid",userid);
        List<Perms> resourcesList = permsService.loadUserResources(map);
        return resourcesList;
    }

    //@CacheEvict(cacheNames="resources", allEntries=true)
    @RequestMapping(value = "/add")
    public String add(Perms resources){
        try{
            permsService.save(resources);
            //更新权限
            shiroService.updatePermission();
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
    //@CacheEvict(cacheNames="resources", allEntries=true)
    @RequestMapping(value = "/delete")
    public String delete(Integer id){
        try{
            permsService.delete(id);
            //更新权限
            shiroService.updatePermission();
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
}
