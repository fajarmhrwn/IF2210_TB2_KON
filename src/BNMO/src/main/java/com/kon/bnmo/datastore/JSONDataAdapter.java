package com.kon.bnmo.datastore;
import  com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kon.bnmo.holder.holder;
import com.kon.bnmo.items.ItemHolder;
import com.kon.bnmo.items.StorageItem;

public abstract class JSONDataAdapter implements DataAdapter {
    @Override
    public void readData(holder dataHolder, String path){
        /* TODO: parse JSON ke List */
        if(dataHolder.getType() == "Item") {
            /* TODO: parse JSON ke List Item */
            Gson gson = new Gson();
            String json = gson.toJson(dataHolder.getItemList());
            System.out.println(json);
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

    public static void main(String[] args) {

        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        Student student = gson.fromJson(jsonString, Student.class);
        System.out.println(student);

        jsonString = gson.toJson(student);
        System.out.println(jsonString);
    }
}
