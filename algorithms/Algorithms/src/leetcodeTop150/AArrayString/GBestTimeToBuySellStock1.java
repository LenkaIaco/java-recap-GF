package leetcodeTop150.AArrayString;

public class GBestTimeToBuySellStock1 {
    /*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future
 to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Examples:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.


Constraints:
1 <= prices.length <= 105
0 <= prices[i] <= 104
     */

    /*
    Time complexity O(n^2)
    Space complexity O(1)
     */
    public static void main(String[] args) {
    int[] prices = {7,1,5,3,6,4};//exp.out: 5
    int[] prices1 = {7,6,4,3,1};//ex.o.:// 0
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit(prices1));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int y = i + 1; y < prices.length; y++) {
                if (prices[i]<prices[y]){
                    int diff = prices[y]-prices[i];
                    if (diff >max){max = diff;}
                }
            }
        }

    return max;
    }
}
