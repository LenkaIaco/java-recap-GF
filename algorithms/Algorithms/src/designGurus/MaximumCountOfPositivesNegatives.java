package designGurus;

public class MaximumCountOfPositivesNegatives {
    /*
    Given an array nums sorted in increasing order, return the maximum between the count of positive
        integers and the count of negative integers.
        Note: 0 is neither positive nor negative.
            Input: nums = [-4, -3, -1, 0, 1, 3, 5, 7]
            Output: 4
            Input: nums = [-8, -7, -5, -4, 0, 0, 0]
            Output: 4
        Constraints:
            1 <= nums.length <= 2000
            -2000 <= nums[i] <= 2000
            nums is sorted in a non-decreasing order.
     */

    /*
    Time complexity O(n)
    Space complexity O(1)
     */

    public static void main(String[] args) {
        int[] arr1 = {-4, -3, -1, 0, 1, 3, 5, 7};
        int[] arr2 = {-8, -7, -5, -4, 0, 0, 0};
        int[] arr3 = {0, 2, 2, 3, 3, 3, 4};
        System.out.println(maxCountPosNeg(arr1)); //exp. out: 4
        System.out.println(maxCountPosNeg(arr2)); //exp. out: 4
        System.out.println(maxCountPosNeg(arr3)); //exp. out: 6
    }

    public static int maxCountPosNeg(int[] arr){
        int countNeg = 0;
        int countPos = 0;

        for (int i=0;i<arr.length;i++){
            if(arr[i]<0){countNeg++;}
            else if (arr[i]>0){countPos++;}
        }

        return Math.max(countNeg,countPos);
    }
}
