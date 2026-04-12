package leetcodeTop150.hashmap;

import java.util.*;

public class FTwoSum {
    /*
Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
     */

    public static void main(String[] args) {
        int[] arr = {1,2,4};
        int[] arr1 = {3,2,4};
        int[] arr2 = {3,3};
//        System.out.println(Arrays.toString(twoSum(arr,3)));//0,1
//        System.out.println(Arrays.toString(twoSum2(arr,3)));//0,1
        System.out.println(Arrays.toString(twoSum2(arr1,6)));//1,2
        System.out.println(Arrays.toString(twoSum2(arr2,6)));//0,1
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        if (nums.length <= 1) {
            return new int[]{-1, -1};
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int y = i + 1; y < nums.length; y++) {
                if (nums[i]+nums[y]==target){return new int[]{i,y};}
            }
        }

        return new int[]{-1,-1};
    }

    public static int[] twoSum2(int[] nums, int target){
        if (nums==null){return null;}
        if (nums.length<=1){return new int[]{-1,-1};}
        Map<Integer, List<Integer>> numIndices = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            List<Integer> indices = numIndices.get(nums[i]);
            if (indices==null){
                numIndices.put(nums[i], new ArrayList<>(Arrays.asList(i)));
            } else{
                indices.add(i);
                numIndices.put(nums[i], indices);
            }
        }

        for (int i=0;i<nums.length;i++){
            if (numIndices.containsKey(target-nums[i])){
                List<Integer> indicesI = numIndices.get(nums[i]);
                if (target-nums[i]==nums[i]){
                    if (indicesI.size()>1){
                        return new int[]{indicesI.get(0),indicesI.get(1)};
                    }
                } else {
                    List<Integer> indicesY = numIndices.get(target - nums[i]);
                    return new int[]{indicesI.get(0), indicesY.get(0)};
                }
            }
        }
        return new int[]{-1,-1};
    }
}
