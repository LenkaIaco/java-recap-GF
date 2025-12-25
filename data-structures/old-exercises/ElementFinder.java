import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElementFinder {
    public static void main(String... args) {
        List<Integer> listOfNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        // Add a method called `containsSeven` that checks if the `listOfNumbers` contains the number 7
        // If it does the method should return "Hoorray" otherwise return "Noooooo"

        // The output should be "Noooooo"
        System.out.println(containsSeven(listOfNumbers));

        // Add a method called `containsSevenDifferent` which implements the same behavior differently
        // (e.g. using different list methods)

        // The output should be "Noooooo", again!
        System.out.println(containsSevenDifferent(listOfNumbers));
    }
    public static String containsSeven(List list){
        String result ="";
        for ( Object element: list){
            result = (int) element == 7 ? "Hoorray" : "Noooooo";
        }
        return result;
    }
    public static String containsSevenDifferent(List list){
        String result ="";
        result = list.contains(7) ? "Hoorray" : "Noooooo, again!";
        return result;
    }
}
