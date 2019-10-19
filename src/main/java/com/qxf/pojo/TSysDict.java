package com.qxf.pojo;

import java.io.Serializable;

/**
 * @Auther: qiuxinfa
 * @Date: 2019/10/14
 * @Description: 数据字典
 */
public class TSysDict implements Serializable{
    private Integer id;
    private Integer dictCode;
    private String dictValue;
    private String dictTypeCode;
    private String dictDesc;
    private Integer dictOrder;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDictCode() {
        return dictCode;
    }

    public void setDictCode(Integer dictCode) {
        this.dictCode = dictCode;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictTypeCode() {
        return dictTypeCode;
    }

    public void setDictTypeCode(String dictTypeCode) {
        this.dictTypeCode = dictTypeCode;
    }

    public String getDictDesc() {
        return dictDesc;
    }

    public void setDictDesc(String dictDesc) {
        this.dictDesc = dictDesc;
    }

    public Integer getDictOrder() {
        return dictOrder;
    }

    public void setDictOrder(Integer dictOrder) {
        this.dictOrder = dictOrder;
    }

    @Override
    public String toString() {
        return "TSysDict{" +
                "id=" + id +
                ", dictCode=" + dictCode +
                ", dictValue='" + dictValue + '\'' +
                ", dictTypeCode='" + dictTypeCode + '\'' +
                ", dictDesc='" + dictDesc + '\'' +
                ", dictOrder=" + dictOrder +
                '}';
    }
}
