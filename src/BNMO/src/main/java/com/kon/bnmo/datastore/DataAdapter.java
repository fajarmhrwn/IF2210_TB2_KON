package com.kon.bnmo.datastore;

import com.kon.bnmo.items.ItemHolder;

import java.util.List;

public interface DataAdapter {
    public void readData(List dataHolder, String path);
    public void writeData(List dataHolder, String path);
}
