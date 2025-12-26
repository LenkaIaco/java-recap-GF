import javax.print.DocFlavor;
import java.util.*;

public class ListIntroduction2 {
    public static void main(String[] args) {
        /*
          Create a list ('List A') which contains the following values
          Apple, Avocado, Blueberries, Durian, Lychee
          Create a new list ('List B') with the values of List A
          Print whether List A contains "Durian" or not
          Remove "Durian" from List B
          Add "Kiwifruit" to List A after the 4th element
         */
        String[] fruitArray = {"Apple", "Avocado", "Blueberries", "Durian", "Lychee"};
        List<String> listA = new ArrayList<>();
        for (int i = 0; i < fruitArray.length; i++) {
            listA.add(fruitArray[i]);
        }
       List<String> listB = new ArrayList<>();
        listB.addAll(listA);

        System.out.println(listB);

        System.out.println(listA.contains("Durian"));
        listB.remove("Durian");
        listA.add(4, "Kiwifruit");

        /*
          Compare the size of List A and List B
          Get the index of "Avocado" from List A
          Get the index of "Durian" from List B
          Add "Passion Fruit" and "Pomelo" to List B in a single statement
         */

        boolean comparisom = listB.size() == (listA.size());
        System.out.println(comparisom);
        System.out.println(listA.indexOf("Avocado"));
        System.out.println(listB.indexOf("Durian"));


/*        option 2:
        listB.addAll(Arrays.stream(new String[]{"Passion Fruit", "Pomelo"}).toList());
*/

        /*
          Print out the 3rd element from List A
          Print all elements of List A
          Print all elements of List B
         */

        System.out.println(listA.get(2));
        System.out.println(listA);
        System.out.println(listB);


        /*
          The full output of your main method should be the following:

          true
          false
          1
          -1
          Blueberries
          [Apple, Avocado, Blueberries, Durian, Kiwifruit, Lychee]
          [Apple, Avocado, Blueberries, Lychee, Passion Fruit, Pomelo]
         */
    }
}


