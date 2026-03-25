package designGurus;

import java.util.*;

public class CountingElements {
 /*
Given a list of integers, determine the count of numbers for which there exists another number in the list that is
greater by exactly one unit.
In other words, for each number x in the list, if x + 1 also exists in the list, then x is considered for the count.
Example:
    Input: [4, 3, 1, 5, 6]
    Expected Output: 3
    Justification: The numbers 4, 3, and 5 have 5, 4, and 6 respectively in the list,
    which are greater by exactly one unit.
Constraints:
    1 <= arr.length <= 1000
    0 <= arr[i] <= 1000
 */
    /*
    Time complexity: O(n) where n = arr length
    Space complexity O(n) HashSet creation: worst case O(n) if all arr elements are unique
     */
 public static void main(String[] args) {
int[] arr = {1,1,2,3};
int[] arr2 = {1,1,1,1};
     System.out.println(countGreaterByOne(arr)); //exp.: 2
     System.out.println(countGreaterByOne(arr2)); // exp.: 0
 }
    public static int countGreaterByOne (int[] arr){
     if (arr.length==1){return 0;}
     int counter = 0;
        Set<Integer> uniqs = new HashSet<>();

        for (int i=0;i<arr.length;i++){
            uniqs.add(arr[i]);
        }

        for (Integer i : uniqs){
            if (uniqs.contains(i+1)){
                counter++;
            }
        }
        return counter;
//     ----------
//        if (arr.length==1){return 0;}
//        int counter = 0;
//        Arrays.sort(arr);
//        for (int i=0;i<arr.length-1;i++){
//            if (arr[i]==arr[i+1]+1){counter++;}
//        }
//        return counter;
    }
}
