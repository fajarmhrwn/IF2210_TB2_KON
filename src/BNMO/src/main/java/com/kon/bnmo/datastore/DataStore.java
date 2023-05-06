package com.kon.bnmo.datastore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kon.bnmo.customers.CustomerHolder;
import com.kon.bnmo.holder.holder;
import com.kon.bnmo.items.ItemHolder;

import java.io.IOException;


public class DataStore {
    private  DataAdapter dataAdapter;
    private ItemHolder itemHolder;
    private CustomerHolder customerHolder;

    public DataStore(){
        itemHolder = new ItemHolder();
        customerHolder = new CustomerHolder();
    }

    public  void read(String path) throws IOException {
        dataAdapter.readData(this.itemHolder, path);
        dataAdapter.readData(this.customerHolder, path);
    }

    public void write(String path) throws IOException {
        dataAdapter.writeData(this.itemHolder, path);
        dataAdapter.writeData(this.customerHolder, path);
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

}
