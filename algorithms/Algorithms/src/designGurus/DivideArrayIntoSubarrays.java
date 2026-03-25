package designGurus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivideArrayIntoSubarrays {
    /*
You are given an array nums containing n integers and a positive integer k.
Divide the nums into arrays of size 3 such that it satisfies the below conditions:
Each element of nums should be in exactly one array.
The difference between any two elements of a single array should be less than or equal to k.
Return a 2D array of these subarrays. If no such division is possible, return an empty array.
Examples:
    Input: nums = [10, 12, 15, 20, 25, 30], k = 10
    Output: [[10, 12, 15], [20, 25, 30]]
    Input: nums = [1, 2, 4, 5, 9, 10], k = 1
     Output: []

Constraints:
    n == nums.length
    1 <= n <= 105
    n is a multiple of 3.
     */
/*
Time complexity O(nlogn) sorting + O(n) iteration ----> worse wins: O(nlogn)
Space complexity O(n/3*3)  ---->constants removed: O(n)
 */
    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 9, 3, 7, 3, 4, 1};
        int[][] result = arrayIntoSubArrays(nums, 3);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    public static int[][] arrayIntoSubArrays(int[]arr, int k){
        if (arr==null){return null;}
        if(arr.length==0){return new int[0][0];}
        int[][] subs = new int[arr.length/3][3];
        Arrays.sort(arr);
        int counter = 0;

        for (int i=0;i<arr.length-2;i++){
            if(arr[i+1]-arr[i]<=k &&
               arr[i+2]-arr[i+1]<=k &&
               arr[i+2]-arr[i]<=k
            ){
              subs[counter]=new int[]{arr[i], arr[i+1], arr[i+2]};
              counter++;
              i+=2;
            }else{
                return new int[0][0];
            }
        }

        return subs;
    }
}
