package leetcodeTop150.twoPointers;

import java.util.Arrays;

public class CTwoSumII {
    /*
    Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
    find two numbers such that they add up to a specific target number.
    Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
Return the indices of the two numbers index1 and index2, each incremented by one,
as an integer array [index1, index2] of length 2.
The tests are generated such that there is exactly one solution. You may not use the same element twice.
Your solution must use only constant extra space.

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].

Constraints:
2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution.
     */

    public static void main(String[] args) {
        int [] numbers = {2,7,11,15};
        int [] numbers1 = {2,3,4};
        int [] numbers2 = {-1,0};

        System.out.println(Arrays.toString(twoSum(numbers,9)));// {1,2}
        System.out.println(Arrays.toString(twoSum(numbers1,6)));// {1,3}
        System.out.println(Arrays.toString(twoSum(numbers2,-1)));// {1,2}
    }

    public static int[] twoSum(int[] numbers, int target) {
    for (int i=0;i<numbers.length-1;i++){
        for (int y=i+1;y<numbers.length;y++){
            int interimSum = numbers[i]+numbers[y];
            if (interimSum==target){
                return new int[]{i+1,y+1};
            } else if (interimSum>target){break;}
        }
    }
    return null;
    }

}
