package com.kon.bnmo.customers;

import java.util.ArrayList;

public class CustomerModel extends Person {
    public CustomerModel(String id){
        this.id = id;
        this.fixBills = new ArrayList<String>();
    }

    @Override
    public String getType() {
        return "customer";
    }
}
