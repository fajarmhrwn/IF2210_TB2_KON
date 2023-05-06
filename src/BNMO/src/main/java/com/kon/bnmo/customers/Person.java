package com.kon.bnmo.customers;

import java.util.List;

public abstract class Person {
    protected String id;
    protected List<String> fixBills;

    public List<String> getFixBills(){
        return this.fixBills;
    }
    public void addFixBill(String fixBill){
        this.fixBills.add(fixBill);
    }

    public void removeFixBill(String fixBill){
        this.fixBills.remove(fixBill);
    }

    public abstract String getType();
}
