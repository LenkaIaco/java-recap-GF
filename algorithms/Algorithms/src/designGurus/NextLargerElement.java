package designGurus;

import java.util.Arrays;

public class NextLargerElement {
    /*
    Given an array, print the Next Greater Element (NGE) for every element.
        The Next Greater Element for an element x is the first greater element on the right side of x in the array.
        Elements for which no greater element exist, consider the next greater element as -1.
        Constraints:
        1 <= arr.length <= 104
        -109 <= arr[i] <= 109
Constraints:

1 <= arr.length <= 104
-109 <= arr[i] <= 109
Try it yourself
     */
    public static void main(String[] args) {
        int[] testingList1 ={4,5,2,25}; //  Output: [5, 25, 25, -1]
        int[] testingList2 = {13,7,5,12}; //  Output: [-1, 12, 12, -1]
        int[] testingList3 = {1,2,3,4,5}; // Output: [2, 3, 4, 5, -1]

        System.out.println(Arrays.toString(nextGreaterArrElement(testingList1)));
        System.out.println(Arrays.toString(nextGreaterArrElement(testingList2)));
        System.out.println(Arrays.toString(nextGreaterArrElement(testingList3)));
    }
     /*
       Time Complexity O(n^2) for the 2D loop
       Space complexity O(n) for result arr
         */

    public static int[] nextGreaterArrElement(int[] arr){
        int[] result = new int[arr.length];

        for (int i=0;i<arr.length;i++){
            if (i==arr.length-1){
                result[i]=-1;
                break;
            }
            boolean flag = false;
            for (int y=i+1;y<arr.length;y++){
                if (arr[i]<arr[y]){
                    flag = true;
                    result[i]=arr[y];
                    break;
                }
            }
            if (!flag){result[i]=-1;}
        }

        return result;
    }
}
