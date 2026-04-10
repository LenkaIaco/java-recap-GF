package leetcodeTop150.twoPointers;
import java.util.*;

public class E3Sum {
    /*
    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
    such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.


Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.


Constraints:
3 <= nums.length <= 3000
-105 <= nums[i] <= 105
     */

    public static void main(String[] args) {
        int[] nums = {0,1,1};
        int[] nums1 = {0,0,0};
        int [] nums2 = {-1,0,1,2,-1,-4};
        int [] nums3 = {0,0,0,0};
        int [] nums4 = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};

        List<List<Integer>> result = threeSum(nums);
        List<List<Integer>> result1 = threeSum(nums1);
        List<List<Integer>> result2 = threeSum(nums2);

        System.out.println(result); // []
        System.out.println(result1); // [[0,0,0]]
        System.out.println(result2); //[[-1,-1,2],[-1,0,1]]
        System.out.println(threeSum(nums3)); //[[-1,-1,2],[-1,0,1]]
        System.out.println(threeSum(nums4)); //[[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]]

    }

    public static List<List<Integer>> threeSum(int[] nums) {
Arrays.sort(nums);
Set<List<Integer>> results = new HashSet<>();
for (int i=0;i<nums.length-2;i++){
    if (nums[i]+nums[i+1]+nums[i+2]>0){return results.stream().toList();}
    int left = i+1;
    int right = nums.length-1;
    while (left<right){
            if (nums[left]+nums[right]+nums[i]==0){
                results.add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));
                left++;
            } else if (nums[left]+nums[right]+nums[i]>0){right--;}
            else{left++;}

    }
}

return results.stream().toList();
    }
}
