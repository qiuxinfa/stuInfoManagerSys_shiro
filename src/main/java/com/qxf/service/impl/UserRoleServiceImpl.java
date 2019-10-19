package com.qxf.service.impl;

import com.qxf.pojo.UserRole;
import com.qxf.service.UserRoleService;
import com.qxf.shiro.MyShiroRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("userRoleService")
public class UserRoleServiceImpl extends BaseService<UserRole> implements UserRoleService {
    @Autowired
    private MyShiroRealm myShiroRealm;

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void addUserRole(UserRole userRole) {
        //删除
        Example example = new Example(UserRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",userRole.getUserId());
        mapper.deleteByExample(example);
        //添加
        String[] roleids = userRole.getRoleId().split(",");
        for (String roleId : roleids) {
            UserRole u = new UserRole();
            String id = UUID.randomUUID().toString().replace("-", "");
            u.setId(id);
            u.setUserId(userRole.getUserId());
            u.setRoleId(roleId);
            mapper.insert(u);
        }
        //更新当前登录的用户的权限缓存
        List<String> userid = new ArrayList<>();
        userid.add(userRole.getUserId());
        myShiroRealm.clearUserAuthByUserId(userid);
    }
}
