package leetcodeTop150.AArrayString;

import java.util.Arrays;

public class AMergeSortedArray {
    /*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
 and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]

Constraints:
    nums1.length == m + n
    nums2.length == n
    0 <= m, n <= 200
    1 <= m + n <= 200
    -109 <= nums1[i], nums2[j] <= 109
     */

   /*
   Time complexity O(m+n)
   Space complexity  O(1)
    */
    public static void main(String[] args) {
//        Output: [1,2,2,3,5,6]
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

//        Output: 1
        int[] nums11 = {1};
        int[] nums22 = {};
//        Output:  1
        int[] numsA = {};
        int[] numsB = {1};

        int[] numsA1 = {4,5,6,0,0,0};
        int[] numsB1 = {1,2,3};

        int[] numsA2 = {1,4,7,0,0,0};
        int[] numsB2 = {2,3,6};
        System.out.println(Arrays.toString(merge(nums1,3,nums2,3))); //ex.out.:123456
        System.out.println(Arrays.toString(merge(nums11,1,nums22,0)));//ex out: 1
        System.out.println(Arrays.toString(merge(numsA, 0,numsB,1)));//ex out: 1
        System.out.println(Arrays.toString(merge(numsA1, 3,numsB1,3)));//ex out: 1
        System.out.println(Arrays.toString(merge(numsA2, 3,numsB2,3)));//ex out: 1


    }

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length==0){return nums2;}
        if (nums2.length==0){return nums1;}
    int i = m-1;
    int y = n-1;
    int k = nums1.length-1;

    while(i>=0&&y>=0){
        if(nums1[i]>nums2[y]){
            nums1[k] = nums1[i];
            k--;
            i--;
        } else{
            nums1[k]=nums2[y];
            k--;
            y--;
        }
    }

        while (i>=0){
            nums1[k]=nums1[i];
            k--;
            i--;
        }

    while (y>=0){
        nums1[k]=nums2[y];
        k--;
        y--;
    }
    return nums1;
    }
}
