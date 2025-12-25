package Functions.Exercises;
import java.util.*;

public class Bubble {
    public static void main(String[] args) {
        // Create a function that takes an array of numbers as parameter
        // and returns an array where the elements are sorted in ascending numerical
        // order
        // When you are done, add a second boolean parameter to the function
        // If it is `true` sort the array descending, otherwise ascending
        Integer [] arr = {1,2};
        List<Integer> aList = new ArrayList<>(Arrays.asList(arr));
        /*sorting List
        aList.sort();               // or aList.sort(Comparator.naturalOrder());
        aList.sort(Comparator.reverseOrder());

        /*  sorting Collections using streams:
        int [] sortedArray = aList.stream().sorted((a,b)-> {
            if (a>b) {return 1;} else if (a ==b){return 0;} else {return -1;}
        }).mapToInt(a -> a.intValue()).toArray(); // or by method call: (Integer::intValue )
        */

        // Example:
        System.out.println(Arrays.toString(bubble(new int[] { 34, 12, 24, 9, 5 })));
        // should print [5, 9, 12, 24, 34]
        System.out.println(Arrays.toString(advancedBubble(new int[] { 34, 12, 24, 9, 5 }, true)));
        // should print [34, 24, 12, 9, 5]
    }
    public static int[] bubble(int[] arrayInput){
        Arrays.sort(arrayInput); // or mySort() in Anagram class
        return arrayInput;}



    public static int[] advancedBubble(int[] arrayInput, boolean descendingSorting){
        ArrayList<Integer> convertedArray = new ArrayList<>();
        int[] result = new int[arrayInput.length];
        for (int i = 0; i < arrayInput.length; i++) {
            convertedArray.add(arrayInput[i]);
        }
        Collections.sort(convertedArray);
        Collections.reverse(convertedArray);
//
        for (int j = 0; j < convertedArray.size(); j++) {

           result[j] = (convertedArray.get(j));
        }

    return result;

    }
}
