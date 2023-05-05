package com.kon.bnmo.datastore;

import com.kon.bnmo.holder.holder;
import com.kon.bnmo.items.Item;
import com.kon.bnmo.items.ItemHolder;

import java.io.IOException;
import java.util.List;

public class cobaadapter {
    public static void main(String[] args) {
        ItemHolder itemHolder = new ItemHolder();
        itemHolder.add(new Item("Nasi padang", 18000.0, "makanan", "dummy.jpg", 10));
        itemHolder.add(new Item("Nasi padang", 18000.0, "makanan", "dummy.jpg", 10));
        itemHolder.add(new Item("Nasi padang", 18000.0, "makanan", "dummy.jpg", 10));
        itemHolder.add(new Item("Nasi padang", 18000.0, "makanan", "dummy.jpg", 10));

        ItemHolder itemHolder2 = new ItemHolder();

        DataStore dataStore = new DataStore(new JSONDataAdapter(), "items.json");
        try{
            dataStore.writeData(itemHolder);
        }catch (Exception e){
            System.out.println("Error");
            System.out.println(e.getMessage());
        }
        dataStore.setPath("input.xml");
        dataStore.setDataAdapter(new XMLDataAdapter());
        try{
            dataStore.readData(itemHolder2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(itemHolder2.getItemList().size());
        itemHolder.add(new Item("Nasi padang", 18000.0, "makanan", "dummy.jpg", 10));
        itemHolder.add(new Item("Nasi padang", 18000.0, "makanan", "dummy.jpg", 10));
        itemHolder.add(new Item("Nasi padang", 18000.0, "makanan", "dummy.jpg", 10));
        itemHolder.add(new Item("Nasi padang", 18000.0, "makanan", "dummy.jpg", 10));
        try{
            dataStore.writeData(itemHolder);
        }catch (Exception e){
            System.out.println("Error");
            System.out.println(e.getMessage());
        }

        dataStore.setPath("testobj.txt");
        dataStore.setDataAdapter(new OBJDataAdapter());
        try{
            dataStore.writeData(itemHolder);
        }catch (Exception e){
            System.out.println("Error");
            System.out.println(e.getMessage());
        }
        ItemHolder itemHolder3 = new ItemHolder();
        try{
            dataStore.readData(itemHolder3);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(itemHolder3.getItemList().size());
    }
}
