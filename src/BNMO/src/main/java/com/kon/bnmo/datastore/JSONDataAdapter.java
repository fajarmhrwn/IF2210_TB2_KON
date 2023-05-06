package com.kon.bnmo.datastore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.kon.bnmo.customers.*;
import com.kon.bnmo.holder.holder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kon.bnmo.items.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


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
                }else if(person.getType() == "VIP"){
                    VIPList.add((VIPModel) person);
                }
            }
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
        }
    }

    public static void main(String[] args) throws IOException {

    }
}
