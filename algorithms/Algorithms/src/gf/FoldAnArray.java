package gf;

import java.util.Arrays;

public class FoldAnArray {
//    https://www.codewars.com/kata/57ea70aa5500adfe8a000110
    /*
    In this kata you have to write a method that folds a given array of integers by the middle x-times.

An example says more than thousand words:

Fold 1-times:
[1,2,3,4,5] -> [6,6,3]

A little visualization (NOT for the algorithm but for the idea of folding):

 Step 1         Step 2        Step 3       Step 4       Step5
                     5/           5|         5\
                    4/            4|          4\
1 2 3 4 5      1 2 3/         1 2 3|       1 2 3\       6 6 3
----*----      ----*          ----*        ----*        ----*


Fold 2-times:
[1,2,3,4,5] -> [9,6]
As you see, if the count of numbers is odd, the middle number will stay. Otherwise the fold-point is between the middle-numbers, so all numbers would be added in a way.

The array will always contain numbers and will never be null. The parameter runs will always be a positive integer greater than 0 and says how many runs of folding your method has to do.

If an array with one element is folded, it stays as the same array.
     */
public static void main(String[] args) {
    int[] arr1 = {1,2,3,4,5};
    System.out.println(Arrays.toString(foldArray(arr1,1))); //6,6,3
    System.out.println(Arrays.toString(foldArray(arr1,2))); //9,6

}

public static int[] foldArray(int[]arr, int times){
    if(arr==null){return null;}
    if (arr.length==0){return arr;}

    if(arr.length==1){
        if(times==1){return arr;}
        else{return foldArray(arr, 1);}
    }

    if (times==0){return arr;}

    return foldArray(foldOneTime(arr),--times);
}

public static int[] foldOneTime(int[]arr){
    int[] arrEven = new int[arr.length/2];
    int[] arrOdd = new int[(arr.length/2) +1];

    for (int i=0; i<arr.length/2;i++){
        if (arr.length%2==0){
            arrEven[i]=arr[i]+arr[arr.length-1-i];
        }
        else{
            arrOdd[i]=arr[i]+arr[arr.length-1-i];
        }
    }

    if (arr.length%2==0){return arrEven;}
    arrOdd[(arr.length/2)] = arr[(arr.length/2)];

    return arrOdd;
}

}
