package leetcodeTop150.ArrayString;

public class HBestTimeToBuySellStock2 {
    /*
    You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
HOWEVER: you can sell and then buy the stock multiple times on the SAME DAY!
Find and return the maximum profit you can achieve.

Examples

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.

Input: prices = [1,2,3,4,5]
Output: 4

Input: prices = [7,6,4,3,1]
Output: 0

Constraints:
1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104
     */
    /*
    Time complexity O(n)
    Space complexity O(1)
     */
    public static void main(String[] args) {
        System.out.println(maxProfit2(new int[]{7,1,5,3,6,4}));  //exp.out.: 7
        System.out.println(maxProfit2(new int[]{1,2,3,4,5}));  //exp.out.: 4
        System.out.println(maxProfit2(new int[]{7,6,4,3,1})); //exp.out.: 0
        System.out.println(maxProfit2(new int[]{6,1,3,2,4,7})); //exp.out.: 7
    }
    public static int maxProfit(int[] prices) {
        if (prices.length==1){
            return 0;
        }
        int profit = 0;
        for (int i=0;i<prices.length-1;i++){
            if (prices[i]<prices[i+1]){
              profit += prices[i+1] - prices[i];
            }
        }
        return profit;
    }

    public static int maxProfit2(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }
}
