package leetcodeTop150.EHashmap;

import java.util.HashSet;
import java.util.Set;

public class ILongestConsecutiveSequence {
    /*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
Input: nums = [1,0,1,2]
Output: 3

Constraints:
0 <= nums.length <= 105
-109 <= nums[i] <= 109
     */
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        int[] nums1 = {0,3,7,2,5,8,4,6,0,1};
        int[] nums2 = {1,0,1,2};

        System.out.println(longestConsecutive(nums));//4
        System.out.println(longestConsecutive(nums1));//9
        System.out.println(longestConsecutive(nums2));//3
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> uniques = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            uniques.add(nums[i]);
        }

        int count = 0;

        for (Integer n : uniques) {
            if (!uniques.contains(n - 1)) {
                int interimCount = 0;
                while (uniques.contains(n)) {
                    interimCount++;
                    n++;
                }
                count = Math.max(interimCount, count);
            }
        }
        return count;
    }
}
