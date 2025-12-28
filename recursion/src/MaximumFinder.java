import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumFinder {
    /** Task:
     // Write a function which returns the largest element of an array using recursion.
     */
    public static void main(String[] args) {
        System.out.println(largestElement(new int[]{9,85,7,3,10}));
    }

    public static int largestElement(int [] arr){
        if (arr.length==0){return 0;}
        if (arr.length==1){return arr[0];}
        if (arr[0]<arr[1]){
            int[] arr2 = Arrays.copyOfRange(arr, 1, arr.length);
            return largestElement(arr2);
        }

        arr[1] = arr[0];
        int[] arr2 = Arrays.copyOfRange(arr, 1,arr.length);
        return largestElement(arr2);
    }
}
