package banking;

public enum Type {
    SAVINGS("Savings"), SPEEDUP("SpeedUp"), BALANCE("Balance");

   private String type;

    Type(String type){
        this.type = type;
    }
    @Override
    public String toString(){
        return type;
    }
}
