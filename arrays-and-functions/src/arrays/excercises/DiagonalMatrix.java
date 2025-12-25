package Arrays.Excercises;

import java.util.Scanner;
import java.util.Arrays;

public class DiagonalMatrix {
    public static void main(String[] args) {
        // Write a program that asks for an integer `size` from the standard input,
        // then it creates a two-dimensional array (of integers) of the specified
        // size (nxn) with the value of 1 on the main diagonal and the value of 0
        // everywhere else. Print the 2d array into the output
        //
        // Example:
        //
        // Please enter the array (matrix) size: 4
        // 1 0 0 0
        // 0 1 0 0
        // 0 0 1 0
        // 0 0 0 1
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the array (matrix) size: ");
        int userInput = scan.nextInt();
        int[][] matrix = create(userInput);

//        printing array with brackets, in a single line:
//        System.out.println(Arrays.deepToString(matrix));

    /*  printing with array brackets line by line:
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
     */

//        printing array without brackets:
        print(matrix);
    }

    public static int[][] create(int size) {
        int[][] matrix = new int[size][size];
        // write your code to create an nxn matrix of the given size here
        // this matrix should already have value of 1 on the main diagonal
        for (int dim1 = 0; dim1 < size; dim1++) {
            for (int dim2 = 0; dim2 < size; dim2++)
                if (dim1 == dim2) {
                    matrix[dim1][dim2] = 1;
//                    whole dimension1 - define at once, manually: dim1 = [{1,2;3,4;5,6}]
                } else {
                    matrix[dim1][dim2] = 0;
                }

        }
        return matrix;
    }


    public static void print(int[][] matrix) {
//         write your code to print the given matrix
//         into the (standard) output here
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}