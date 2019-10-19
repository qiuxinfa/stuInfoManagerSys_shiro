package com.qxf.mapper;

import com.qxf.pojo.UserRole;
import com.qxf.util.MyMapper;

import java.util.List;

public interface UserRoleMapper extends MyMapper<UserRole> {
    public List<String> findUserIdByRoleId(String roleId);
}