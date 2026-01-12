package petrolstation;

public class Sttn {
    private int gasAmount;

    public Sttn(int gasAmt){
        gasAmount = gasAmt;
    }

   public void refillCar(Cr car){
    int refillAmt = car.getCapacity() - car.getGasAmount();

    int possibleAmt = gasAmount>= refillAmt ? refillAmt : gasAmount;

    car.setGasAmount(car.getGasAmount() + possibleAmt);
    gasAmount=gasAmount-possibleAmt;
   }

    public int getGasAmount(){
        return gasAmount;
    }
    public void setGasAmount(int amt){
        gasAmount = amt;
    }
}
