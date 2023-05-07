package com.kon.bnmo.holder;

import java.util.ArrayList;
import java.util.List;

/* class parent dari kumpulan items atau kumpulan customer*/
abstract public class holder<T> {
    protected List<T> list;
    protected String type;

    public holder(String type){
        this.list = new ArrayList<T>();
        this.type = type;
    }

    public  holder(String type, List<T> itemList){
        this.list = new ArrayList<T>(itemList);
    }
    public String getType(){
        return this.type;
    }

    public void setType(){
        this.type = type;
    }

    abstract public  void add(T item);

    abstract public void remove(T item);

    public List<T> getList() {
        return list;
    }

    public void addAll(List<T> itemList) {
        this.list.addAll(itemList);
    }
    public void setList(List<T> itemList) {
        this.list = itemList;
    }
}
