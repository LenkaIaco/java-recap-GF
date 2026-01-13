package farm;

import animal.Animal;

import java.util.ArrayList;
import java.util.List;

public class Farm {
    private List<Animal> listAnimals;
    private int limit;

    public Farm() {
        listAnimals = new ArrayList<>();
        limit = Integer.MAX_VALUE;
    }

   public Farm(int limit) {
        listAnimals = new ArrayList<>();
        this.limit = limit;
    }

    public List<Animal> getAnimals() {
        List<Animal> copyList = new ArrayList<>(listAnimals); //shallow copy: new list w old references inside
        return copyList;
    }

    public int getLimit() {
        return limit;
    }

    public void breed() {
        if (listAnimals.size() < limit) {
            listAnimals.add(new Animal());
        } else {
            System.err.println("Farm is already full.");
        }
    }

    public void sell() {
        int max = Integer.MAX_VALUE;
        int index = -1;

        if (listAnimals.size() > 0) {
            for (int i = 0; i < listAnimals.size(); i++) {
                int currentHunger = listAnimals.get(i).getHunger();
                if (currentHunger < max) {
                    index = i;
                    max = currentHunger;
                }
            }

            if (index > -1) {
                listAnimals.remove(index);
            } else {
                listAnimals.remove(0);
            }
        }

    }

}
