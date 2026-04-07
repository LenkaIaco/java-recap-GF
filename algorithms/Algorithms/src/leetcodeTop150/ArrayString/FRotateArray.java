package leetcodeTop150.ArrayString;

import java.util.Arrays;

public class FRotateArray {
    /*
    Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 Follow up:
Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?

    Examples:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]

    Constraints:
1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
     */

    /*
    Time complexity O(n^2)
    Space complexity O(1)
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] nums1 = {-1, -100, 3, 99};
        int[] nums2 = {1,2,3,4};
        int[] nums3 = {1,2,3,4,5,6};
        int[] nums4 = {1,2,3,4,5,6,7,8};
        int[] nums5 = {1, 2, 3};

        System.out.println(Arrays.toString(rotate(nums, 3))); //5,6,7,1,2,3,4
        System.out.println(Arrays.toString(rotate(nums1, 2))); //3,99,-1,-100
        System.out.println(Arrays.toString(rotate(nums2, 2))); //3,4,1,2
        System.out.println(Arrays.toString(rotate(nums3, 4))); //3,4,5,6,1,2
        System.out.println(Arrays.toString(rotate(nums4, 6))); //3,4,5,6,7,8,1,2
        System.out.println(Arrays.toString(rotate(nums5, 7))); //3,1,2

        System.out.println(Arrays.toString(rotate2(nums, 3))); //5,6,7,1,2,3,4
        System.out.println(Arrays.toString(rotate2(nums1, 2))); //3,99,-1,-100
        System.out.println(Arrays.toString(rotate2(nums2, 2))); //3,4,1,2
        System.out.println(Arrays.toString(rotate2(nums3, 4))); //3,4,5,6,1,2
        System.out.println(Arrays.toString(rotate2(nums4, 6))); //3,4,5,6,7,8,1,2
        System.out.println(Arrays.toString(rotate2(nums5, 7))); //3,1,2

    }

    public static int[] rotate(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int start = 0;
        int i = start;
        int temp = 0;
        int iterations = 0;
        while (i == start) {
            int next = i + k;
            while(next > nums.length - 1) {
                next = next - nums.length;
            }
            temp = nums[next];
            nums[next] = nums[i];
            i = next;
            iterations++;
            break;
        }

        if (i == start) {
            return nums;
        }

        while (i != start) {
            int next = i + k;
            while (next > nums.length - 1) {
                next = next - nums.length;
            }
            int temp2 = nums[next];
            nums[next] = temp;
            temp = temp2;
            i = next;
            iterations++;
        }

        if (iterations != nums.length) {
            i++;
            start = i;
            temp = nums[i];
        }
        while (iterations < nums.length) {
            int next = i + k;
            while (next > nums.length - 1) {
                next = next - nums.length;
            }
            int temp2 = nums[next];
            nums[next] = temp;
            temp = temp2;
            i = next;
            iterations++;
        }

        return nums;
    }


    public static int[] rotate2(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) return nums;

        k = k % n; // normalize
        int moved = 0;

        for (int start = 0; moved < n; start++) {
            int current = start;
            int temp = nums[start];

            while (true) {
                int next = current + k;
                while (next >= n) next -= n; // your modulo logic

                int swap = nums[next];
                nums[next] = temp;
                temp = swap;

                current = next;
                moved++;

                if (current == start) break;
            }
        }
        return nums;
    }
}
