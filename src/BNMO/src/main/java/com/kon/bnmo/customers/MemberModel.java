package com.kon.bnmo.customers;

import com.kon.bnmo.customers.CustomerModel;
import com.kon.bnmo.items.FixedBill;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

public class MemberModel extends Person {
    private String name;
    private String phoneNumber;

    public MemberModel(String id, String name, String phoneNumber){
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public  MemberModel(){
        this.id = "";
        this.name = "";
        this.phoneNumber = "";
    }
    public MemberModel(MemberModel other){
        this.id = other.id;
        this.name = other.name;
        this.phoneNumber = other.phoneNumber;
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

    @Override
    public void setType(String type) {
        this.type = type;
    }
}
