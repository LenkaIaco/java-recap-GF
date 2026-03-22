package exams.fishtank;

public class Tang extends Fish{
    //adding
    private boolean shortMemoryLoss;
    public Tang(){}

public Tang(String name, int weight, String color, boolean memoryLoss){
        super(name,weight,color);
        shortMemoryLoss = memoryLoss;
}

    @Override
    public void feed(){
        setWeight(getWeight()+1);
    }

    @Override
    public String status(){
        String previous = super.status();
        return previous + ", short-term memory loss: " + shortMemoryLoss;
    }

    public boolean getShortMemoryLoss(){return shortMemoryLoss;}
    public void setShortMemoryLoss(boolean loss){
        shortMemoryLoss=loss;
    }
}
