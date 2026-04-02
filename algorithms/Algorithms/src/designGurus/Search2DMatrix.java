package designGurus;

public class Search2DMatrix {
/*
  Given a 2D grid of size m x n matrix containing integers, and integer target, return true if target
        value exists in the matrix. Otherwise, return false.
        The matrix has the following properties:
        Values in each column are sorted in non-decreasing order from top to bottom.
        Values in each row are sorted in non-decreasing order from left to right.
        Input: target = 5, matrix =  [[1,2,3], [4,5,6], [7,8,9]]
        Output: true
        Input: target = 19, matrix = [[10,11,12,13], [11,12,13,17],  [14,19,22,24], [22,23,24,25]]
         Output: true
 */
/*
Time complexity O(m*n)
Space complexity O(1)
 */

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int target = 5;
        int[][] matrix1 = {{10, 11, 12, 13}, {11, 12, 13, 17}, {14, 19, 22, 24}, {22, 23, 24, 25}};
        int target1 = 19;
        int[][] matrix2 = {{1, 3, 5}, {7, 9, 11}, {13, 15, 17}};
        int target2 = 6;
        System.out.println(searchValInMatrix(matrix, target)); //exp.out.: true
        System.out.println(searchValInMatrix(matrix1, target1)); //exp.out.: true
        System.out.println(searchValInMatrix(matrix2, target2)); //exp.out.: false;

    }

    public static boolean searchValInMatrix(int[][] matrix, int val) throws NullPointerException {

        if (matrix == null) {
            throw new NullPointerException("Input matrix needs to be defined.");
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int y = 0; y < matrix[i].length; y++) {
                if (matrix[i][y] <= val) {
                    if (matrix[i][y] == val) {
                        return true;
                    }
                } else { break;
                }
            }
        }
        return false;
    }
}
