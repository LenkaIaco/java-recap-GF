package leetcodeTop150.arrayString;

import java.util.Arrays;

public class LProductOfArrayExceptSelf {
    /*
Given an integer array nums, return an array answer such that answer[i] is equal to
the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Examples:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Constraints:
2 <= nums.length <= 105
-30 <= nums[i] <= 30
The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
     */

    /*
    Time complexity O(n)
    Space complexity O(n)
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] nums1 = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf(nums))); //24,12,8,6
        System.out.println(Arrays.toString(productExceptSelf(nums1))); //0,0,9,0,0

    }

    public static int[] productExceptSelf(int[] nums) {

        int[] leftProducts = new int[nums.length];
        int[] rightProducts = new int[nums.length];

        // populating left
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                leftProducts[i] = nums[i];
            } else {
                leftProducts[i] = nums[i] * leftProducts[i - 1];
            }
        }

        //populating right
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                rightProducts[i] = nums[i];
            } else {
                rightProducts[i] = nums[i] * rightProducts[i + 1];
            }
        }

        int[] results = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                results[i] = rightProducts[i + 1];
            } else if (i == nums.length - 1) {
                results[i] = leftProducts[i - 1];
            } else {
                results[i] = leftProducts[i - 1] * rightProducts[i + 1];
            }
        }
        return results;
    }
}
