import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapIntroduction2 {
    public static void main(String[] args) {
        /**
         *  Create a map where the keys are strings and the values are strings with the following initial values
         * Key	Value
         * 978-1-60309-452-8	A Letter to Jo
         * 978-1-60309-459-7	Lupus
         * 978-1-60309-444-3	Red Panda and Moon Bear
         * 978-1-60309-461-0	The Lab
         * Print all the key-value pairs in the following format
         *
         * A Letter to Jo (ISBN: 978-1-60309-452-8)
         * Lupus (ISBN: 978-1-60309-459-7)
         * Red Panda and Moon Bear (ISBN: 978-1-60309-444-3)
         * The Lab (ISBN: 978-1-60309-461-0)
         */
        HashMap<String, String> hMap = new HashMap<>();
        hMap.put("978-1-60309-452-8", "A Letter to Jo");
        hMap.put("978-1-60309-459-7", "Lupus");
        hMap.put("978-1-60309-444-3", "Red Panda and Moon Bear");
        hMap.put("978-1-60309-461-0", "The Lab");

        for (String key : hMap.keySet()) {
            System.out.println(hMap.get(key) + " (ISBN: " + key + ")");
        }
/**
 * Remove the key-value pair with key 978-1-60309-444-3
 * Remove the key-value pair with value The Lab
 * Add the following key-value pairs to the map:
 * Key	Value
 * 978-1-60309-450-4	They Called Us Enemy
 * 978-1-60309-453-5	Why Did We Trust Him?
 */


        hMap.remove("978-1-60309-444-3");

        String theLabKey = new String();
        for (Map.Entry<String, String> entry : hMap.entrySet()) {
            if (entry.getValue().equals("The Lab")) {
                theLabKey = entry.getKey();
            }
        }

        hMap.remove(theLabKey);
        hMap.put("978-1-60309-450-4", "They Called Us Enemy");
        hMap.put("978-1-60309-453-5", "Why Did We Trust Him?");

        /**
         * Print whether there is an associated value with key 478-0-61159-424-8 or not
         * Print the value associated with key 978-1-60309-453-5
         */

        System.out.println(hMap.containsKey("478-0-61159-424-8"));
        System.out.println(hMap.get("978-1-60309-453-5"));
        /**
         * The full output of your main method should be the following:
         *
         * A Letter to Jo (ISBN: 978-1-60309-452-8)
         * Red Panda and Moon Bear (ISBN: 978-1-60309-444-3)
         * Lupus (ISBN: 978-1-60309-459-7)
         * The Lab (ISBN: 978-1-60309-461-0)
         * false
         * Why Did We Trust Him?
         */


    }
}
