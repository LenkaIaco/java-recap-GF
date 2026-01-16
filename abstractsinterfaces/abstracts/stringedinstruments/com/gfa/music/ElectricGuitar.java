package com.gfa.music;

public class ElectricGuitar extends StringedInstrument {

    @Override
    public String sound(){
        return "Twang";
    }

   public ElectricGuitar(){
        super.numberOfStrings = 6;
        super.name = "Electric Guitar";
    }

    public ElectricGuitar(int numberStrings){
        super(numberStrings);
    }

}
