package com.kon.bnmo.datastore;

import java.util.List;

abstract  public class OBJDataAdapter implements DataAdapter {
    @Override
    public void readData(List dataHolder, String path) {
        /* TODO: parse OBJ ke List */
    }
    @Override
    public void writeData(List dataHolder, String path) {
        /* TODO: parse List ke OBJ */
    }
}
