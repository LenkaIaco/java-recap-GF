package designGurus;

import java.util.Arrays;

public class RunningSumEx {
    /*
     Given an one-dimensional array of integers,
    create a new array that represents the running sum of the original array:
    The running sum at position i in the new array is calculated as
    the sum of all the numbers in the original array from the 0th index up to the i-th index (inclusive).
    Formally, the resulting array should be computed as follows:
    result[i] = sum(nums[0] + nums[1] + ... + nums[i])

    Constraints:
    1 <= nums.length <= 1000
    -10^6 <= nums[i] <= 10^6
     */
    /*
    Time complexity  O(n*(n+1)/2) -> simplified to O(n^2)
    Space complexity O(n)
     */
    public static void main(String[] args) {
        int[] arr1 ={2, 3, 5, 1, 6};
        int[] arr2 = {1, 1, 1, 1, 1};
        int[] arr3 ={-1, 2, -3, 4, -5};
        System.out.println(Arrays.toString(partialSumsArray(arr1)));//exp.output 2, 5, 10, 11, 17
        System.out.println(Arrays.toString(partialSumsArray(arr2)));//exp.output 1,2,3,4,5
        System.out.println(Arrays.toString(partialSumsArray(arr3)));//exp.output -1, 1, -2, 2, -3
    }
public static int[] partialSumsArray(int[] original){
    int[] result = new int[original.length];

    for (int i=0;i<result.length;i++){
        int element = 0;
        for(int y=0;y<=i;y++){
            element+=original[y];
        }
        result[i]= element;
    }
   return result;
}
}
