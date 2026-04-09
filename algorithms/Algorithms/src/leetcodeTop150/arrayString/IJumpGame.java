package leetcodeTop150.arrayString;

public class IJumpGame {
    /*
You are given an integer array nums. You are initially positioned at the array's first index,
and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

Constraints:
1 <= nums.length <= 104
0 <= nums[i] <= 105
     */

    /*
    Time complexity O(n)
    Space complexity O(1)
     */
    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        int[] arr1 = {3,2,1,0,4};
        int[] arr2 = {10,0,0,0,0};
        int[] arr3 = {4,0,0,0,2,0};
        int[] arr4 = {5,4,3,2,1,0,0};
        System.out.println(jumpEnd(arr));//true
        System.out.println(jumpEnd(arr1));//false
        System.out.println(jumpEnd(arr2));//true
        System.out.println(jumpEnd(arr3));//true
        System.out.println(jumpEnd(arr4));//false
    }
    public static boolean jumpEnd(int[] arr){
        if (arr.length==1) {
            return true;
        }
        int remainingIndices = arr.length-1;
        int jumpStartI = 0;
        int potential = arr[jumpStartI];

        while (jumpStartI< arr.length){
             if (potential==0){
                if (remainingIndices>0){return false;}
//                else{return true;}
            } else {
                int max = potential;
                int maxI = jumpStartI;
                int remaining = potential;
                for (int i = jumpStartI+1; i < arr.length; i++) {
                    if (remaining == 0) {
                        break;
                    }
                    if (arr[i]>max) {
                        max= arr[i];
                        maxI = i;};
                    remaining--;
                }
                if (remaining>0){return true;}

                remainingIndices=arr.length-1-max;
                if (remainingIndices<=0) {return true;}
                else {
                    jumpStartI = jumpStartI+max;
                    potential = arr[jumpStartI];
                }
            }
        }
        return false;
    }
}
