package exams.fishtank;

public abstract class Fish {
//adding
    private String name;
    private int weight;
   private String color;


    public Fish(){}
    public Fish(String name, int weight, String color){
        this.name=name;
        this.weight=weight;
        this.color=color;
    }

    public abstract void feed();

    public String getName(){return name;}
    public int getWeight(){return weight;}
    public String getColor(){return color;}

    public void setName(String name){this.name=name;}
    public void setWeight(int weight){this.weight=weight;}
    public void setColor(String color){this.color=color;}

    public String status(){
        return name +", weight: "+weight+", color: " +color;
    }
}
