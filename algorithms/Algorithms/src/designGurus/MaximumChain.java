package designGurus;

import java.util.*;

public class MaximumChain {
/*
Given a collection of pairs where each pair contains two elements [a, b] and a < b,
        find the maximum length of a chain you can form using pairs.
        A pair [a, b] can follow another pair [c, d] in the chain if b < c.
        You can select pairs in any order and don't need to use all the given pairs.
        Input: [[1,2], [3,4], [2,3]]       Expected Output: 2
        Input: [[5,6], [1,2], [8,9], [2,3]] Expected Output: 3
        Input: [[7,8], [5,6], [1,2], [3,5], [4,5], [2,3]] Expected Output: 3
            Constraints:
            n == pairs.length
            1 <= n <= 1000
            -1000 <= lefti < righti <= 1000
 */
    /*
    Time complexity O(n^2)
    Space complexity O(1)
     */
public static void main(String[] args) {
    int[][] arr1 = {{5,6},{1,2}, {8,9}, {2,3}};
    int[][] arr2 = {{1,2}, {3,4}, {2,3}};
    int[][]arr3 = {{7,8}, {5,6}, {1,2},{3,5}, {4,5}, {2,3}};
    System.out.println(makeChain(arr1)); //exp. 3
    System.out.println(makeChain(arr2));// exp. 2
    System.out.println(makeChain(arr3));//exp 3
}


    public static int makeChain(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int y = i + 1; y < arr.length; y++) {
                int first = arr[i][0];
                int second = arr[y][0];
                if (first > second) {
                    arr[i][0] = second;
                    arr[y][0] = first;
                    int intermediateRight = arr[i][1];
                    arr[i][1]=arr[y][1];
                    arr[y][1]=intermediateRight;
                } else if (first == second) {
                    int firstRight = arr[i][1];
                    int secondRight = arr[y][1];
                    if (firstRight > secondRight) {
                        arr[i][1] = secondRight;
                        arr[y][1] = firstRight;
                        arr[i][0] = second;
                        arr[y][0]=first;
                    }
                }
            }
        }

        int counter = 1;

        for (int i = 0; i < arr.length - 1; i++) {
            int val = arr[i][1];
            for (int y = i + 1; y < arr.length; y++) {
                int next = arr[y][0];
                if (next > val) {
                    counter++;
                    i = y-1;
                    break;
                }
                if (y == arr.length - 1) {
                    return counter;
                }
            }
        }

        return counter;
    }

}
