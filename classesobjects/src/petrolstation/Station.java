package petrolstation;

public class Station {
    int gasAmount;

    public Station(int gasAmount) {
        this.gasAmount = gasAmount;
    }

    public void refillCar(Car emptyCar) {
        this.gasAmount -= emptyCar.capacity;
        emptyCar.gasAmount++;
    }
}
