package gf;

import java.util.Arrays;

public class GreatestValuesInMatrices {
    /*
    take two matrices as parameters and returns a new matrix.
The method should compare each element in the input matrices and fill the
returned matrix with the greater values.
You only have to deal with square matrices and should throw an `IllegalArgumentException`
on invalid input or if the matrices are not the same size.
A square matrix is a matrix with the same number of rows and columns.
     */
    public static void main(String[] args) throws IllegalArgumentException{
int[][] matrix1 =  {
        {1,1,1},
        {2,2,2},
        {3,3,4}
};
        int[][] matrix2 =  {
                {2,2,2},
                {1,1,1},
                {4,3,3}
        };

        System.out.println(Arrays.deepToString(mergeMatrix(matrix1,matrix2))); //exp.out: 222, 222, 434
    }
    public static int[][] mergeMatrix(int[][] matrix1, int[][] matrix2)throws IllegalArgumentException{
        if (matrix1==null||matrix2==null){return null;}
        if(matrix1.length!=matrix2.length){
            throw new IllegalArgumentException();
        }
        int[][]result = new int[matrix1.length][matrix1[0].length];

        for (int i=0;i<matrix1.length;i++){
            for (int y=0;y<matrix1[i].length;y++){
                int greater = matrix1[i][y]>=matrix2[i][y] ? matrix1[i][y] : matrix2[i][y];
                result[i][y]= greater;
            }
        }
        return result;
    }
}
