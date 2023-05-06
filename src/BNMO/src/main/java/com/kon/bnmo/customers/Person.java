package com.kon.bnmo.customers;

import com.kon.bnmo.items.FixedBill;

import java.io.Serializable;
import java.util.List;

public abstract class Person implements Serializable {
    protected static final long serialVersionUID = 1L;
    protected String id;
    protected String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract String getType();

    public abstract  void setType(String type);


}
