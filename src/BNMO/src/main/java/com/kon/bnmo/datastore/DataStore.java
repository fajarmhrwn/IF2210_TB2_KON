package com.kon.bnmo.datastore;

import java.util.List;

public class DataStore {
    private  DataAdapter dataAdapter;
    private String path;

    public DataStore(DataAdapter dataAdapter, String path){
        this.dataAdapter = dataAdapter;
        this.path = path;
    }

    public void readData(List dataHolder){
        dataAdapter.readData(dataHolder, this.path);
    }

    public void writeData(List dataHolder){
        dataAdapter.writeData(dataHolder, this.path);
    }

    public void setDataAdapter(DataAdapter dataAdapter){
        this.dataAdapter = dataAdapter;
    }

    public void setPath(String path){
        this.path = path;
    }
}
