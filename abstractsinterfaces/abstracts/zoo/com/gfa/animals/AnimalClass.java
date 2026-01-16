package com.gfa.animals;

public enum AnimalClass {
    MAMMALS("mammals"), BIRDS("birds"), REPTILES("reptiles");

    private String aClass;

    AnimalClass(String aClass) {
        this.aClass = aClass;
    }

    @Override
    public String toString() {
        return this.aClass;
    }
}

