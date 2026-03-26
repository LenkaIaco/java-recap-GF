package designGurus;
import java.util.*;

public class LargestUniqueNumber {
    /*
     Given an array of integers, identify the highest value that appears only once in the array.
    If no such number exists, return -1.
        Input: [1, 2, 3, 2, 1, 4, 4]
        Expected Output: 3
    Constraints:
    1 <= nums.length <= 2000
    0 <= nums[i] <= 100
     */

    /*
    Time complexity O(n)
    Space complexity O(n) for hashmap + O(1) int max --> O(n)
     */

    public static void main(String[] args) {
        int[]arr = {1, 2, 3, 2, 1, 4, 4};
        System.out.println(highestUnique(arr)); //exp. out 3
    }

    public static int highestUnique(int[] arr){
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i=0;i<arr.length;i++){
            Integer count = counts.get(arr[i]);
            if (count==null){
                counts.put(arr[i], 1);
            } else{
                counts.put(arr[i], count+1);
            }
        }

        int max = -1;

        for (int i=0;i<arr.length;i++){
            Integer count = counts.get(arr[i]);
            if (count ==1&& arr[i]>max){
                max = arr[i];
            }
        }

        return max;
    }
}
