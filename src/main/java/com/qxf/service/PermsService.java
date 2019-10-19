package com.qxf.service;

import com.github.pagehelper.PageInfo;
import com.qxf.pojo.Perms;

import java.util.List;
import java.util.Map;

public interface PermsService extends IService<Perms> {
    PageInfo<Perms> selectByPage(Perms resources, int start, int length);

    public List<Perms> queryAll();

    public List<Perms> loadUserResources(Map<String, Object> map);

    public List<Perms> queryResourcesListWithSelected(Integer rid);
}
