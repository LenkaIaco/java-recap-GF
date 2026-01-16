package com.gfa.music;

public abstract class StringedInstrument extends Instrument {
    protected int numberOfStrings;


    abstract String sound();


    @Override
    public String play(){
        System.out.println(sound());
        return sound();
    }

    protected StringedInstrument(){}
    protected StringedInstrument(int numberOfStrings){
        this.numberOfStrings = numberOfStrings;
    }
}
