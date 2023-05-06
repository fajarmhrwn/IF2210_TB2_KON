package com.kon.bnmo.items;

import com.kon.bnmo.cashier.BillContainer;
import com.kon.bnmo.cashier.ItemContainer;
import com.kon.bnmo.holder.holder;

import javax.xml.transform.Source;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FixedBill{
    private ArrayList<Billitem> listBillItem;
    private final LocalDate checkoutDate;

    public FixedBill(ArrayList<Billitem> listBillItem){
        this.listBillItem = new ArrayList<>();
        for(int i = 0; i < listBillItem.size(); i++){
            Billitem temp = new Billitem(listBillItem.get(i));
            this.listBillItem.add(listBillItem.get(i));
        }
        checkoutDate = LocalDate.now();
    }
    public FixedBill(ArrayList<Billitem> listBillItem, LocalDate date){
        this.listBillItem = new ArrayList<>();
        for(int i = 0; i < listBillItem.size(); i++){
            Billitem temp = new Billitem(listBillItem.get(i));
            this.listBillItem.add(listBillItem.get(i));
        }
        checkoutDate = date;
    }

    public ArrayList<Billitem> getListBillItem() {
        return listBillItem;
    }

    public LocalDate getCheckoutDateDate(){
        return checkoutDate;
    }
//    public static void main(String[] args){
//        ArrayList<Billitem> bill = new ArrayList<>();
//
////        BillContainer billCon1 = new BillContainer();
//        Billitem item1 =  new Billitem("barang1", 100.0, "barang", "sdjakjsd",
//                10, 3);
//        Billitem item2 =  new Billitem("barang2", 200.0, "barang", "sdjakjsd",
//                10, 4);
//
//        bill.add(item1);
//        bill.add(item2);
//
//        FixedBill fixbill = new FixedBill(bill);
//
//        for(int i = 0; i < fixbill.getListBillItem().size(); i++){
//            System.out.println(fixbill.getListBillItem().get(i).getName());
//        }
//        System.out.println(fixbill.getCheckoutDateDate());
//
//    }
}
