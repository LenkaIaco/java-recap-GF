package leetcodeTop150.arrayString;

public class DRemoveDuplicatesFromSortedArray2 {
    /*
Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that
each unique element appears at most twice. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result
be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates,
then the first k elements of nums should hold the final result.
It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

    Examples:
Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]
It does not matter what you leave beyond the returned k (hence they are underscores).
Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]

    Constraints:
1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
     */
    /*
    time complexity O(n)
    space complexity O(1)
     */
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int[] nums1 = {0,0,1,1,1,1,2,3,3};
        int[] nums2 = {1,1,1,1};
        int[] nums3 = {1,1,1,2};
        System.out.println(removeDuplicates(nums));//exp.out.:5
        System.out.println(removeDuplicates(nums1));//exp.out.:7
        System.out.println(removeDuplicates(nums2));//exp.out.:2
        System.out.println(removeDuplicates(nums3));//exp.out.:3
    }

    public static int removeDuplicates(int[] nums) {
    int dupes = 0;
    int lastI = 0;
    for (int i=0;i<nums.length;i++){
        if(nums[i]==nums[lastI]){
            if (dupes==0) {
                dupes++;
                lastI++;
            } else{
                dupes++;
            }
        } else{
            if (lastI<i-1){
                nums[lastI+1] = nums[i];
            }
            lastI++;
            dupes = 0;
        }
    }
    return lastI+1;
    }
}
