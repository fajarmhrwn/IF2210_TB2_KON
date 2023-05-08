package com.kon.bnmo.datastore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kon.bnmo.customers.CustomerHolder;
import com.kon.bnmo.holder.holder;
import com.kon.bnmo.items.ItemHolder;
import com.kon.bnmo.transaction.TransactionHolder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DataStore {
    private  DataAdapter dataAdapter;
    private ItemHolder itemHolder;

    private CustomerHolder customerHolder;

    private TransactionHolder transactionHolder;

    private  Map<String, Double> kursMataUangMap = new HashMap<>();
    // Populate kursMataUang with currency values relative to IDR
    private  String kursSekarang = "IDR";

    private Double fixprice = 1.05;

    private Boolean isPlugin = false;

    public Boolean getPlugin() {
        return isPlugin;
    }

    public void setPlugin(Boolean plugin) {
        isPlugin = plugin;
    }

    public Double getFixprice() {
        return fixprice;
    }

    public void setFixprice(Double fixprice) {
        this.fixprice = fixprice;
    }

    public Map<String, Double> getKursMataUangMap() {
        return kursMataUangMap;
    }

    public void setKursMataUangMap(Map<String, Double> kursMataUangMap) {
        this.kursMataUangMap = kursMataUangMap;
    }


    public String getKursSekarang() {
        return kursSekarang;
    }

    public void setKursSekarang(String kursSekarang) {
        this.kursSekarang = kursSekarang;
    }

    public void addKursMataUang(String mataUang, Double kurs){
        this.kursMataUangMap.put(mataUang, kurs);
    }

    public Double getDiskon() {
        return Diskon;
    }

    public void setDiskon(Double diskon) {
        Diskon = diskon;
    }

    private  Double Diskon = 0.0;
    public DataStore(){
        this.kursMataUangMap.put("IDR", 1.0);
        this.kursMataUangMap.put("USD", 0.000071);
        this.kursMataUangMap.put("EUR", 0.000059);
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
