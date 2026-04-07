package leetcodeTop150.ArrayString;

import java.util.*;

public class EMajorityElement {
    /*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.

 Could you solve the problem in linear time and in O(1) space?

    Examples:
Input: nums = [3,2,3]
Output: 3
Input: nums = [2,2,1,1,1,2,2]
Output: 2


    Constraints:
n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
The input is generated such that a majority element will exist in the array.
     */

    /*
    Time Complexity
    majorityElement1 O(n)
    majorityElement2 O(n)

    Space Complexity
    majorityElement1 O(n)
    majorityElement2 O(1)
     */

    public static void main(String[] args) {
        int[]nums = {3,2,3};
        int[]nums1 = {2,2,1,1,1,2,2};
        int[]nums2 = {2,3,1,4,1,1,1};
        int[]nums3 = {1,109,1,50,1,79,1};

        System.out.println(majorityElement1(nums)); //3
        System.out.println(majorityElement1(nums1));//2
        System.out.println(majorityElement1(nums2));//1
        System.out.println(majorityElement1(nums3));//1

        System.out.println(majorityElement2(nums));//3
        System.out.println(majorityElement2(nums1));//2
        System.out.println(majorityElement2(nums2));//1
        System.out.println(majorityElement2(nums3));//1
    }

    public static int majorityElement1(int[] nums) {
        if (nums.length==1){return nums[0];}
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = counts.get(nums[i]);
            if (count == null) {
                counts.put(nums[i], 1);
            } else {
                counts.put(nums[i], count + 1);
            }
        }

        for (Map.Entry<Integer, Integer> e: counts.entrySet()){
            if (e.getValue()>nums.length/2){
                return e.getKey();
            }
        }

        return nums[0];
    }

    public static int majorityElement2(int[] nums) {
        int num = 0;
        int count =0;

        for (int i=0;i<nums.length;i++){
            if (count==0){
                num = nums[i];
            }
            count+= (num==nums[i]) ? 1 : -1;
        }
        return num;
    }

}

