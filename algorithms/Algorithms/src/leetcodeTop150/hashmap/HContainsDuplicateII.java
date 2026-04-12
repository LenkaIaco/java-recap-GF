package leetcodeTop150.hashmap;

import java.util.*;

public class HContainsDuplicateII {
    /*
Given an integer array nums and an integer k,
return true if there are two distinct indices i and j in the array such that
nums[i] == nums[j] and abs(i - j) <= k.

Input: nums = [1,2,3,1], k = 3
Output: true

Input: nums = [1,0,1,1], k = 1
Output: true

Input: nums = [1,2,3,1,2,3], k = 2
Output: false


Constraints:
1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105
     */

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int[] nums1 = {1,0,1,1};
        int[] nums2 = {1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate2(nums,3));//true
        System.out.println(containsNearbyDuplicate2(nums1,1));//true
        System.out.println(containsNearbyDuplicate2(nums2,2));//false
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> indicesMap = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            List<Integer> indices = indicesMap.get(nums[i]);
            if (indices ==null){
                indices = new ArrayList<>(Arrays.asList(i));
                indicesMap.put(nums[i],indices);
            }else{
                indices.add(i);
                indicesMap.put(nums[i],indices);
            }
        }

        for (Map.Entry<Integer, List<Integer>> e: indicesMap.entrySet()){
            List<Integer> indices = e.getValue();
            if (indices.size()>1){
                for (int i=0;i<indices.size()-1;i++){
                    if (Math.abs(indices.get(i)-indices.get(i+1))<=k){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> indicesMap = new HashMap<>();

        for (int i=0;i<nums.length;i++){
            Integer lastI = indicesMap.get(nums[i]);
            if (lastI==null){
                indicesMap.put(nums[i],i);
            } else{
                if (Math.abs(lastI-i)<=k){
                    return true;
                }else{
                    indicesMap.put(nums[i],i);
                }
            }
        }
        return false;
    }
}
