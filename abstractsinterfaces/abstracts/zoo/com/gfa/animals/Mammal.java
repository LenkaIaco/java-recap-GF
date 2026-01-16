package com.gfa.animals;

public class Mammal extends Animal {

    private AnimalClass aClass = AnimalClass.MAMMALS;

    public Mammal(Gender g){
        super("mammal", 0);
        super.gender = g;
    }

    public Mammal(String name){
        super(name, 0);
    }

    public String makeSound(){
        return "making sounds with my throat";
    }

    @Override
    public String breed(){
        return "pushing miniature versions out";
    }

    @Override
    public String move(){
        return "using my limbs to move";
    }

    public AnimalClass getaClass (){
        return aClass;
    }
}
