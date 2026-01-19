package banking;

import java.math.BigDecimal;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        Customer economy = new Customer("Domestic Market",108, Gender.OTHER);
        Customer enterprise = new Customer("Enterprise", 55, Gender.MALE);
        Customer employee = new Customer("Employee", 35, Gender.FEMALE);

        Account speedUpEconomy = new SpeedUpAccount("Nation", economy,new BigDecimal(138000000000.00));
        Account speedUpEnterprise = new SpeedUpAccount("Revenue", enterprise, new BigDecimal(10000000.00));
        Account balanceEmployee = new BalanceAccount("Private",employee, new BigDecimal(3000.12));
        Account savingsEmployee = new SavingsAccount("Investments", employee, new BigDecimal(40000));

        economy.createAccount(speedUpEconomy);
        enterprise.createAccount(speedUpEnterprise);
        employee.createAccount(balanceEmployee);
        employee.createAccount(savingsEmployee);


        economy.generateStatus();
        enterprise.generateStatus();
        employee.generateStatus();

        economy.sendMoney("Nation", enterprise,"Revenue", new BigDecimal(5000.99));
        enterprise.sendMoney("Revenue",employee, "Private", new BigDecimal(1500.45));
        employee.sendMoney("Private", employee, "Investments", new BigDecimal(400.00));

        System.out.println("-----------------------------------------------------------------------------------------------");
        economy.generateStatus();
        enterprise.generateStatus();
        employee.generateStatus();

    }
}
