package com.kon.bnmo.datastore;

import com.kon.bnmo.holder.holder;
import com.kon.bnmo.items.ItemHolder;

import java.util.List;

public abstract class JSONDataAdapter implements DataAdapter {
    @Override
    public void readData(List dataHolder, String path){
        /* TODO: parse JSON ke List */
    }
    @Override
    public void writeData(List dataHolder, String path){
        /* TODO: parse List ke JSON */
    }
}
