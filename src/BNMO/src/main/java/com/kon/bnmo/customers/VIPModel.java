package com.kon.bnmo.customers;

import com.kon.bnmo.items.FixedBill;

import java.util.ArrayList;
import java.util.List;

public class VIPModel extends Person{
    private String name;
    private String phoneNumber;
    private int point;

    public  VIPModel(){
        this.id = "";
        this.name = "";
        this.phoneNumber = "";
        this.point = 0;
        this.fixBills = new ArrayList<FixedBill>();
    }
    public VIPModel(String id, String name, String phoneNumber, int point){
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.point = point;
        this.fixBills = new ArrayList<FixedBill>();
    }

    public VIPModel(String id, String name, String phoneNumber, int point, List<FixedBill> fixBills){
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.point = point;
        this.fixBills = fixBills;
    }
    public VIPModel(VIPModel other){
        this.id = other.id;
        this.name = other.name;
        this.phoneNumber = other.phoneNumber;
        this.point = other.point;
        this.fixBills = other.fixBills;
    }

    //getter setter
    public String getName(){
        return this.name;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public int getPoint(){
        return this.point;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setPoint(int point){
        this.point = point;
    }

    public void addPoint(int point){
        this.point += point;
    }

    public void reducePoint(int point){
        this.point -= point;
    }

    @Override
    public String getType() {
        return "vip";
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }
}
