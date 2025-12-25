import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapIntroduction1 {
    public static void main(String[] args) {
        /**
         * Create an empty map where the keys are integers and the values are characters
         * Print out whether the map is empty or not
         * Add the following key-value pairs to the map
         * Key	Value
         * 97	a
         * 98	b
         * 99	c
         * 65	A
         * 66	B
         * 67	C
         *  * Print all the keys
         *  * Print all the values
         */
        HashMap<Integer, Character> hMap = new HashMap<>();
        System.out.println(hMap.isEmpty());
        Integer[] intArray = {97, 98, 99, 65, 66, 67};
        Character[] charArray = {'a', 'b', 'c', 'A', 'B', 'C'};
        for (int i = 0; i < intArray.length; i++) {
            hMap.put(intArray[i], charArray[i]);
        }
        System.out.println(hMap.keySet());
        System.out.println(hMap.values());

/**
 * Add value D with the key 68
 * Print how many key-value pairs are in the map
 * Print the value that is associated with key 99
 * Remove the key-value pair with key 97
 * Print whether there is an associated value with key 100 or not
 * Remove all the key-value pairs
 */

        hMap.put(68, 'D');
        System.out.println(hMap.size());
        System.out.println(hMap.get(99));
        hMap.remove(97);
        System.out.println(hMap.containsKey(100));
        hMap.clear();
        System.out.println(hMap.size());
/**
 *The full output of your main method should be the following:
 *
 * true
 * [97, 65, 98, 66, 99, 67]
 * [a, A, b, B, c, C]
 * 7
 * c
 * false
 * 0
 */
    }

}

