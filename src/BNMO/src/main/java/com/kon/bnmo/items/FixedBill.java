package com.kon.bnmo.items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class FixedBill implements Serializable {
    private List<Billitem> listBillItem;
    private String checkoutDate;

    public FixedBill(){
        listBillItem = new ArrayList<>();
        checkoutDate = LocalDate.now().toString();
    }
//    public FixedBill(List<Billitem> billItems, String date) {
//        this.listBillItem = new ArrayList<>();
//        for(int i = 0; i < billItems.size(); i++){
//            Billitem temp = new Billitem(billItems.get(i));
//            this.listBillItem.add(temp);
//        }
//        checkoutDate = LocalDate.parse(date);
//    }
    public FixedBill(List<Billitem> listBillItem){
        this.listBillItem = new ArrayList<>();
        for(int i = 0; i < listBillItem.size(); i++){
            Billitem temp = new Billitem(listBillItem.get(i));
            this.listBillItem.add(listBillItem.get(i));
        }
        checkoutDate = LocalDate.now().toString();
    }

    @JsonCreator
    public FixedBill(@JsonProperty("listBillItem") List<Billitem> listBillItem,
                     @JsonProperty("checkoutDate") String checkoutDate) {
        this.listBillItem = new ArrayList<>();
        for(int i = 0; i < listBillItem.size(); i++){
            Billitem temp = new Billitem(listBillItem.get(i));
            this.listBillItem.add(listBillItem.get(i));
        }
        this.checkoutDate = LocalDate.parse(checkoutDate).toString();
    }
    public FixedBill(List<Billitem> listBillItem, LocalDate date){
        this.listBillItem = new ArrayList<>();
        for(int i = 0; i < listBillItem.size(); i++){
            Billitem temp = new Billitem(listBillItem.get(i));
            this.listBillItem.add(listBillItem.get(i));
        }
        checkoutDate = date.toString();
    }


    public void setListBillItem(ArrayList<Billitem> listBillItem) {
        this.listBillItem = listBillItem;
    }

    public String getCheckoutDate() {
        return checkoutDate.toString();
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public List<Billitem> getListBillItem() {
        return listBillItem;
    }

    public LocalDate keluarkanTanggal(){
        return LocalDate.parse(checkoutDate);
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
