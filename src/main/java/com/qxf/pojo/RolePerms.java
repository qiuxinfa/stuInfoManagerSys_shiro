package com.qxf.pojo;

import java.io.Serializable;

/**
 * @Auther: qiuxinfa
 * @Date: 2019/10/10
 * @Description: 角色-权限表
 */
public class RolePerms implements Serializable{
    private String id;
    private String roleId;
    private String permsId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermsId() {
        return permsId;
    }

    public void setPermsId(String permsId) {
        this.permsId = permsId;
    }

    @Override
    public String toString() {
        return "RolePerms{" +
                "id='" + id + '\'' +
                ", roleId='" + roleId + '\'' +
                ", permsId='" + permsId + '\'' +
                '}';
    }

}
