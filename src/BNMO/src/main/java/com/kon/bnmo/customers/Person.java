package com.kon.bnmo.customers;

import com.kon.bnmo.items.FixedBill;

import java.io.Serializable;
import java.util.List;

public abstract class Person implements Serializable {
    protected static final long serialVersionUID = 1L;
    protected String id;
    protected String type;
    protected List<FixedBill> fixBills;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFixBills(List<FixedBill> fixBills) {
        this.fixBills = fixBills;
    }

    public List<FixedBill> getFixBills(){
        return this.fixBills;
    }
    public void addFixBill(FixedBill fixBill){
        this.fixBills.add(fixBill);
    }

    public void removeFixBill(FixedBill fixBill){
        this.fixBills.remove(fixBill);
    }

    public abstract String getType();

    public abstract  void setType(String type);


}
