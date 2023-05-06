package com.kon.bnmo.datastore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.kon.bnmo.customers.*;
import com.kon.bnmo.holder.holder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kon.bnmo.items.Item;
import com.kon.bnmo.transaction.Transaction;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;


public class JSONDataAdapter implements DataAdapter {
    @Override
    public void readData(holder dataHolder, String path) throws IOException {
        /* TODO: parse JSON ke List */
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(path+"/item.json");
        File file = new File(path+"/item.json");
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);
        System.out.println(file.exists());
        if(dataHolder.getType() == "Item") {
            dataHolder.setItemList(new ArrayList<Item>());
            /* TODO: parse JSON ke List Item */
            if (file.exists()) {
                try {
                    List<Item> itemList = objectMapper.readValue(file, new TypeReference<List<Item>>() {
                    });
                    for (Item item : itemList) {
                        System.out.println(item.getName());
                    }
                    dataHolder.setItemList(itemList);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                throw new FileNotFoundException("File not found at path: " + path);
            }

        }
        else if(dataHolder.getType() == "Customer") {
            dataHolder.setItemList(new ArrayList<Person>());
            /* TODO: parse JSON ke List Customer */
            File file1 = new File(path + "/customer.json");
            if (file.exists()) {
                try {
                    List<CustomerModel> customerList = objectMapper.readValue(file1, new TypeReference<List<CustomerModel>>() {
                    });
                    dataHolder.addAll(customerList);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            File file2 = new File(path + "/member.json");
            if(file2.exists()){
                try {
                    List<MemberModel> memberList = objectMapper.readValue(file2, new TypeReference<List<MemberModel>>() {
                    });
                    dataHolder.addAll(memberList);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            File file3 = new File(path + "/VIP.json");
            if(file3.exists()){
                try {
                    List<VIPModel> personList = objectMapper.readValue(file3, new TypeReference<List<VIPModel>>() {
                    });
                    dataHolder.addAll(personList);
                    System.out.println("VIP");
                    for(VIPModel vip : personList){
                        System.out.println(vip.getName());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(dataHolder.getType() == "Transaction") {
            dataHolder.setItemList(new ArrayList<Transaction>());
            File file1 = new File(path + "/transaction.json");
            if (file.exists()) {
                try {
                    List<Transaction> transactionList = objectMapper.readValue(file1, new TypeReference<List<Transaction>>() {
                    });
                    dataHolder.setItemList(transactionList);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
            File file = new File(path+"/item.json");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(jsonString);
            fileWriter.close();
        }else if(dataHolder.getType() == "Customer") {
            /* TODO: parse List Customer ke JSON */
            ObjectMapper objectMapper = new ObjectMapper();
            List<Person> personList = dataHolder.getItemList();
            List<CustomerModel> customerList = new ArrayList<CustomerModel>();
            List<MemberModel> memberList = new ArrayList<MemberModel>();
            List<VIPModel> VIPList = new ArrayList<VIPModel>();
            for(Person person : personList){
                if(person.getType() == "customer"){
                    customerList.add((CustomerModel) person);
                }else if(person.getType() == "member"){
                    memberList.add((MemberModel) person);
                }else if(person.getType() == "vip"){
                    VIPList.add((VIPModel) person);
                }
            }
            System.out.println(VIPList.size());
            String jsonString1 = objectMapper.writeValueAsString(customerList);
            String jsonString2 = objectMapper.writeValueAsString(memberList);
            String jsonString3 = objectMapper.writeValueAsString(VIPList);
            /* Save to file */
            File file1 = new File(path+"/customer.json");
            FileWriter fileWriter1 = new FileWriter(file1);
            fileWriter1.write(jsonString1);
            fileWriter1.close();
            File file2 = new File(path+"/member.json");
            FileWriter fileWriter2 = new FileWriter(file2);
            fileWriter2.write(jsonString2);
            fileWriter2.close();
            File file3 = new File(path+"/VIP.json");
            FileWriter fileWriter3 = new FileWriter(file3);
            fileWriter3.write(jsonString3);
            fileWriter3.close();
        }else if(dataHolder.getType() == "Transaction") {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(dataHolder.getItemList());
            /* Save to file */
            File file = new File(path+"/transaction.json");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(jsonString);
            fileWriter.close();
        }
    }

    public static void main(String[] args) throws IOException {

    }
}
