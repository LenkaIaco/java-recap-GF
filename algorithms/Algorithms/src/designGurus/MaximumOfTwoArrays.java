package designGurus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumOfTwoArrays {
    /*
Given divisor1, divisor2, uniqueCnt1, and uniqueCnt2 integers, find the smallest possible maximum integer that could be present in either array after they are filled according to the below conditions.

You can take two arrays arr1 and arr2 which are initially empty.
arr1 contains total uniqueCnt1 different positive integers, each of them is not divisible by divisor1.
arr2 contains total uniqueCnt2 different positive integers, each of them is not divisible by divisor2.
There are no common integers in both arrays.
Examples
Example 1:

Input: uniqueCnt1 = 2, divisor1 = 2, uniqueCnt2 = 2, divisor2 = 3
Expected Output: 4
Explanation: The optimal arrays could be arr1 = [1, 3] (numbers not divisible by 2) and arr2 = [2, 4] (numbers not divisible by 3). The maximum number among both arrays is 4.
Example 2:

Input: uniqueCnt1 = 3, divisor1 = 3, uniqueCnt2 = 4, divisor2 = 4
Expected Output: 7
Explanation: Possible arrays are arr1 = [1, 2, 4] and arr2 = [3, 5, 6, 7]. The highest integer used is 7.
Example 3:

Input: uniqueCnt1 = 1, divisor1 = 7, uniqueCnt2 = 1, divisor2 = 10
Expected Output: 2
Explanation: We can use arr1 = [1] (since it's not divisible by 7) and arr2 = [2] (since it's not divisible by 10). The highest integer here is 2.
Constraints:

2 <= divisor1, divisor2 <= 105
1 <= uniqueCnt1, uniqueCnt2 < 109
2 <= uniqueCnt1 + uniqueCnt2 <= 109
     */

    /*
    Time complexity O(n*div) for arr1/arr2 length whichever bigger, and divisor while loop(every while loop runs up to div number of times
    Space complexity O(n) hashset size
     */

    public static void main(String[] args) {
        System.out.println( minimizeSet(2,3,2,2));//expected output: 4
        System.out.println(minimizeSet(3,4,3,4));//expected output: 7
        System.out.println(minimizeSet(7,10,1,1));//expected output: 2
        System.out.println(minimizeSet(5,2,5,3));//expected output: 9
    }

    public static int minimizeSet(long divisor1, long divisor2, long uniqueCnt1, long uniqueCnt2) {
        int div1 = (int) divisor1;
        int div2 = (int) divisor2;
        int start = 1;
        int max = 0;

        Set<Integer> arr1 = new HashSet<>();
        for (int i = 0; i < (int)uniqueCnt1; i++) {
            while (start % div1 == 0) {
                start++;
            }
            arr1.add(start);
            if (max < start) {
                max = start;
            }
            start++;
        }

        start = 2;
        for (int i = 0; i < (int) uniqueCnt2; i++) {
            while (start % div2 == 0 || arr1.contains(start)){
                start++;
            }
            if (max < start) {
                max = start;
            }
            start++;
        }

        return max;
    }
}
