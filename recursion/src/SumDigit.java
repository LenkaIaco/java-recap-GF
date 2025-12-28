import java.io.CharArrayReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.stream.IntStream;

public class SumDigit {
    public static void main(String[] args) {
/** Task:
// Given a non-negative integer n, return the sum of its digits recursively
// (without loops).
//
// Hint
//
// Mod (%) by 10 yields the rightmost digit (e.g. 126 % 10 is 6)
//
// Divide (/) by 10 removes the rightmost digit (e.g. 126 / 10 is 12)
         */
        System.out.println(sumTheseDigits(666));
    }

    public static int sumTheseDigits(int n) {
        if (n <= 0) {
            return 0;
        } else {
            return n % 10 + sumTheseDigits((int) n / 10);
        }
    }

    /*alternatively:

    public static int sumTheseDigits(int number){
        if (number <=0){return 0;}
        char[] digits = String.valueOf(number).toCharArray();
        if (digits.length==1) {return Integer.valueOf(String.valueOf(digits[0]));}

        char[] subDigits = Arrays.copyOfRange(digits,1,digits.length);
        String remainingNumber = String.valueOf(subDigits);

        Integer first = Integer.valueOf(String.valueOf(digits[0]));
    return first + sumDigits(Integer.valueOf(remainingNumber));
}
     */

}
