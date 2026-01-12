package animal;

public class Animal {
    private int hunger;
    private int thirst;

    public Animal(){
        hunger = 50;
        thirst = 50;
    }

    public void eat(){
        hunger--;
    }
    public void drink(){
        thirst--;
    }

    public void play(){
        hunger++;
        thirst++;
    }

    public int getHunger(){
        return hunger;
    }

    public int getThirst(){
        return thirst;
    }

    @Override
    public String toString(){
        return "\n" + "Hunger " + hunger + " Thirst: "+thirst;
    }
}
