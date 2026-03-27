package designGurus;

public class MinimumCommonValue {
    /*
     Given two sorted arrays nums1 and nums2 containing integers only, return the smallest integer that
        appears in both arrays. If there isn't any integer that exists in both arrays,
        the function should return -1.
        Example:
            input: nums1 = [1, 3, 5, 7], nums2 = [3, 4, 5, 6, 8, 10]
            Expected Output: 3
            input: nums1 = [2, 4, 6], nums2 = [1, 3, 5]
            Expected Output: -1
        Constraints:
            1 <= nums1.length, nums2.length <= 10^5
            1 <= nums1[i], nums2[j] <= 10^9
            Both nums1 and nums2 are sorted in non-decreasing order.
         */

    /*
    Time complexity O(m*n) worst case (no common until last in both arr and previous vals overlap in both arr-s)
    Space complexity O(1)
     */
    public static void main(String[] args) {
        int[] shorterArr = {21, 22, 23, 24, 25};
        int[] longerArr = {15, 20, 25, 30, 35};

        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {3, 4, 5, 6, 8, 10};

        int[] arr3 = {2, 4, 6};
        int[] arr4 = {1, 3, 5};

        System.out.println(findMinimumCommonValue(shorterArr, longerArr)); //expected outcome 25
        System.out.println(findMinimumCommonValue(arr1, arr2)); //expected outcome 3
        System.out.println(findMinimumCommonValue(arr3, arr4)); //expected outcome -1
    }


    public static int findMinimumCommonValue(int[] nums1, int[] nums2) {
        for (int i=0;i<nums1.length;i++){
            for (int y=0;y<nums2.length;y++){
                if (nums1[y]>nums2[i]){
                    break;
                } else if (nums1[i]==nums2[y]){
                    return nums1[i];
                }
            }
        }
        return -1;
    }
}
