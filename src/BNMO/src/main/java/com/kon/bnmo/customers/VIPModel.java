package com.kon.bnmo.customers;

public class VIPModel extends MemberModel{
    private  static final double DISCOUNT_RATE = 0.1;
    public VIPModel(String id, String name, String phoneNumber, int points) {
        super(id, name, phoneNumber, points);
    }

    public VIPModel(String id, String name) {
        super(id, name);
    }

    public VIPModel(MemberModel other) {
        super(other);
    }

    @Override
    public boolean isVIP() {
        return true;
    }

    public  double getDiscountRate(){
        return DISCOUNT_RATE;
    }
}
