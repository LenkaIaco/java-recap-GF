package leetcodeTop150.AArrayString;

public class BRemoveElement {
    /*
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k,
to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
The remaining elements of nums are not important as well as the size of nums.

Return k.


    Examples:
Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]

    Constraints:
0 <= nums.length <= 100
0 <= nums[i] <= 50
0 <= val <= 100
     */

    /*
    Time complexity O(n)
    Space complexity O(1)
     */

    public static void main(String[] args) {
        int[] nums = {3,2,2,3}; // val = 2
        int[] nums1 = {3,3,2,3}; // val = 3
        int[] nums1A = {3,2,2,3}; // val = 2
        int[] nums2 = {0,1,2,2,3,0,4,2}; //val = 2
        System.out.println(removeElement(nums,3)); //exp. out.: 2
        System.out.println(removeElement(nums1,3)); //exp. out.: 1
        System.out.println(removeElement(nums1A,2)); //exp. out.: 2
        System.out.println(removeElement(nums2,2)); //exp. out.: 5

    }

    public static int removeElement(int[] nums, int val) {
    int lastInd = nums.length-1;
    int firstInd = 0;

    while(firstInd<lastInd){
        if (nums[lastInd]==val){
            lastInd--;
        }else{
            if (nums[firstInd]==val){
                nums[firstInd]=nums[lastInd];
                lastInd--;
                firstInd++;
            } else{
                firstInd++;
            }
        }
    }
    if (nums[lastInd]==val){lastInd--;}
    return lastInd+1;
    }
}
