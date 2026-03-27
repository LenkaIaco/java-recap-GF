package designGurus;

import java.util.Arrays;

public class MaxOfOnesRow {
     /*
Given a binary matrix that has 2 dimensions, consisting of ones and zeros,
determine the row that contains the highest number of ones and return two values:
the zero-based index of this row and the actual count of ones it possesses.

If there is a tie, i.e., multiple rows contain the same maximum number of ones, select the row with the lowest index.

Example 1:
Input: [[1, 0], [1, 1], [0, 1]]
Expected Output: [1, 2]
Justification: The second row [1, 1] contains the most ones, so the output is [1, 2].

Example 2:
Input: [[0, 1, 1], [0, 1, 1], [1, 1, 1]]
Expected Output: [2, 3]
Justification: The third row [1, 1, 1] has the most ones, leading to the output [2, 3].

Constraints:
m == mat.length
n == mat[i].length
1 <= m, n <= 100
mat[i][j] is either 0 or 1.
     */
    /*
    Time complexity O(n)
    Space complexity O(1)
     */
     public static void main(String[] args) {
         int[][] testArray1 = {
                 {1,0},
                 {0,1},
                 {1,1}
         };
         int[][] testArray2 = {
                 {1,0,0},
                 {0,1,1},
                 {0,1,1},
         };
         System.out.println(Arrays.toString(countMaxOnes(testArray1))); //exp.out.: 2,2
         System.out.println(Arrays.toString(countMaxOnes(testArray2))); // exp.out.: 1,2
     }

   public static int[] countMaxOnes(int[][]arr){
       int count = 0;
       int[] result = new int[2];

       for (int i=0;i<arr.length;i++){
           count = 0;
           for (int y=0;y<arr[i].length;y++){
               if (arr[i][y]==1){
                   count++;
               }
           }
           if (result[1]<count){
               result[0]=i;
               result[1]=count;
           }
       }

    return result;
   }

}
