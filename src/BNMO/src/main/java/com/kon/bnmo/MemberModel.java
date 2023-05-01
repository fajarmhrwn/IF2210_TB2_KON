package com.kon.bnmo;

public class MemberModel extends CustomerModel {
    public String name;
    public String phoneNumber;

    public MemberModel(String id, String name, String phoneNumber){
        super(id);
        this.name = name;
        this.phoneNumber = phoneNumber; 
    }
}
