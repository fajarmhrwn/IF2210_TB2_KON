package com.kon.bnmo.customers;

import com.kon.bnmo.customers.CustomerModel;

public class MemberModel extends CustomerModel {
    protected String name;
    protected String phoneNumber;
    protected int points;

    public MemberModel(String id, String name, String phoneNumber,int points){
        super(id);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.points = points;
    }

    public MemberModel(String id, String name){
        super(id);
        this.name = name;
        this.phoneNumber = "";
        this.points = 0;
    }

    public MemberModel(MemberModel other){
        super(other.id);
        this.name = other.name;
        this.phoneNumber = other.phoneNumber;
        this.points = other.points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public  void addPoints(int points){
        this.points += points;
    }

    public void redeemPoints(int points){
        this.points -= points;
    }

    public void redeemAllPoints(){
        this.points = 0;
    }

    public void addPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void removePhoneNumber(){
        this.phoneNumber = "";
    }

    public boolean isVIP(){
        return false;
    }
}
