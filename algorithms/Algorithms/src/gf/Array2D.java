package gf;

public class Array2D {
//    https://www.hackerrank.com/challenges/2d-array/problem
    /*
    Given a 6x6 2D array an hourglass is a subset of values with indices falling in the following pattern:
    a b c
      d
    e f g
There are 16 hourglasses in a 6x6 array.
The hourglass sum is the sum of the values in an hourglass.
Calculate the hourglass sum for every hourglass in arr, then print the maximum hourglass sum.
     */
public static void main(String[] args){
    int arr [][] = {
            {-9,-9,-9,1,1,1},
            {0,-9,0,4,3,2},
            {-9,-9,-9,1,2,3},
            {0,0,8,6,6,0},
            {0,0,0,-2,0,0},
            {0,0,1,2,4,0}
    };

    int result = hourglassMax(arr);

    System.out.println(result); // expected max: 28
}
public static int hourglassMax(int[][] arr) {
    int max = Integer.MIN_VALUE;
    int sum = 0;
    int lengthOffset = 2;
    int depthOffset = 2;

    for (int i=0; i<arr.length-2;i++){
        for (int y=i; y<arr[i].length-2;y++){
           for (int z = 0; z<3;z++){
               sum = sum + arr[i][y+z];
               sum = sum + arr[i+2][y+z];
           }
            sum = sum + arr[i+1][y+1];
           if (sum>max){
               max = sum;
           }
            sum = 0;
        }
    }
    return max;
}
}
