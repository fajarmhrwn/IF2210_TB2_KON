package com.kon.bnmo.datastore;

import com.kon.bnmo.holder.holder;
import com.kon.bnmo.items.Item;

import java.io.*;
import java.util.List;


public class OBJDataAdapter implements DataAdapter {
    @Override
    public void readData(holder dataHolder, String path) {
        /* TODO: parse OBJ ke List */
        if(dataHolder.getType() == "Item") {
            /* TODO: parse OBJ ke List Item */
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
                dataHolder.setItemList((List<Item>) ois.readObject());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return;
            }
        }else if(dataHolder.getType() == "Customer") {
            /* TODO: parse OBJ ke List Customer */
        }
    }
    @Override
    public void writeData(holder dataHolder, String path) {
        /* TODO: parse List ke OBJ */
        if(dataHolder.getType() == "Item") {
            /* TODO: parse List Item ke OBJ */
            List<Item> itemList = dataHolder.getItemList();
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
                oos.writeObject(itemList);
                oos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(dataHolder.getType() == "Customer") {
            /* TODO: parse List Customer ke OBJ */
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Item item = new Item("barang 1",10.000,"kategori 1","dummy.jpg",10);

        FileOutputStream fileOutputStream = new FileOutputStream("yourfile.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(item);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("yourfile.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Item p2 = (Item) objectInputStream.readObject();
        objectInputStream.close();

        assertTrue(item.equals(p2));
        System.out.println(item.getName());
        System.out.println(p2.getName());
    }

    private static void assertTrue(boolean b) {
        System.out.println(b);
    }
}
