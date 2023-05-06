package com.kon.bnmo.datastore;

import com.kon.bnmo.holder.holder;
import com.kon.bnmo.items.Item;
import com.kon.bnmo.items.ItemHolder;

import java.io.IOException;
import java.util.List;

public class cobaadapter {
    public static void main(String[] args) {
        DataStore dataStore = new DataStore();
        dataStore.setDataAdapter(new JSONDataAdapter());
        try{
            dataStore.readItem("items.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ItemHolder itemHolder = dataStore.getItemHolder();
        List<Item> items = itemHolder.getItemList();
        for (Item item : items) {
            System.out.println(item.getName());
        }

        dataStore.setDataAdapter(new XMLDataAdapter());
        try{
            dataStore.readItem("input.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        itemHolder = dataStore.getItemHolder();
        items = itemHolder.getItemList();
        for (Item item : items) {
            System.out.println(item.getName());
        }

        dataStore.setDataAdapter(new OBJDataAdapter());
        try{
            dataStore.readItem("testobj.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        itemHolder = dataStore.getItemHolder();
        items = itemHolder.getItemList();
        for (Item item : items) {
            System.out.println(item.getName());
        }
    }
}
