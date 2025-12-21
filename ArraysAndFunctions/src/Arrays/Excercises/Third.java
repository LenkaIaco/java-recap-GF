package Arrays.Excercises;

import java.util.Arrays;
import java.util.Scanner;

public class Third {
    public static void main(String[] args) {
        // Create an array variable named `numbers`
        // with the following content: `[4, 5, 6, 7]`
        // Print the third element of `numbers`
        int [] numbers = {4, 5, 6, 7};
//        System.out.println(Arrays.toString(numbers));
//        numbers[0] = 1;
//        numbers[1] = 2;
//        numbers[2] = 3;
//        numbers[3] = 4;
//        System.out.println(Arrays.toString(numbers));
//        for (int i=0; i<numbers.length; i++){
//            numbers[i] = 4+i;
//        }
//        System.out.println(Arrays.toString(numbers));
        System.out.println(numbers[2]);

        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
    }
}
