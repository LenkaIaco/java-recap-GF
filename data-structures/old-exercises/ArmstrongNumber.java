import java.util.Arrays;

public class ArmstrongNumber {

    /**
     *An Armstrong number is an n-digit number which is equal to the sum of the nth powers of its digits.
     *
     * Let's demonstrate this for a 4-digit number: 1634 is a 4-digit number, raise each digit to the fourth power and add: 1^4 + 6^4 + 3^4 + 4^4 = 1634, so it is an Armstrong number.
     * For a 3-digit number: 153 is a 3-digit number, raise each digit to the third power and add: 1^3 + 5^3 + 3^3 = 153, so it is an Armstrong number.
     * Exercise
     * Write a function isArmstrongNumber (Java, JavaScript, TypeScript, c++) / IsArmstrongNumber (C#) / is_armstrong_number (python) to check if a given number is an Armstrong number. Your program should ask for a number and print a message saying whether or not the entered number is an Armstrong number.
     *
     * Input / Output
     * Please enter a number to check:
     * > 9926315
     * 9926315 is an Armstrong number
     * Please enter a number to check:
     * > 131072
     * 131072 is not an Armstrong number
     */
    public static void main(String[] args) {

        isArmstrongNumber(153);
    }

    public static void isArmstrongNumber(int number) {
        char[] array = Integer.toString(number).toCharArray();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            int element = (int) Integer.valueOf(Character.toString(array[i]));
            int variable = element;
            for (int j = 2; j <= array.length; j++) {
                variable = variable * element;
            }
            sum = sum + variable;
        }
        String result = sum == number ? new String(number + " is an Armstrong number") : new String(number + " is not an Armstrong number");
        System.out.println(result);
    }
}
