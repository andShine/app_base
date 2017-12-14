package com.andshine.app.entity;

/**
 * 基本数据类型
 * Created by liu on 2017/12/14.
 */

public class SimpleEntity {
    public boolean status;
    public String msg;


    public BaseEntity toBaseEntity() {
        BaseEntity baseEntity = new BaseEntity();
        baseEntity.status = status;
        baseEntity.msg = msg;
        return baseEntity;
    }
}
