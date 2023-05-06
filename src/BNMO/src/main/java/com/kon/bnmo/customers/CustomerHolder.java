package com.kon.bnmo.customers;

import com.kon.bnmo.holder.holder;

import java.util.List;

public class CustomerHolder extends holder<Person>{
    public CustomerHolder(){
        super("Customer");
    }
    public CustomerHolder(CustomerHolder other){
        super("Customer", other.getItemList());
    }

    @Override
    public void add(Person item) {
        List<Person> listPerson = super.getItemList();
        listPerson.add(item);
        super.setItemList(listPerson);
    }

    @Override
    public void remove(Person item) {
        List<Person> listPerson = super.getItemList();
        listPerson.remove(item);
        super.setItemList(listPerson);
    }
}
