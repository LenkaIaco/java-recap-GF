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
//        char[] digitArray = String.valueOf(n).toCharArray();
//        int[] integerArray = new int[digitArray.length];
//
//        for (int i = 0; i <digitArray.length ; i++) {
//            integerArray[i] = Integer.valueOf(String.valueOf(digitArray[i]));
//        }
//        System.out.println(Arrays.toString(integerArray));

        if (n <= 0) {
            return 0;
        } else {
            return n % 10 + sumTheseDigits((int) n / 10);
        }

    }

}
