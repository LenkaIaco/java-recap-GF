package exams.fishtank;

public class Kong extends Fish {
    //adding
    public Kong(){}
    public Kong(String name, int weight, String color){
        super(name, weight, color);
    }

    @Override
    public void feed(){
        setWeight(getWeight()+2);
    }
}
