package com.kon.bnmo.transaction;

import com.kon.bnmo.items.Billitem;
import com.kon.bnmo.items.FixedBill;
import com.kon.bnmo.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Transaction extends FixedBill{
    private int idCustomer;
    public Transaction(){
        super();
        this.idCustomer = 0;
    }
    public Transaction(int idCustomer,List<Billitem> listBillItem){
        super(listBillItem);
        this.idCustomer = idCustomer;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }
}
