package com.kon.bnmo.customers;

import com.kon.bnmo.customers.CustomerModel;

import java.util.ArrayList;

public class MemberModel extends Person {
    private String name;
    private String phoneNumber;

    public MemberModel(String id, String name, String phoneNumber){
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.fixBills = new ArrayList<String>();
    }

    public MemberModel(MemberModel other){
        this.id = other.id;
        this.name = other.name;
        this.phoneNumber = other.phoneNumber;
        this.fixBills = other.fixBills;
    }

    //getter setter
    public String getName(){
        return this.name;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getType() {
        return "member";
    }
}
