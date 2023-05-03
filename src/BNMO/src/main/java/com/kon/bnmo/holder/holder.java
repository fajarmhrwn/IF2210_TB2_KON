package com.kon.bnmo.holder;

import java.util.List;

/* class parent dari kumpulan items atau kumpulan customer*/
abstract public class holder {
    List<holder> list;
    String type;
    public holder(List<holder> list, String type){
        this.list = list;
        this.type = type;
    }

    public List<holder> getList(){
        return list;
    }

    public String getType(){
        return type;
    }

    public void setList(List<holder> list){
        this.list = list;
    }

    public void setType(String type){
        this.type = type;
    }
}
