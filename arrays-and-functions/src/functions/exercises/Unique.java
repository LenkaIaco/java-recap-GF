package Functions.Exercises;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class Unique {
    public static void main(String[] args) {
        // Create a function that takes an array of numbers as a parameter
        // and returns an array of integers where every integer is unique
        // (occurs only once)

        // Example
        System.out.println(Arrays.toString(findUniqueItems(
                new int[] { 1, 11, 34, 11, 52, 61, 1, 34 })));
        // should print: `[1, 11, 34, 52, 61]`

    }

    public static int[] findUniqueItems(int [] array){
        // remove duplicate values w keeping elements original sequence https://www.geeksforgeeks.org/java-program-to-remove-duplicate-elements-from-the-array/
        LinkedHashSet<Integer> noDupesSet = new LinkedHashSet<>();
        for (int i = 0; i < array.length; i++) {
            noDupesSet.add(array[i]);
        }
        int[] backToArray = noDupesSet.stream().mapToInt(Integer::intValue).toArray(); // https://stackoverflow.com/questions/2451184/how-can-i-convert-a-java-hashsetinteger-to-a-primitive-int-array
        return backToArray;
    }



}