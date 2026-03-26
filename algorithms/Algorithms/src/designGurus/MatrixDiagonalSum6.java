package designGurus;

public class MatrixDiagonalSum6 {
    /*  Given a square matrix (2D array), calculate the sum of its two diagonals.

The two diagonals in consideration are the primary diagonal that spans from the top-left to the bottom-right and
the secondary diagonal that spans from top-right to bottom-left. If a number is part of both diagonals
(which occurs only for odd-sized matrices), it should be counted only once in the sum.

Example 1:

[[1,2,3],
 [4,5,6],
 [7,8,9]]
Expected Output: 25

Constraints:
n == mat.length == mat[i].length
     */

    /*
    Time complexity O(n)
    Space complexity O(1)
     */

    public static void main(String[] args) {
int[][] arr = {
        {1,2,3},
        {4,5,6},
        {7,8,9}
};

        int[][] test2DArray1 = {
                {1,2},
                {4,5}
        };

        System.out.println(sumDiagonals(arr)); //exp.out: 25
        System.out.println(sumDiagonals(test2DArray1)); //exp.out: 12
    }
    public static int sumDiagonals(int[][]arr){
        if (arr==null){throw new IllegalArgumentException("No input");}
        if (arr.length==0) {return 0;}

        int sum = 0;
        for (int i=0;i<arr.length;i++){
                int reversY = arr[i].length-1-i;
                sum = sum + arr[i][i] + arr[i][reversY];

        }

        if(arr.length%2>0){
            int middleRow = arr.length/2;
            int middleColumn = arr[middleRow].length/2;
            sum-=arr[middleRow][middleColumn];
        }

        return sum;
    }
}
