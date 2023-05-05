package com.kon.bnmo.datastore;

import com.kon.bnmo.holder.holder;


abstract  public class OBJDataAdapter implements DataAdapter {
    @Override
    public void readData(holder dataHolder, String path) {
        /* TODO: parse OBJ ke List */
        if(dataHolder.getType() == "Item") {
            /* TODO: parse OBJ ke List Item */
        }else if(dataHolder.getType() == "Customer") {
            /* TODO: parse OBJ ke List Customer */
        }
    }
    @Override
    public void writeData(holder dataHolder, String path) {
        /* TODO: parse List ke OBJ */
        if(dataHolder.getType() == "Item") {
            /* TODO: parse List Item ke OBJ */
        }else if(dataHolder.getType() == "Customer") {
            /* TODO: parse List Customer ke OBJ */
        }
    }
}
