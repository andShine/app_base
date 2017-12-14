package com.andshine.app.entity;

import java.io.Serializable;

/**
 * Created by liu on 2017/12/14.
 */

public class BaseEntity<T> implements Serializable {

    public boolean status;
    public String msg;

    public T data;

}
