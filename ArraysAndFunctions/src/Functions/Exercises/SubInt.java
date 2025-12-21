package Functions.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubInt {
    public static void main(String[] args) {
        // Create a function that takes a number (a digit) and an array of integers
        // as parameters and returns the indices of the integers in the array
        // which contain the given digit or returns an empty array
        // (if no number in the array contains the given digit)

        // Examples:
        System.out.println(Arrays.toString(findMatchingIndices(1, new int[]{1, 11, 34, 52, 61})));
        // should print: `[0, 1, 4]`
        System.out.println(Arrays.toString(findMatchingIndices(9, new int[]{1, 11, 34, 52, 61})));
        // should print: '[]'
    }

    public static int[] findMatchingIndices(int number, int[] arr) {

        List<Integer> indices = new ArrayList<>();

        if (number < 0 || number > 9) {
            return new int[0];
        }

        for (int i = 0; i < arr.length; i++) {
            String s = String.valueOf(arr[i]);
            if (s.contains(String.valueOf(number))) {
                indices.add(i);
            }
        }
//            Also possible to return Integer[] converted array:
//        Integer[] result1 = indices.toArray(new Integer[0]);
        int[] result1 = indices.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return result1;
    }
}