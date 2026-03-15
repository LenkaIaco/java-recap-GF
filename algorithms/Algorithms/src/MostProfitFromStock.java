import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostProfitFromStock {
//    https://www.codewars.com/kata/597ef546ee48603f7a000057
    /*
    Stock quotes are stored in an array in order of date.
    The stock profit is the difference in prices in buying and selling stock.
           Each day, you can either buy one unit of stock,
           sell any number of stock units you have already bought,
           or do nothing.
    Therefore, the most profit is the maximum difference of all pairs in a sequence of stock prices.

     [ 1, 2, 3, 4, 5, 6 ]        => 15  (buy at 1,2,3,4,5 and then sell all at 6)
 [ 6, 5, 4, 3, 2, 1 ]        => 0   (nothing to buy for profit)
 [ 1, 6, 5, 10, 8, 7 ]       => 18  (buy at 1,6,5 and sell all at 10)
 [ 1, 2, 10, 3, 2, 7, 3, 2 ] => 26  (buy at 1,2 and sell them at 10. Then buy at 3,2 and sell them at 7)

 @param {array} quotes
@return {number} max profit
     */
public static void main(String[] args) {

    System.out.println(mostProfit(new int[]{ 1, 2, 3, 4, 5, 6 }));
    System.out.println(mostProfit(new int[]{ 6, 5, 4, 3, 2, 1 }));
    System.out.println(mostProfit(new int[]{ 1, 6, 5, 10, 8, 7 }));
    System.out.println(mostProfit(new int[]{ 1, 2, 10, 3, 2, 7, 3, 2 }));
}

public static int mostProfit(int[]stocks){
    if(stocks ==null){return -1;}
    if (stocks.length==0){return -1;}

    List<Integer> lStocks = new ArrayList<>();
    for (int i=0;i<stocks.length;i++){
        lStocks.add(stocks[i]);
    }
   int[] sorted = Arrays.stream(stocks).sorted().toArray();

    int prevIndex = 0;
    int profit = 0;
    int maxIndexSorted = sorted.length-1;
    int max = sorted[maxIndexSorted];
    int maxIndexStocks = lStocks.indexOf(max);

    for (int i = prevIndex; i<maxIndexStocks;i++) {
        profit = profit + max-stocks[i];
        if (i == maxIndexStocks - 1) {
            if (lStocks.indexOf(max) == lStocks.size() - 1) {
                break;
            } else {
            for (int y = maxIndexSorted - 1; y > 0; y--) {
                int nextMax = sorted[y];
                int indexNextStocks = lStocks.indexOf(nextMax);
                if (indexNextStocks > maxIndexStocks) {
                    prevIndex = maxIndexStocks + 1;
                    i = prevIndex;
                    maxIndexStocks = indexNextStocks;
                    max = nextMax;
                    maxIndexSorted = y;
                    break;
                }
            }
        }
    }
    }
    return profit;
}

}
