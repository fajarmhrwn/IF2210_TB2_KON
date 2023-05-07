package com.kon.bnmo.customers;

import com.kon.bnmo.holder.holder;

import java.util.List;

public class CustomerHolder extends holder<Person>{
    public CustomerHolder(){
        super("Customer");
    }
    public CustomerHolder(CustomerHolder other){
        super("Customer", other.getList());
    }

    @Override
    public void add(Person item) {
        List<Person> listPerson = super.getList();
        listPerson.add(item);
        super.setList(listPerson);
    }

    @Override
    public void remove(Person item) {
        List<Person> listPerson = super.getList();
        listPerson.remove(item);
        super.setList(listPerson);
    }
}
