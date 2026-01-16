package interfaces.flyable;
public abstract class Vehicle {
    int oil;
    String start(){
        return "starting engine";
    }
    abstract String park();
}
