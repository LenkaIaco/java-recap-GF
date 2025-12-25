import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class ShoppingList2 {
    public static void main(String[] args) {
        /**
         * Represent the following products with their prices:
         *
         * Product	Price
         * Milk	1.07
         * Rice	1.59
         * Eggs	3.14
         * Cheese	12.60
         * Chicken Breasts	9.40
         * Apples	2.31
         * Tomato	2.58
         * Potato	1.75
         * Onion	1.10
         */
        String[] products = {"Milk", "Rice", "Eggs", "Cheese", "Chicken Breasts", "Apples", "Tomato", "Potato", "Onion"};
        double[] prices = {1.07, 1.59, 3.14, 12.60, 9.40, 2.31, 2.58, 1.75, 1.10};
        HashMap<String, Double> shopCatalog = new HashMap<>();
        for (int i = 0; i < products.length; i++) {
            shopCatalog.put(products[i], prices[i]);
        }

        /**
         * Represent Bob's shopping list:
         *
         * Product	Amount
         * Milk	3
         * Rice	2
         * Eggs	2
         * Cheese	1
         * Chicken Breasts	4
         * Apples	1
         * Tomato	2
         * Potato	1
         */
        String[] productsBob = {"Milk", "Rice", "Eggs", "Cheese", "Chicken Breasts", "Apples", "Tomato", "Potato"};
        Integer[] quantitiesBob = {3, 2, 2, 1, 4, 1, 2, 1};
        HashMap<String, Integer> listBob = new HashMap<>();
        for (int i = 0; i < productsBob.length; i++) {
            listBob.put(productsBob[i], quantitiesBob[i]);
        }

        /**
         * Represent Alice's shopping list:
         *
         * Product	Amount
         * Rice	1
         * Eggs	5
         * Chicken Breasts	2
         * Apples	1
         * Tomato	10
         */

        String[] productsAlice = {"Rice", "Eggs", "Chicken Breasts", "Apples", "Tomato"};
        Integer[] quantitiesAlice = {1, 5, 2, 1, 10};
        HashMap<String, Integer> listAlice = new HashMap<>();
        for (int i = 0; i < productsAlice.length; i++) {
            listAlice.put(productsAlice[i], quantitiesAlice[i]);
        }

/**
 * Create an application which prints out the answers to the following questions:
 *
 * How much does Bob pay?
 * How much does Alice pay?
 */

        double billBob = 0.0;
        for (int i = 0; i < listBob.size(); i++) {
            Object[] productsBobArray = listBob.keySet().toArray();
            double productTotal = listBob.get(productsBobArray[i]) * shopCatalog.get(productsBobArray[i]);
            billBob = billBob + productTotal;
        }
        System.out.println(billBob);

        double billAlice = 0.0;
        for (int i = 0; i < listAlice.size(); i++) {
            Object[] productsAliceArray = listAlice.keySet().toArray();
            double productTotal = listAlice.get(productsAliceArray[i]) * shopCatalog.get(productsAliceArray[i]);
            billAlice = billAlice + productTotal;
        }
        System.out.println(billAlice);

        /**
         * Who buys more Rice?
         * Who buys more Potato?
         * Who buys more Ham?
         * Who buys more Apples?
         */
        String[] compareVeggie = {"Rice", "Potato", "Ham", "Apples"};

        for (int i = 0; i < compareVeggie.length; i++) {

            if (listBob.containsKey(compareVeggie[i]) && listAlice.containsKey(compareVeggie[i])) {
                int bobAmount = listBob.get(compareVeggie[i]).intValue();
                int aliceAmount = listAlice.get(compareVeggie[i]).intValue();
                String hasMore = bobAmount > aliceAmount ? "Bob" : (bobAmount < aliceAmount ? "Alice" : "same item quantity wanted");
                System.out.println(hasMore);
            } else if (!listBob.containsKey(compareVeggie[i]) && listAlice.containsKey(compareVeggie[i])) {
                System.out.println("Alice");
            } else if (listBob.containsKey(compareVeggie[i]) && !listAlice.containsKey(compareVeggie[i])) {
                System.out.println("Bob");
            } else {
                System.out.println("not on anyone's shopping list");
            }
        }

        /**
         *  * Who buys more of different products?
         *  * Who buys more items? (more pieces)
         */
        String biggerList = listBob.size() > listAlice.size() ? "Bob" : (listBob.size() < listAlice.size() ? "Alice" : "Same product quantities wanted");
        System.out.println(biggerList);


        int countBobItems = 0;
        for (Map.Entry<String, Integer> entry : listBob.entrySet()) {
            int i = entry.getValue();
            countBobItems = countBobItems + i;
        }

        int countAliceItems = 0;
        for (Map.Entry<String, Integer> entry : listAlice.entrySet()) {
            int i = entry.getValue();
            countAliceItems = countAliceItems + i;
        }

        String moreItems = countBobItems > countAliceItems ? "Bob" : (countBobItems < countAliceItems ? "Alice" : "same number of items wanted");
        System.out.println(moreItems);
    }
}
