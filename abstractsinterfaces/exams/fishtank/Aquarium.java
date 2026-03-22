package exams.fishtank;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    List<Fish> fishes;

    public Aquarium(){
        fishes = new ArrayList<>();
    }

    public Aquarium(List<Fish> fishes){
        if(fishes==null){fishes=new ArrayList<>();}
        for (Fish f: fishes){
            fishes.add(f); //adding
        }
    }

    public void addFish(Fish fish){
        fishes.add(fish);
    }
    public void feed(){
        for (Fish f: fishes){
            f.feed();
        }
    }

    public void removeFish(){
        for (Fish f: fishes){
            if (f.getWeight()>11){
                fishes.remove(f);
            }
        }
    }

    public void getStatus(){
        String total = "Fishes in this aquarium:\n";
        for (Fish f: fishes){
           total = f.status() + "\n";
        }
        System.out.println(total);
    }
}
