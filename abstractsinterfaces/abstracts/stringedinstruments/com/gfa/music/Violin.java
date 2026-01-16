package com.gfa.music;

public class Violin extends StringedInstrument {

    @Override
    public String sound(){
        return "Screech";
    }

    public Violin(String name, int numberStrings){
        super.numberOfStrings = numberStrings;
        super.name = name;
    }

    public Violin(){
        super.name = "Violin default";
        super.numberOfStrings = 4;
    }
}
