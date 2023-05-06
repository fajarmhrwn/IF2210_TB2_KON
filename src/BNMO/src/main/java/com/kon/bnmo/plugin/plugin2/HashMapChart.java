package com.kon.bnmo.plugin.plugin2;

import java.util.HashMap;

public class HashMapChart {
    private HashMap<String, Integer> map;

    public HashMapChart(){
        map = new HashMap<String,Integer>();
    }

    public void add(String key){
        if(map.containsKey(key)) {
            map.put(key,1);
        }
        else{
            map.put(key,map.get(key)+1);
        }
    }

    public HashMap<String,Integer> getMap(){
        return map;
    }
}
