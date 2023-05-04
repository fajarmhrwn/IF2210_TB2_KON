package com.kon.bnmo.datastore;

import com.kon.bnmo.holder.holder;


abstract public class XMLDataAdapter implements  DataAdapter {
    @Override
    public void readData(holder dataHolder, String path) {
        /* TODO: parse XML ke List */
        if(dataHolder.getType() == "Item") {
            /* TODO: parse XML ke List Item */
        }else if(dataHolder.getType() == "Customer") {
            /* TODO: parse XML ke List Customer */
        }
    }

    @Override
    public void writeData(holder dataHolder, String path) {
        /* TODO: parse List ke XML */
        if(dataHolder.getType() == "Item") {
            /* TODO: parse List Item ke XML */
        }else if(dataHolder.getType() == "Customer") {
            /* TODO: parse List Customer ke XML */
        }
    }
}
