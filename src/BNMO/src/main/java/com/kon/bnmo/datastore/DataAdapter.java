package com.kon.bnmo.datastore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kon.bnmo.holder.holder;
import com.kon.bnmo.items.ItemHolder;

public interface DataAdapter {
    public void readData(holder dataHolder, String path) throws JsonProcessingException;
    public void writeData(holder dataHolder, String path);
}
