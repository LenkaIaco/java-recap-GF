package com.gfa.animals;

public abstract class Animal {
    protected String name;
    protected int age;
    protected Gender gender;

    protected Animal(){}
    protected Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public abstract String breed();
    protected abstract String move();

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

    public Gender getGender() {
        return gender;
    }


}
