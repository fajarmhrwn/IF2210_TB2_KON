package com.kon.bnmo.datastore;

import com.kon.bnmo.customers.CustomerModel;
import com.kon.bnmo.customers.MemberModel;
import com.kon.bnmo.customers.Person;
import com.kon.bnmo.customers.VIPModel;
import com.kon.bnmo.holder.holder;
import com.kon.bnmo.items.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class OBJDataAdapter implements DataAdapter {
    @Override
    public void readData(holder dataHolder, String path) {
        /* TODO: parse OBJ ke List */
        if(dataHolder.getType() == "Item") {
            /* TODO: parse OBJ ke List Item */
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path+"/item.obj"))) {
                dataHolder.setItemList((List<Item>) ois.readObject());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return;
            }
        }else if(dataHolder.getType() == "Customer") {
            /* TODO: parse OBJ ke List Customer */
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path+"/customer.obj"))) {
                dataHolder.addAll((List<CustomerModel>) ois.readObject());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return;
            }
            try{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path+"/member.obj"));
                dataHolder.addAll((List<MemberModel>) ois.readObject());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return;
            }
            try{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path+"/member.obj"));
                dataHolder.addAll((List<VIPModel>) ois.readObject());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return;
            }
        }
    }
    @Override
    public void writeData(holder dataHolder, String path) {
        /* TODO: parse List ke OBJ */
        if(dataHolder.getType() == "Item") {
            /* TODO: parse List Item ke OBJ */
            List<Item> itemList = dataHolder.getItemList();
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path+"/item.obj"))) {
                oos.writeObject(itemList);
                oos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(dataHolder.getType() == "Customer") {
            /* TODO: parse List Customer ke OBJ */
            List<Person> personList = dataHolder.getItemList();
            List<CustomerModel> customerList = new ArrayList<CustomerModel>();
            List<MemberModel> memberList = new ArrayList<MemberModel>();
            List<VIPModel> vipList = new ArrayList<VIPModel>();
            for(Person person : personList){
                if(person.getType() == "customer"){
                    customerList.add((CustomerModel) person);
                }else if(person.getType() == "member"){
                    memberList.add((MemberModel) person);
                }else if(person.getType() == "vip"){
                    vipList.add((VIPModel) person);
                }
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path+"/customer.obj"))) {
                oos.writeObject(customerList);
                oos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path+"/member.obj"))) {
                oos.writeObject(memberList);
                oos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path+"/vip.obj"))) {
                oos.writeObject(vipList);
                oos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
