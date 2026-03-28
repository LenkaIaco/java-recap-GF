package designGurus;

import java.util.*;

public class ReductionOperationsEqualize {
    /*
    Given an array of integers nums, return the number of operations required to make all elements in nums equal.
    To perform one operation, you can follow the below steps:
        - Select the maximum element of nums. If there are multiple occurrences of the maximum element, choose
        the element which has lowest index i.
        - Select the second largest element of nums.
        - Replace the element at index i with the second largest element.
     Example:
        Input: [3, 5, 5, 2]
        Expected output: 5
        Justification: 1. 3,3,5,2  2. 3,3,3,2   3. 2,3,3,2   4. 2,2,3,2   5. 2,2,2,2
    Constraints:
        1 <= nums.length <= 5 * 104
        1 <= nums[i] <= 5 * 104
     */

    /*
    Time complexity O(nlogn) - sorting original arr
    Space complexity O(1)
     */
    public static void main(String[] args) {
        int[] arr = {3,5,5,2};
        System.out.println(countReplacements(arr));//exp.out.: 5
    }
    public static int countReplacements(int[] arr){
        if(arr.length==1){return 0;}

        int counter = 0;
        Arrays.sort(arr);
        for (int i=0;i<arr.length-1;i++){
            boolean flag = false;
            if (i!=0){
                if (arr[i-1]==arr[i]){
                    flag=true;
                }
            }
            if(arr[i]<arr[i+1]){
                if (!flag) {
                    int lastIndex = arr.length - 1;
                    counter+=lastIndex-i;
                }
            }
        }
        return counter;
    }
}
