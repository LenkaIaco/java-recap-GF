package banking;

import java.math.BigDecimal;

public class SpeedUpAccount extends Account{
    public SpeedUpAccount(String name, Customer owner, BigDecimal balance){
        super(name, owner, balance);
        super.setType(Type.SPEEDUP);
    }

    @Override
    public BigDecimal sendingFee(Customer receiver, BigDecimal amt){
        if (this.partners.contains(receiver)){
            return new BigDecimal(1000.00);
        }
        return new BigDecimal(1000.00).subtract(new BigDecimal(5000));
    }

    @Override
    public BigDecimal receivingFee(Customer sender, BigDecimal amt){
        return new BigDecimal(200.00);
    }

    @Override
    public void increaseBalance(Customer sender, BigDecimal amt){
        super.increaseBalance(sender, amt.subtract(receivingFee(sender, amt)));
    }

    @Override
    public void decreaseBalance(Customer receiver, BigDecimal amt){
        super.decreaseBalance(receiver, amt.add(receivingFee(receiver, amt)));
    }
}
