package leetcodeTop150.SlidingWindow;
import java.util.*;

public class AMinimumSizeSubarraySum {
    /*
Given an array of positive integers nums and a positive integer target, return
the minimal length of a subarray whose sum is greater than or equal to target.
If there is no such subarray, return 0 instead.

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Input: target = 4, nums = [1,4,4]
Output: 1

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0


Constraints:
1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104

Follow up: If you have figured out the O(n) solution, find solution with time complexity is O(n log(n)).
     */

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int[] nums1 = {1,4,4};
        int[] nums2 = {1,1,1,1,1,1,1,1};
        int[] nums3 = {12,28,83,4,25,26,25,2,25,25,25,12};
        System.out.println(minSubArrayLen(7, nums)); //2
        System.out.println(minSubArrayLen(4, nums1)); //1
        System.out.println(minSubArrayLen(11, nums2)); //0
        System.out.println(minSubArrayLen(213, nums3)); //8

    }

    public static int minSubArrayLen(int target, int[] nums) {

        int sum = 0;
        int countHits = 0;
        int minDist = nums.length;
        for (int i=0;i<nums.length;i++){
            sum = 0;
            for (int y=i;y<nums.length;y++){
                sum+=nums[y];
                if (sum>=target){
                    countHits++;
                    int length = y+1-i;
                    if (length<minDist){
                        minDist = length;
                    }
                    break;
                }
            }
        }

        return countHits>0 ? minDist : 0;
    }



}
