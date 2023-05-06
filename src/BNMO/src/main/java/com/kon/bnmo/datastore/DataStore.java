package com.kon.bnmo.datastore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kon.bnmo.customers.CustomerHolder;
import com.kon.bnmo.holder.holder;
import com.kon.bnmo.items.ItemHolder;
import com.kon.bnmo.transaction.TransactionHolder;

import java.io.IOException;


public class DataStore {
    private  DataAdapter dataAdapter;
    private ItemHolder itemHolder;

    private CustomerHolder customerHolder;

    private TransactionHolder transactionHolder;

    public TransactionHolder getTransactionHolder() {
        return transactionHolder;
    }

    public void setTransactionHolder(TransactionHolder transactionHolder) {
        this.transactionHolder = transactionHolder;
    }


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
        for (int i = 0; i < customerHolder.getItemList().size(); i++) {
            System.out.println(customerHolder.getItemList().get(i).getType());
        }
    }

    public void printItemHolder(){
        for (int i = 0; i < itemHolder.getItemList().size(); i++) {
            System.out.println(itemHolder.getItemList().get(i).getName());
        }
    }

    public void printTransactionHolder(){
        for (int i = 0; i < transactionHolder.getItemList().size(); i++) {
            System.out.println(transactionHolder.getItemList().get(i).getIdCustomer());
        }
    }
}
