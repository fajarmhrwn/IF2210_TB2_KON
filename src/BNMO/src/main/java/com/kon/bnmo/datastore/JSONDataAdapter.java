package com.kon.bnmo.datastore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.kon.bnmo.holder.holder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kon.bnmo.items.Item;

import java.io.*;
import java.util.List;


public class JSONDataAdapter implements DataAdapter {
    @Override
    public void readData(holder dataHolder, String path) throws IOException {
        /* TODO: parse JSON ke List */
        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File(path);
        if(dataHolder.getType() == "Item") {
            /* TODO: parse JSON ke List Item */
            if (file.exists()) {
                List<Item> itemList = objectMapper.readValue(file, new TypeReference<List<Item>>() {});
                for (Item item : itemList) {
                    System.out.println(item.getName());
                }
                dataHolder.setItemList(itemList);
            } else {
                throw new FileNotFoundException("File not found at path: " + path);
            }

        }
        else if(dataHolder.getType() == "Customer") {
            /* TODO: parse JSON ke List Customer */
        }
    }
    @Override
    public void writeData(holder dataHolder, String path) throws IOException {
        /* TODO: parse List ke JSON */
        if(dataHolder.getType() == "Item") {
            /* TODO: parse List Item ke JSON */
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(dataHolder.getItemList());
            /* Save to file */
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(jsonString);
            fileWriter.close();
        }else if(dataHolder.getType() == "Customer") {
            /* TODO: parse List Customer ke JSON */
        }
    }

    public static void main(String[] args) throws IOException {

    }
}
