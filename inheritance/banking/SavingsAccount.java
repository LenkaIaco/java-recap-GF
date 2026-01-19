package banking;

import java.math.BigDecimal;

public class SavingsAccount extends Account {
    public SavingsAccount(String name, Customer owner, BigDecimal balance) {
        super(name, owner, balance);
        super.setType(Type.SAVINGS);
    }

    @Override
    public BigDecimal sendingFee(Customer receiver, BigDecimal amt) {
        return new BigDecimal(100.00);
    }

    @Override
    public BigDecimal receivingFee(Customer sender, BigDecimal amt){
        return new BigDecimal(20.00);
    }


    @Override
    public void decreaseBalance( Customer receiver, BigDecimal amt){
        super.decreaseBalance(receiver, amt.add(sendingFee(receiver, amt)));
    }

    @Override
    public void increaseBalance(Customer sender, BigDecimal amt){
        super.increaseBalance(sender, amt.subtract(receivingFee(sender, amt)));
    }
}
