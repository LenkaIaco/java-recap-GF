
package usinginterfaces.cloneable;

import com.gfa.animals.Gender;


public class Main {
    public static void main(String[] args) {
//        Apprentice john = new Apprentice("John", 20, Gender.MALE, "BME");
//        Person johnTheClone = john.clone();

        Apprentice john = new Apprentice("John", 20, Gender.MALE,"BME");
        Apprentice johnClone = john.clone();


        john.introduce();
        System.out.println("john and john clone same person? " + String.valueOf(john == johnClone));
        johnClone.introduce();

    }
}


