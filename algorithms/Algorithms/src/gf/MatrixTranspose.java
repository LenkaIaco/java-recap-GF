package gf;

import java.util.Arrays;

public class MatrixTranspose {
    //https://www.codewars.com/kata/52fba2a9adcd10b34300094c
    /*
Write a function that outputs the transpose of a matrix - a new matrix where
the columns and rows of the original are swapped.

You can assume that each row has the same length,
and that the height and width of the matrix are both positive.

For example, the transpose of:

| 1 2 3 |
| 4 5 6 |
is

| 1 4 |
| 2 5 |
| 3 6 |
     */
    public static void main(String[] args) {
int[][] matrix = {
        {1,2,3},
        {4,5,6}
};

        System.out.println(Arrays.deepToString(transposeMatrix(matrix)));//{ {1,4}, {2,5,}, {3,6} }
    }
    public static int[][] transposeMatrix(int[][] matrix){
        if (matrix==null){return null;}
        if (matrix.length==0){return matrix;}
        int[][] result = new int[matrix[0].length][matrix.length];

        for(int i=0;i<result.length;i++){
            for (int y=0;y<result[i].length;y++){
                result[i][y] = matrix[y][i];
            }
        }

        return result;
    }
}
