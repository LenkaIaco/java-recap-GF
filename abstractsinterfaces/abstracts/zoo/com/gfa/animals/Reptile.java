package com.gfa.animals;

public class Reptile extends Animal {
    private AnimalClass aClass = AnimalClass.REPTILES;

    public Reptile(Gender gender){
        super("reptile", 0);
        super.gender = gender;
    }

    public Reptile(String name){
        super(name, 0);
    }

    public String makeSound(){
        return "hissssssss";
    }

   @Override
    public String breed(){
        return "laying eggs";
    }

    @Override
    public String move(){
         return "slithering forward";
    }

    public AnimalClass getaClass(){
        return aClass;
    }

}
