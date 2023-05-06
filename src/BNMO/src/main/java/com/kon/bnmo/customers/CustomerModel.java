package com.kon.bnmo.customers;

import com.kon.bnmo.items.FixedBill;

import java.util.ArrayList;
import java.util.List;

public class CustomerModel extends Person {
    public CustomerModel(String id){
        this.id = id;
        this.fixBills = new ArrayList<FixedBill>();
    }

    public  CustomerModel(){
        this.id = "";
        this.fixBills = new ArrayList<FixedBill>();
    }

    public CustomerModel(String id, List<FixedBill> fixBills){
        this.id = id;
        this.fixBills = fixBills;
    }
    @Override
    public String getType() {
        return "customer";
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }
}
