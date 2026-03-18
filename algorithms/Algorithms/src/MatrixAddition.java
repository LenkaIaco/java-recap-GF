import java.util.Arrays;

public class MatrixAddition {
    //https://www.codewars.com/kata/526233aefd4764272800036f
    /*
    Write a function that accepts two square matrices (N x N two dimensional arrays),
    and return the sum of the two.
    Both matrices being passed into the function will be of size N x N (square),
    containing only integers.

How to sum two matrices:
Take each cell [n][m] from the first matrix, and add it with the [n][m] cell from the second matrix.
 This will be cell [n][m] of the solution matrix.

Visualization:

|1 2 3|     |2 2 1|     |1+2 2+2 3+1|     |3 4 4|
|3 2 1|  +  |3 2 3|  =  |3+3 2+2 1+3|  =  |6 4 4|
|1 1 1|     |1 1 3|     |1+1 1+1 1+3|     |2 2 4|
Example
matrixAddition(
  [ [1, 2, 3],
    [3, 2, 1],
    [1, 1, 1] ],
//      +
  [ [2, 2, 1],
    [3, 2, 3],
    [1, 1, 3] ] )

// returns:
  [ [3, 4, 4],
    [6, 4, 4],
    [2, 2, 4] ]
     */
    public static void main(String[] args) {
        int[][]arr1 = {
                {1,2,3},
                {3,2,1},
                {1,1,1}
        };

        int[][]arr2={
                {2,2,1},
                {3,2,3},
                {1,1,3}
        };
        System.out.println(Arrays.deepToString(matrixAddition(arr1,arr2)));
    }
    public static int[][] matrixAddition(int[][] arr1, int[][]arr2){
    if (arr1==null||arr2==null){return null;}
    if(arr1.length!= arr2.length){return null;}
    int[][] result = new int[arr1.length][arr1[0].length];
    for(int i=0;i<arr1.length;i++){
        for (int y=0;y<arr1[i].length;y++){
            result[i][y]=arr1[i][y]+arr2[i][y];
        }
    }
return result;
    }
}
