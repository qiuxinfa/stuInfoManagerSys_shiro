package com.qxf.pojo;

import java.io.Serializable;

/**
 * @Auther: qiuxinfa
 * @Date: 2019/10/10
 * @Description: 角色表
 */
public class Role implements Serializable{
    private String id;
    private String name;
    private String selected;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
