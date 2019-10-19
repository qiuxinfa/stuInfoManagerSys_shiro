package com.qxf.mapper;

import com.qxf.pojo.Perms;
import com.qxf.util.MyMapper;

import java.util.List;
import java.util.Map;

public interface PermsMapper extends MyMapper<Perms> {

    public List<Perms> queryAll();

    public List<Perms> loadUserPerms(Map<String, Object> map);

    public List<Perms> queryPermsListWithSelected(Integer rid);
}