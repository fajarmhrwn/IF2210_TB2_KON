package com.kon.bnmo.datastore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kon.bnmo.holder.holder;


public class DataStore {
    private  DataAdapter dataAdapter;
    private String path;

    public DataStore(DataAdapter dataAdapter, String path){
        this.dataAdapter = dataAdapter;
        this.path = path;
    }

    public void readData(holder dataHolder) throws JsonProcessingException {
        dataAdapter.readData(dataHolder, this.path);
    }

    public void writeData(holder dataHolder){
        dataAdapter.writeData(dataHolder, this.path);
    }

    public void setDataAdapter(DataAdapter dataAdapter){
        this.dataAdapter = dataAdapter;
    }

    public void setPath(String path){
        this.path = path;
    }
}
