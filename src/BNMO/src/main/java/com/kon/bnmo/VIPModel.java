package com.kon.bnmo;

public class VIPModel extends MemberModel {
    public boolean isVIP;

    VIPModel(String id, String name, String phoneNumber){
        super(id, name, phoneNumber);
        this.isVIP = true;
    }
}
