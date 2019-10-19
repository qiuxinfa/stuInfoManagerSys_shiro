package com.qxf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qxf.mapper.PermsMapper;
import com.qxf.pojo.Perms;
import com.qxf.service.PermsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("permsService")
public class PermsServiceImpl extends BaseService<Perms> implements PermsService {
   @Autowired
    private PermsMapper permsMapper;

    @Override
    public PageInfo<Perms> selectByPage(Perms resources, int start, int length) {
        int page = start/length+1;
        Example example = new Example(Perms.class);
        //分页查询
        PageHelper.startPage(page, length);
        List<Perms> userList = selectByExample(example);
        return new PageInfo<>(userList);
    }

    @Override
    public List<Perms> queryAll(){

        return permsMapper.queryAll();
    }

    @Override
    //@Cacheable(cacheNames="resources",key="#map['userid'].toString()+#map['type']")
    public List<Perms> loadUserResources(Map<String, Object> map) {
        return permsMapper.loadUserPerms(map);
    }

    @Override
    public List<Perms> queryResourcesListWithSelected(Integer rid) {
        return permsMapper.queryPermsListWithSelected(rid);
    }
}
