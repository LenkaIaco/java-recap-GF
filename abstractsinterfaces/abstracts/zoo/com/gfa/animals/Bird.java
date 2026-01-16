package com.gfa.animals;

public class Bird extends Animal{
    private AnimalClass aClass = AnimalClass.BIRDS;

    public Bird(Gender g){
        super("bird",0);
        super.gender = g;
    }

    public Bird(String name){
        super(name, 0);
    }

    public String makeSound(){
        return "tweet tweet";
    }

    @Override
    public String breed(){
        return "laying eggs";
    }

    @Override
    public String move(){
        return "flap my wings and fly";
    }

    public AnimalClass getaClass(){
        return aClass;
    }
}
