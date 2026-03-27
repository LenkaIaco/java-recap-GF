package designGurus;

import java.util.ArrayList;
import java.util.List;

public class MaxOfSubarrays {
    /*
    Given an integer array arr and an integer k, return the result list containing the maximum for each and every
        contiguous subarray of size k.
        In other words, result[i] = max(arr[0],..., arr[k]), result[1] = max(arr[1],...arr[k+1]), etc.

        Input: arr = [1, 2, 3, 1, 4, 5, 2, 3, 6], k = 3
        Output: [3, 3, 4, 5, 5, 5, 6]
        Description: Here, subarray [1,2,3] has maximum 3, [2,3,1] has maximum 3, [3,1,4] has maximum 4,
        [1,4,5] has maximum 5, [4,5,2] has maximum 5, [5,2,3] has maximum 5, and [2,3,6] has maximum 6.

        1 <= arr.length <= 105
        -104 <= arr[i] <= 104
        1 <= k <= arr.length
         */


        public static void main(String[] args) {
            int[] arr1 = {1, 2, 3, 1, 4, 5, 2, 3, 6};
           int[] arr2 = {1, 2, 3, 1, 4};
           System.out.println(printMax(arr2,3)); //exp.out.: 3,3,4
            System.out.println(printMax(arr1,3)); //exp.out.: 3, 3, 4, 5, 5, 5, 6
        }

    public static List<Integer> printMax(int[] arr, int k){
        List<Integer> maxims = new ArrayList<>();

        for (int i=0;i<arr.length-k+1;i++){
            int max = arr[i];
            for (int y=i;y<i+k;y++){
                if (arr[y]>max){
                    max = arr[y];
                }
            }
            maxims.add(max);
        }

        return maxims;
    }
}
