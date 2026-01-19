package banking;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Customer {
    String name;
    int age;
    Gender gender;
    List<Account> bankAccounts;

    Customer(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        bankAccounts = new ArrayList<>();
    }

    public void createAccount(Account account) {
        boolean exists = false;
        for (Account a : bankAccounts) {
            if (a.getName().equals(account.getName())) {
                exists = true;
            }
        }
        if (!exists) {
            bankAccounts.add(account);
        } else {
            System.out.println("No account name duplication is allowed");
        }
    }

    public void sendMoney(String senderAccountName, Customer receiver, String receiverAccountName, BigDecimal amt)
            throws InvalidParameterException {
        Account senderAcc = null;

        for (Account a : bankAccounts) {
            if (a.getName().equals(senderAccountName)) {
                senderAcc = a;
                break;
            }
        }
        if (senderAcc == null) {
            throw new InvalidParameterException("There is no sender account under the name ".concat(senderAccountName));
        }
        String dateToString = String.valueOf(senderAcc.lastUsage.getYear()).concat(".").concat(
                String.valueOf(senderAcc.lastUsage.getMonth()).concat(".").concat(
                        String.valueOf(senderAcc.lastUsage.getDayOfMonth())
                ));

        senderAcc.decreaseBalance(receiver, amt);
        senderAcc.setLastUsage(LocalDate.now());
        senderAcc.addHistory(String.valueOf(amt).concat(" Ft sent to ").concat(receiverAccountName).concat("from the account ")
                .concat(senderAccountName).concat(" at ").concat(dateToString));
        if (!senderAcc.getPartners().contains(receiver)) {
            senderAcc.addPartner(receiver);
        }

        receiver.receiveMoney(receiverAccountName, this, amt);
    }


    public List<Account> getBankAccounts() {
        return new ArrayList<>(bankAccounts);
    }

    public String getName() {
        return name;
    }

    public void receiveMoney(String receiverAccountName, Customer sender, BigDecimal amt) {

        Account receiverAcc = null;
        for (Account a : this.getBankAccounts()) {
            if (a.getName().equals(receiverAccountName)) {
                receiverAcc = a;
            }
        }
        if (receiverAcc == null) {
            throw new InvalidParameterException("There is no receiver account under the name ".concat(receiverAccountName));
        }
        receiverAcc.increaseBalance(sender, amt);

        LocalDate now = LocalDate.now();
        String dateToString = String.valueOf(now.getYear()).concat(".").concat(String.valueOf(now.getMonth()))
                .concat(".").concat(String.valueOf(now.getDayOfMonth()));
        receiverAcc.setLastUsage(now);

        receiverAcc.addHistory(String.valueOf(amt).concat(" Ft received from ").concat(sender.getName()).concat(" to the account ")
                .concat(receiverAccountName).concat(" at ").concat(dateToString));

        if (!receiverAcc.getPartners().contains(sender)) {
            receiverAcc.addPartner(sender);
        }
    }

    public void generateStatus() {
        System.out.println("This customer has the following accounts:\n");
        for (Account a : this.getBankAccounts()) {
            System.out.println(a.toString());
            System.out.println();
        }
    }


}