package com.gfa.music;

public class BassGuitar extends StringedInstrument {

    @Override
    public String sound(){
        return "Duum-duum-duum";
    }

    public BassGuitar(){
        super.name = "Bass Guitar default";
        super.numberOfStrings = 4;
    }

    public BassGuitar(int numberStrings){
        super(numberStrings);
    }

    public BassGuitar(String name, int numberStrings){
        super.name = name;
        super.numberOfStrings = numberStrings;
    }


}
