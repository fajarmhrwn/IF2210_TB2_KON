package com.kon.bnmo.datastore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kon.bnmo.customers.CustomerHolder;
import com.kon.bnmo.holder.holder;
import com.kon.bnmo.items.ItemHolder;
import com.kon.bnmo.transaction.TransactionHolder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DataStore {
    private  DataAdapter dataAdapter;
    private ItemHolder itemHolder;

    private CustomerHolder customerHolder;

    private TransactionHolder transactionHolder;

    public static List<Double> kursMataUang = new ArrayList<Double>(); /* Kurs mata uang relatif thd IDR */

    public DataStore(){
        itemHolder = new ItemHolder();
        customerHolder = new CustomerHolder();
        transactionHolder = new TransactionHolder();
    }

    public  void read(String path) throws IOException {
        dataAdapter.readData(this.itemHolder, path);
        dataAdapter.readData(this.customerHolder, path);
        dataAdapter.readData(this.transactionHolder, path);
    }

    public void write(String path) throws IOException {
        dataAdapter.writeData(this.itemHolder, path);
        dataAdapter.writeData(this.customerHolder, path);
        dataAdapter.writeData(this.transactionHolder, path);
    }

    public TransactionHolder getTransactionHolder() {
        return transactionHolder;
    }

    public void setTransactionHolder(TransactionHolder transactionHolder) {
        this.transactionHolder = transactionHolder;
    }

    public static List<Double> getKursMataUang() {
        return kursMataUang;
    }

    public static void setKursMataUang(List<Double> kursMataUang) {
        DataStore.kursMataUang = kursMataUang;
    }

    public static  void addKursMataUang(Double kurs){
        kursMataUang.add(kurs);
    }

    public static void removeKursMataUang(int index){
        kursMataUang.remove(index);
    }

    public static void printKursMataUang(){
        for (int i = 0; i < kursMataUang.size(); i++) {
            System.out.println(kursMataUang.get(i));
        }
    }

    public void setDataAdapter(DataAdapter dataAdapter){
        this.dataAdapter = dataAdapter;
    }

    public DataAdapter getDataAdapter() {
        return dataAdapter;
    }

    public ItemHolder getItemHolder() {
        return itemHolder;
    }

    public void setItemHolder(ItemHolder itemHolder) {
        this.itemHolder = itemHolder;
    }

    public CustomerHolder getCustomerHolder() {
        return customerHolder;
    }

    public void setCustomerHolder(CustomerHolder customerHolder) {
        this.customerHolder = customerHolder;
    }


    public void printCustomerHolder(){
        for (int i = 0; i < customerHolder.getList().size(); i++) {
            System.out.println(customerHolder.getList().get(i).getType());
        }
    }

    public void printItemHolder(){
        for (int i = 0; i < itemHolder.getList().size(); i++) {
            System.out.println(itemHolder.getList().get(i).getName());
        }
    }

    public void printTransactionHolder(){
        for (int i = 0; i < transactionHolder.getList().size(); i++) {
            System.out.println(transactionHolder.getList().get(i).getIdCustomer());
        }
    }
}
