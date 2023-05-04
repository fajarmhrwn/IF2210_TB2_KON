package com.kon.bnmo.datastore;

import com.kon.bnmo.holder.holder;


public abstract class JSONDataAdapter implements DataAdapter {
    @Override
    public void readData(holder dataHolder, String path){
        /* TODO: parse JSON ke List */
        if(dataHolder.getType() == "Item") {
            /* TODO: parse JSON ke List Item */
        }
        else if(dataHolder.getType() == "Customer") {
            /* TODO: parse JSON ke List Customer */
        }
    }
    @Override
    public void writeData(holder dataHolder, String path){
        /* TODO: parse List ke JSON */
        if(dataHolder.getType() == "Item") {
            /* TODO: parse List Item ke JSON */
        }else if(dataHolder.getType() == "Customer") {
            /* TODO: parse List Customer ke JSON */
        }
    }
}
