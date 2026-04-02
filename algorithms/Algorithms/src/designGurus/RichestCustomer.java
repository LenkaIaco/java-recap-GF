package designGurus;

import java.util.Arrays;

public class RichestCustomer {
    /*
     You are given an m x n matrix accounts where accounts[i][j] is the amount of money the
    customer i has in the j bank.

Return the wealth that the richest customer has.

Imagine every customer has multiple bank accounts, with each account holding a certain amount of money.
The total wealth of a customer is calculated by summing all the money across all their multiple accounts.

    Example 1:
    Input: accounts =
    [[5,2,3],
    [0,6,7]]
    Expected Output: 13

 m == accounts.length
 n == accounts[i].length
 1 <= m, n <= 50
 1 <= accounts[i][j] <= 100

     */
    /*
    Time complexity O(m*n)
    Space complexity O(1)
     */
    public static void main(String[] args) {
        int[][] arr1 = {{5,2,3}, {0,6,7}};
        int[][] arr2 = {{1,2},{3,4},{5,6}};
        int[][]arr3 = {{5,10,15},  {10,20,30},  {15,30,45}};

        System.out.println(maxCustomerInBank(arr1)); //exp.out.: 13
        System.out.println(maxCustomerInBank(arr2)); //exp.out.: 11
        System.out.println(maxCustomerInBank(arr3)); //exp.out.: 90
    }

    public static int maxCustomerInBank (int [][] arr){
        int max = 0;
        if (arr.length==1){return Arrays.stream(arr).flatMapToInt(Arrays::stream).sum();} //row ->Arrays.stream(row)

        for (int i=0;i<arr.length;i++){
            int rowSum = 0;
            for (int y=0;y<arr[i].length;y++){
                rowSum+=arr[i][y];
            }
            if (max<rowSum){max=rowSum;}
        }
        return max;
    }
}
