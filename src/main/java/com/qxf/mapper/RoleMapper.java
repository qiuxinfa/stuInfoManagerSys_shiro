package com.qxf.mapper;

import com.qxf.pojo.Role;
import com.qxf.util.MyMapper;

import java.util.List;

public interface RoleMapper extends MyMapper<Role> {
    public List<Role> queryRoleListWithSelected(String id);
}