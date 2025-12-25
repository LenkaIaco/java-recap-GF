import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListIntroduction1 {
    public static void main(String[] args) {
     /*   Create an empty list which will contain names (strings)
                Print out the number of elements in the list
        Add "William" to the list
        Print out whether the list is empty or not
        Add "John" to the list
        Add "Amanda" to the list
        Print out the number of elements in the list
        Print out the 3rd element
        Iterate through the list and print out each name
                William
      */
        List<String> nameList = new ArrayList<>();
        nameList.add("Wiliam");
        System.out.println("is empty: " + nameList.isEmpty());
        nameList.add("John");
        nameList.add("Amanda");

        System.out.println(nameList.size());
        System.out.println(nameList.get(2));
        System.out.println();

        for (String name : nameList
        ) {
            System.out.println(name);
        }

        System.out.println();
        /**
         * Iterate through the list and print
         * 1. William
         * 2. John
         * 3. Amanda
         */
        for (int i = 1; i <= nameList.size(); i++) {
            System.out.println(i + ". " + nameList.get(i - 1));
        }
        System.out.println();
        /**
         * Remove the 2nd element
         * Iterate through the list in a reversed order and print out each name
         * Amanda
         * William
         */


        nameList.remove(1);
        for (int i = nameList.size() - 1; i >= 0; i--) {
            System.out.println(nameList.get(i));
        }
        nameList.removeAll(nameList);
        System.out.println(nameList.size());
    }
}
