package exams.fishtank;

public class Clownfish extends Fish{
    private String stripeColor;

    public Clownfish(){
    }

    public Clownfish(String name, int weight, String color, String stripeColor){
        super(name, weight,color);
        this.stripeColor=stripeColor;
    }

    @Override
    public void feed(){
        setWeight(getWeight()+1);
    }

    public String getStripeColor(){return stripeColor;}
    public void setStripeColor(String stripeColor){this.stripeColor = stripeColor;}

    @Override
    public String status(){
        String previous = super.status();
        return previous + ", stripes color: "+ stripeColor;
    }
}

