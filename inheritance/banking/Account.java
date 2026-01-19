package banking;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.time.Period;
import java.time.LocalDate;

public abstract class Account {
    protected String name;
    protected Type type;
    protected Customer owner;
    BigDecimal balance;
    protected List<String> history;
    protected List<Customer> partners;
    protected LocalDate lastUsage;

    public Account(String name, Customer owner, BigDecimal balance){
        this.name = name;
        this.owner = owner;
        this.balance = balance;
        history = new ArrayList<>();
        partners = new ArrayList<>();
        lastUsage = LocalDate.now().minus(Period.ofDays(1)); //for testing purposes
    }

    public abstract BigDecimal sendingFee(Customer receiver, BigDecimal amt);
    public abstract BigDecimal receivingFee(Customer sender, BigDecimal amt);

    public String getName() {
        return name;
    }

    public Type getType(){
        return type;
    }

    public Customer getOwner(){
        return owner;
    }

    public BigDecimal getBalance(){
        return balance;
    }

    public List<String> getHistory(){
        return new ArrayList<>(history);
    }

    public List<Customer> getPartners(){
        return new ArrayList<>(partners);
    }

    public LocalDate getLastUsage(){
        return lastUsage;
    }

    protected void setType(Type type){
       this.type = type;
    }
    public void increaseBalance(Customer sender, BigDecimal amt){
        balance = balance.add(amt);
    }

    public void decreaseBalance(Customer receiver,BigDecimal amt){
        balance = balance.subtract(amt);
    }

    public void addHistory(String record){
        history.add(record);
    }

    public void addPartner (Customer partner){
        if (!partners.contains(partner)) {
            partners.add(partner);
        }
    }

    public void setLastUsage(LocalDate usage){
        lastUsage = usage;
    }


    public int daysSinceLastUsage(){
        Period period = Period.between(lastUsage, LocalDate.now());
        return period.getDays();
    }

    @Override
    public String toString(){

        String s = name.concat(" account: \n").concat("Account type: \"").concat(getType().toString()).concat("\"\n")
                .concat("The number of transaction partners: ").concat(String.valueOf(partners.size())).concat("\n")
                .concat("Last account usage happened ").concat(String.valueOf(daysSinceLastUsage())).concat(" days ago\n")
                .concat("The actual balance is: ").concat(String.valueOf(balance)).concat(" Eur")
                ;

        return s;
    }


}
