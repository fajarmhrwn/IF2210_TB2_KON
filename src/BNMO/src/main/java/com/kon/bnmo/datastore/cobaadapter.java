package com.kon.bnmo.datastore;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kon.bnmo.customers.*;
import com.kon.bnmo.items.Billitem;
import com.kon.bnmo.items.Item;
import com.kon.bnmo.items.ItemHolder;
import com.kon.bnmo.transaction.Transaction;
import com.kon.bnmo.transaction.TransactionHolder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class cobaadapter {
    public static void main(String[] args) throws IOException {
        DataStore dataStore = new DataStore();
        dataStore.setDataAdapter(new JSONDataAdapter());
        try{
            dataStore.read("/Users/fajarherawan/Documents/IF2210_TB2_KON/src/BNMO/DataStore/JSON");
            System.out.println("File berhasil di read");
        }catch (IOException e){
            System.out.println("Error");
        }
        System.out.println("JSON");
        dataStore.printItemHolder();
        System.out.println("JSON");
        dataStore.printCustomerHolder();
        System.out.println("JSON");
        dataStore.printTransactionHolder();

        ItemHolder itemHolder = dataStore.getItemHolder();
        CustomerHolder customerHolder = dataStore.getCustomerHolder();
        TransactionHolder transactionHolder = dataStore.getTransactionHolder();
        List<Item> items = itemHolder.getList();
        List<Person> customers = customerHolder.getList();
        List<Transaction> transactions = transactionHolder.getList();

        for (Item item : items) {
            System.out.println(item.getName());
        }

        for (Person customer : customers) {
            System.out.println(customer.getType());
        }

        for (Transaction transaction : transactions) {
            System.out.println(transaction.getIdCustomer());
        }


        dataStore.setDataAdapter(new OBJDataAdapter());
        try{
            dataStore.write("/Users/fajarherawan/Documents/IF2210_TB2_KON/src/BNMO/DataStore/OBJ");
            System.out.println("File berhasil dibuat");
        }catch (IOException e) {
            System.out.println("Error");
        }
//        try{
//            dataStore.read("/Users/fajarherawan/Documents/IF2210_TB2_KON/src/BNMO/DataStore/XML");
//        }catch (IOException e){
//            System.out.println("Error");
//        }




//        try{
//            dataStore.read("/Users/fajarherawan/Documents/IF2210_TB2_KON/src/BNMO/DataStore/JSON");
//        }catch (IOException e){
//            System.out.println("Error");
//        }
//        try{
//            dataStore.write("/Users/fajarherawan/Documents/IF2210_TB2_KON/src/BNMO/DataStore/JSON");
//        }catch (IOException e){
//            System.out.println("Error");
//        }
//
//        dataStore.setDataAdapter(new OBJDataAdapter());
//        try{
//            dataStore.write("/Users/fajarherawan/Documents/IF2210_TB2_KON/src/BNMO/DataStore/OBJ");
//        }catch (IOException e){
//            System.out.println("Error");
//        }


    }
}
