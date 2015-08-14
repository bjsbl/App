package com.app.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/8/14 0014.
 */
public abstract class Base implements Serializable {
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
