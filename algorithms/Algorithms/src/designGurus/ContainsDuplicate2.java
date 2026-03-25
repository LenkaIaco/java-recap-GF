package designGurus;

import java.util.Arrays;

public class ContainsDuplicate2 {
    /*
    Given an integer array nums, return true if any value appears at least twice in the array,
    and return false if every element is distinct.
     */
/*
time complexity: O(nlogn) arrays.sort();
 */
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,6,4,5};
        int[] arr2 = {4,3,2,5,4,6};

        System.out.println(containsDupes(arr1)); //false
        System.out.println(containsDupes(arr2)); //true
    }

 public static boolean containsDupes (int[] arr){
        if (arr==null){return false;}
        if (arr.length==0){return false;}

     Arrays.sort(arr);
     for (int i=0; i<arr.length-1;i++){
         if(arr[i]==arr[i+1]){
             return true;
         }
     }
     return false;
 }
}
