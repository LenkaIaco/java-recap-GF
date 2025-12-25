import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class PersonalFinance {
    public static void main(String[] args) {
        /**
         * Create a list with the following items:
         * 500, 1000, 1250, 175, 800 and 120
         * Create an application which prints out the answers to the following questions:
         * How much did we spend?
         * Which was our greatest expense?
         * Which was our cheapest spending?
         * What was the average amount of our spendings? (print this as a float value)
         */
        List<Integer> l = new ArrayList<>(List.of(500, 100));

        printExpenses(l);
    }

    public static void printExpenses(List<Integer> expenses) {
        int totalSpent = 0;
        for (Integer integ : expenses) {
            totalSpent = totalSpent + integ;
        }
        System.out.println(totalSpent);

        int greatestExpense = Collections.max(expenses);
        int cheapestSpending = Collections.min(expenses);
        System.out.println(greatestExpense);
        System.out.println(cheapestSpending);

        float averag = 0.0f;
        averag = (float) totalSpent / expenses.size();
        System.out.println(averag);
    }
}
