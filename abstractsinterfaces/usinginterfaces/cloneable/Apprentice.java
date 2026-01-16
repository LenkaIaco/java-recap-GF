package usinginterfaces.cloneable;

import com.gfa.animals.Gender;

public class Apprentice implements Cloneable {
    Gender gender;
    String name;
    int age;
    String previousOrganization;
    int skippedDays;

    public Apprentice(String name, int age, Gender gender, String previousOrganization) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.previousOrganization = previousOrganization;
    }

    public Apprentice() {
        previousOrganization = "The School of Life";
        skippedDays = 0;
    }

    public void printGoal() {
        System.out.println("My goal is: Be a junior software developer.");
    }


    public void introduce() {
        System.out.print("I am apprentice " + name);
        System.out.println(" from " + previousOrganization + " who skipped " + skippedDays + " days from the course already.");
    }


    public void skipDays(int numberOfDays) {
        skippedDays += numberOfDays;
    }

    @Override
    public Apprentice clone() {
        Object clone = new Object();
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            System.err.println("Cloning failed");
        }

        return (Apprentice) clone;
    }
}
