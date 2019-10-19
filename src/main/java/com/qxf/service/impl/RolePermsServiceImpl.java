package com.qxf.service.impl;

import com.qxf.pojo.Perms;
import com.qxf.service.RolePermsService;
import com.qxf.shiro.MyShiroRealm;
import com.qxf.mapper.UserRoleMapper;
import com.qxf.pojo.RolePerms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;


@Service("rolePermsService")
public class RolePermsServiceImpl extends BaseService<RolePerms> implements RolePermsService {
    @Resource
    private UserRoleMapper userRoleMapper;
    /*@Resource
    private ShiroService shiroService;*/
    @Autowired
    private MyShiroRealm myShiroRealm;

    @Override
    //更新权限
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    //@CacheEvict(cacheNames="resources", allEntries=true)
    public void addRolePerms(RolePerms roleResources) {
        //删除
        Example example = new Example(RolePerms.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleid",roleResources.getRoleId());
        mapper.deleteByExample(example);
        //添加
        if(!StringUtils.isEmpty(roleResources.getPermsId())){
            String[] resourcesArr = roleResources.getPermsId().split(",");
            for(String resourcesId:resourcesArr ){
                RolePerms r = new RolePerms();
                r.setRoleId(roleResources.getRoleId());
                r.setPermsId(resourcesId);
                mapper.insert(r);
            }
        }

        List<String> userIds= userRoleMapper.findUserIdByRoleId(roleResources.getRoleId());
        //更新当前登录的用户的权限缓存
        myShiroRealm.clearUserAuthByUserId(userIds);


    }

}
