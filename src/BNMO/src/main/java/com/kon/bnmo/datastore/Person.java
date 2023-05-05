package com.kon.bnmo.datastore;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        this.age = age;
        this.name = name;
    }

    public Person(){
        this.age = 0;
        this.name = "";
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
