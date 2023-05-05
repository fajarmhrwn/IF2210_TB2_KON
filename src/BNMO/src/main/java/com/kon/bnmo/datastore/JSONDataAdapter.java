package com.kon.bnmo.datastore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kon.bnmo.holder.holder;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Console;


public abstract class JSONDataAdapter implements DataAdapter {
    @Override
    public void readData(holder dataHolder, String path) throws JsonProcessingException {
        /* TODO: parse JSON ke List */
        if(dataHolder.getType() == "Item") {
            /* TODO: parse JSON ke List Item */
            ObjectMapper objectMapper = new ObjectMapper();
            String json = "{\"name\":\"John\",\"age\":30}";

            Person person = objectMapper.readValue(json, Person.class);

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

    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{\"name\":\"John\",\"age\":30}";

        Person person = objectMapper.readValue(json, Person.class);
        System.out.println(person.getName());
    }
}
