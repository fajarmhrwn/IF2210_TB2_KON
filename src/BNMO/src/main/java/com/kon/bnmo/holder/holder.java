package com.kon.bnmo.holder;

import java.util.ArrayList;
import java.util.List;

/* class parent dari kumpulan items atau kumpulan customer*/
abstract public class holder<T> {
    protected List<T> itemList;
    protected String type;

    public holder(String type){
        this.itemList = new ArrayList<T>();
        this.type = type;
    }

    public  holder(String type, List<T> itemList){
        this.itemList = new ArrayList<T>(itemList);
    }
    public String getType(){
        return this.type;
    }

    public void setType(){
        this.type = type;
    }

    abstract public  void add(T item);

    abstract public void remove(T item);

    public List<T> getItemList() {
        return itemList;
    }

    public void setItemList(List<T> itemList) {
        this.itemList = itemList;
    }
}
