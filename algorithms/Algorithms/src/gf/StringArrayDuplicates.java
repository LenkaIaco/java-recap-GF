package gf;

import java.util.Arrays;

public class StringArrayDuplicates {
    // https://www.codewars.com/kata/59f08f89a5e129c543000069
    /*
 given an array of strings and your task is to remove all consecutive duplicate letters from each string in the array.

For example:

dup(["abracadabra","allottee","assessee"]) = ["abracadabra","alote","asese"].

dup(["kelless","keenness"]) = ["keles","kenes"].

Strings will be lowercase only, no spaces
     */
    public static void main(String[] args) {
String[] arr1 = {"abracadabra","allottee","assessee"};
String[] arr2 = {"kelless","keenness"};

        System.out.println(Arrays.toString(removeDupeLetters(arr1))); //"abracadabra","alote","asese"]
        System.out.println(Arrays.toString(removeDupeLetters(arr2))); //"keles","kenes"
    }

    public static String[] removeDupeLetters(String[] arr){
        if (arr==null){return null;}
        if (arr.length==0){return new String[0];}
        String [] dupeRemoved = new String[arr.length];

        for (int i=0;i<arr.length;i++){
            char[] cArr = new char[arr[i].length()];
            int index = 0;

            for (int y=0;y<arr[i].length();y++){
                if (y==0){cArr[0]=arr[i].charAt(0);index++;}
                else if (arr[i].charAt(y-1)!=arr[i].charAt(y)){
                    cArr[index]=arr[i].charAt(y);
                    index++;
                }
            }

            dupeRemoved[i] = new String(cArr).substring(0,index);
        }
        return dupeRemoved;
    }
}
