package gf;

import java.util.Arrays;

public class LeftRotation {
//    https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
    /*
    Given an array a of n integers and a number d, perform d left rotations on the array.
    Return the updated array to be printed as a single line of space-separated integers.

    A left rotation operation on an array shifts each of the array's elements 1 unit to the left.
    For example, if 2 left rotations are performed on array 12345, then the array would become 34512.
    Note that the lowest index item moves to the highest index in a rotation(circular array).

    Complete the function rotLeft having the following parameter(s):
        int a[n]: the array to rotate
        int d: the number of rotations
     Returns int a'[n]: the rotated array
     */
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(Arrays.toString(rotLeft(arr, 2))); //34512
        System.out.println(Arrays.toString(rotLeft(arr, 4))); // 51234
    }

    public static int[] rotLeft(int[] arr, int rotations){
        int [] rotatedArr = new int[arr.length];

        for (int i = 0; i<arr.length; i++){
            int placement = i-rotations;
            if (placement<0){
                placement = arr.length+placement;
            }
            rotatedArr[placement] = arr[i];
        }

        return rotatedArr;
    }
}
