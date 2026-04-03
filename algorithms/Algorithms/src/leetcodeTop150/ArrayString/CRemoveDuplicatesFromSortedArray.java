package leetcodeTop150.ArrayString;

public class CRemoveDuplicatesFromSortedArray {
    /*
    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that
    each unique element appears only once. The relative order of the elements should be kept the same.

The number of unique elements in nums = k. After removing duplicates, return the number of unique elements k.

The first k elements of nums should contain the unique numbers in sorted order.
The remaining elements beyond index k - 1 can be ignored.

Examples:
    Input: nums = [1,1,2]
    Output: 2, nums = [1,2,_]
    It does not matter what you leave beyond the returned k (hence they are underscores).

    Input: nums = [0,0,1,1,1,2,2,3,3,4]
    Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]

Constraints:
    1 <= nums.length <= 3 * 104
    -100 <= nums[i] <= 100
    nums is sorted in non-decreasing order.
     */
    /*
    Time complexity O(n)
    Space complexity O(1)
     */
    public static void main(String[] args) {
        int[] nums =  {1,1,2};
        int[] nums1 ={0,0,1,1,1,2,2,3,3,4};

        System.out.println(removeDuplicates(nums)); //exp.out 2
        System.out.println(removeDuplicates(nums1)); //exp.out 5
    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length==1){return 1;}
        int lastI =0;
        int i =1;
        while (i< nums.length){
            if (nums[lastI]==nums[i]){
                i++;
            }else{
                if(lastI<i-1){
                    nums[lastI+1]=nums[i];
                    i++;
                }
                lastI++;
            }
        }
        return lastI+1;
    }
}
