import java.util.*;

public class MaxSum {
    private static ArrayList<Integer> sumsArray;
    private static ArrayList<Integer> deletedValues;

    public static void main(String[] args) {
        /** Task:
        // Create a function called `maxSum` which
// expects an array of five integers as an input parameter and
// returns the maximum values that can be
// calculated by summing exactly four of the five integers.
//
// Examples
//
// [1 2 3 4 5] -> 14
//
// We can calculate the following sums using four of the five integers:
//
// 1 + 2 + 3 + 4 = 10
// 1 + 2 + 3 + 5 = 11
// 1 + 2 + 4 + 5 = 12
// 1 + 3 + 4 + 5 = 13
// 2 + 3 + 4 + 5 = 14
         */
        System.out.println(maxSum(new int[]{1, 2, 3, 4, 5}));

    }

    public static int maxSum(int[] array) {
        //https://www.baeldung.com/java-sorting-arrays
        Integer[] integerArraySorted = Arrays.stream(array).boxed().toArray(Integer[]::new);
        Arrays.sort(integerArraySorted, Collections.reverseOrder());
        Arrays.asList(integerArraySorted);
        ArrayList<Integer> sortedArrayList = new ArrayList<>(Arrays.asList(integerArraySorted));
//        ArrayList<Integer> sortedArrayList = new ArrayList<>(Arrays.asList(Arrays.stream(array).boxed().toArray(Integer[]::new)));
        deletedValues = new ArrayList<>();
        deletedValues.add(sortedArrayList.get(sortedArrayList.size() - 1));
        sortedArrayList.remove(sortedArrayList.size() - 1);
        int arraySize = sortedArrayList.size();
        sumsArray = new ArrayList<>();
        sumsArray.add(0);


        if (arraySize == 4) {
            sumsArray.add(sortedArrayList.get(arraySize - 1) + sortedArrayList.get(arraySize - 2) +
                    sortedArrayList.get(arraySize - 3) + sortedArrayList.get(arraySize - 4));
        } else if (arraySize == 3) {
            sumsArray.add(sortedArrayList.get(arraySize - 1) + sortedArrayList.get(arraySize - 2) +
                    sortedArrayList.get(arraySize - 3) + deletedValues.get(0));
        } else if (arraySize == 2) {
            sumsArray.add(sortedArrayList.get(arraySize - 1) + sortedArrayList.get(arraySize - 2) + deletedValues.get(0) + deletedValues.get(1));
        } else if (arraySize == 1) {
            sumsArray.add(sortedArrayList.get(arraySize - 1) + deletedValues.get(0) + deletedValues.get(1) + deletedValues.get(2));
        }
        return Collections.max(sumsArray);
    }
}
