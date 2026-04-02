package designGurus;

import java.util.*;

public class UniqueNumberOccurences {
    /*
Given an array of integers, determine if the number of times each distinct integer appears in the array is unique.
In other words, the occurrences of each integer in the array should be distinct from the occurrences of every other
 integer
 Example:
     Input: [4, 5, 4, 6, 6, 6]
    Expected Output: true
    Justification: The number 4 appears 2 times, 5 appears 1 time, and 6 appears 3 times.
    All these occurrences (1, 2, 3) are unique.
 Constraints:
    1 <= arr.length <= 1000
    -1000 <= arr[i] <= 1000
 */

    /*
    Time Complexity O(n)
    Space complexity O(n)
     */
    public static void main(String[] args) {
        int[] arr = {4, 5, 4, 6, 6, 6};
        int[] testArray = {7, 8, 8, 9, 9, 9, 10, 10};
        System.out.println(areCountsUnique(arr));//exp.out.:true
        System.out.println(areCountsUnique(testArray));//exp.out.:false
    }

    public static boolean areCountsUnique(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            Integer count = counts.get(arr[i]);
            if (count == null) {
                counts.put(arr[i], 1);
            } else {
                counts.put(arr[i], count + 1);
            }
        }

        List<Integer> l = new ArrayList<>(counts.values());
        Set<Integer> countSet = new HashSet<>(l);

        return l.size() == countSet.size();
    }

}
