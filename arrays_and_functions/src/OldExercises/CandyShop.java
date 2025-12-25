import java.util.ArrayList;
import java.util.List;

public class CandyShop {
    public static void main(String... args) {
        ArrayList<Object> sweets = new ArrayList<>();
        sweets.add("Cupcake");
        sweets.add(2);
        sweets.add("Brownie");
        sweets.add(false);

        // Accidentally we added "2" and "false" to the sweets list
        // Your task is to change the "2" to "Croissant" and the "false" to "Ice cream"
        // No, don't just edit the lines above! :)
        // Create a method called "repairSweetList()" which takes the list as a parameter
        // and returns a list with the items "2" and "false" replaced (with "Croissant" and "Ice cream")

        // Expected output: [Cupcake, Croissant, Brownie, Ice cream]

        System.out.println(repairSweetList(sweets));
    }
    public static List repairSweetList(List sweets) {
        String[] replacementSweets = {"Croissant", "Ice Cream"};
        int replacement = 0;
        // https://stackoverflow.com/questions/106336/how-do-i-find-out-what-type-each-object-is-in-a-arraylistobject
        for (int i = 0; i < sweets.size(); i++) {
            if (sweets.get(i).getClass() != String.class) {
//                https://www.geeksforgeeks.org/how-to-replace-a-element-in-java-arraylist/
                sweets.set(i, replacementSweets[replacement]);
                replacement++;
            }
        }
        return sweets;
    }

}
