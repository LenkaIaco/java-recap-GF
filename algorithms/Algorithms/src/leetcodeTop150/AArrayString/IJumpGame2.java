package leetcodeTop150.AArrayString;

public class IJumpGame2 {
    /*
 You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.
Each element nums[i] represents the maximum length of a forward jump from index i.
In other words, if you are at index i, you can jump to any index (i + j) where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach index n - 1.
The test cases are generated such that you can reach index n - 1.

Examples:

Input: nums = [2,3,1,1,4]
Output: 2
Input: nums = [2,3,0,1,4]
Output: 2


Constraints:
1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].
     */

    /*
    Time complexity O(1)
    Space complexity O(1)
     */
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int[] nums1 = {2,3,0,1,4};
        int[] nums2 = {5,0,0,0,0,0};
        int[] nums3 = {1,1,1,1,1};
        int[] nums4 = {2,1,2,1,4};
        int[] nums6 = {4,1,1,3,1,1,1};
        int[] nums7 = {1,2,3};
        int[] nums8 = {1,2,1,1,1};
        int[] nums9 = {5,9,3,2,1,0,2,3,3,1,0,0};
        IJumpGame2 ijg = new IJumpGame2();
        System.out.println(ijg.jump(nums));//exp.out 2
        System.out.println(ijg.jump(nums1));//exp.out 2
        System.out.println(ijg.jump(nums2));//exp.out 1
        System.out.println(ijg.jump(nums3));//exp.out 4
        System.out.println(ijg.jump(nums4));//exp.out 2
        System.out.println(ijg.jump(nums6));//exp.out 2
        System.out.println(ijg.jump(nums7));//exp.out 2
        System.out.println(ijg.jump(nums8));//exp.out 3
        System.out.println(ijg.jump(nums9));//exp.out 3
    }


    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0; // represents the boundary of the current jump
        int farthestI = 0;

        // We stop at n-2 because reaching the last index doesn't require another jump
        for (int i = 0; i < nums.length - 1; i++) {
            farthestI = Math.max(farthestI, i + nums[i]);

            // When we reach the end of the current jump range,
            // we must make another jump
            if (i == currentEnd) { //at the end of the boundary of current jump, reassign to next max jump
                jumps++;
                currentEnd = farthestI;
            }
        }

        return jumps;
    }
}
