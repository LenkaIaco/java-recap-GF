package banking;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class BalanceAccount extends Account{
    public BalanceAccount(String name, Customer owner, BigDecimal balance){
        super(name, owner, balance);
        super.setType(Type.BALANCE);
    }

    @Override
    public BigDecimal sendingFee(Customer receiver, BigDecimal amt){
        return amt.multiply(new BigDecimal(0.002));
    }

    @Override
    public BigDecimal receivingFee(Customer sender, BigDecimal amt){
        if (LocalDate.now().getDayOfWeek().equals(DayOfWeek.SATURDAY)
                ||
                LocalDate.now().getDayOfWeek().equals(DayOfWeek.SUNDAY)){
            return  amt.multiply(new BigDecimal(0.003));
        }
        return amt.multiply(new BigDecimal(0.001));
    }

    @Override
    public void increaseBalance(Customer sender, BigDecimal amt){
    super.increaseBalance(sender, amt.subtract(receivingFee(sender, amt)));
    }

    @Override
    public void decreaseBalance(Customer receiver, BigDecimal amt){
        super.decreaseBalance(receiver, amt.add(sendingFee(receiver, amt)));
    }


}
