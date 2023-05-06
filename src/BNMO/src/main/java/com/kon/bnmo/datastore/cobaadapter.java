package com.kon.bnmo.datastore;

import com.kon.bnmo.customers.CustomerHolder;
import com.kon.bnmo.customers.CustomerModel;
import com.kon.bnmo.customers.MemberModel;
import com.kon.bnmo.customers.Person;
import com.kon.bnmo.holder.holder;
import com.kon.bnmo.items.Item;
import com.kon.bnmo.items.ItemHolder;

import java.io.IOException;
import java.util.List;

public class cobaadapter {
    public static void main(String[] args) throws IOException {
        DataStore dataStore = new DataStore();
        dataStore.setDataAdapter(new JSONDataAdapter());
        try{
            dataStore.read("/Users/fajarherawan/Documents/IF2210_TB2_KON/src/BNMO/DataStore");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ItemHolder itemHolder = dataStore.getItemHolder();
        CustomerHolder customerHolder = dataStore.getCustomerHolder();
        for(Item item : itemHolder.getItemList()){
            System.out.println(item.getName());
        }
        for(Person person : customerHolder.getItemList()){
            System.out.println(person.getType());
        }

        customerHolder.add(new MemberModel("1","fajar","08123456789"));
        customerHolder.add(new MemberModel("2","herawan","08123456789"));
        customerHolder.add(new MemberModel("3","fajarherawan","08123456789"));
        customerHolder.add(new MemberModel("4","fajar herawan","08123456789"));

        dataStore.write("/Users/fajarherawan/Documents/IF2210_TB2_KON/src/BNMO/DataStore");

    }
}
