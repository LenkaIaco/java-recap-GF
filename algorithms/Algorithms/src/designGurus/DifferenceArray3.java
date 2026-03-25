package designGurus;

import java.util.Arrays;
import java.util.Collections;

public class DifferenceArray3 {
    /*
    Each element of differenceArray, i.e., differenceArray[i], should be calculated as follows:
    take the sum of all elements to the left of index i in array nums (let's call it leftSumi),
    and subtract the sum of all elements to the right of index i in array nums (let's call it rightSumi),
    taking the absolute value of the result:

    differenceArray[i] = | leftSum - rightSum |
     */
/*
Time complexity O(n*n/2) --> simplified O(n^2) for n = arr length
Space complexity O(n) for diff arr length
 */
    public static void main(String[] args) {
            int[] nums = new int[]{1, 2, 3, 4, 5};
    int[] solution = {14, 11, 6, 1, 10};
    int[] diff = makeDifferenceArray(nums);
        System.out.println(Arrays.compare(solution,diff)); //exp. out: 0
        System.out.println(Arrays.equals(solution,diff)); //exp. out: true
    }

public static int[] makeDifferenceArray(int[] arr){
    if (arr==null){return null;}
    if (arr.length==0||arr.length==1){return new int[0];}
    int sumAll = 0;
    for (int i=0;i<arr.length;i++){
        sumAll+=arr[i];
    }

    int[] diffArr = new int[arr.length];
    for (int i=0;i<arr.length;i++){
        int left = 0;
        int right = 0;
        if (i< arr.length/2){
            for (int y=0;y<i;y++){
                left+=arr[y];
            }
            right = sumAll-arr[i]-left;
        } else{
            for (int y=i+1;y<arr.length;y++){
                right+=arr[y];
            }
            left=sumAll-arr[i]-right;
        }
        diffArr[i]=Math.abs(left-right);
    }
return diffArr;
}
}
