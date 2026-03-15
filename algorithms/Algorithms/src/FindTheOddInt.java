import java.util.HashMap;
import java.util.Map;

public class FindTheOddInt {
//    https://www.codewars.com/kata/54da5a58ea159efa38000836
    /*
    Given an array of integers, find the one that appears an odd number of times.
There will always be only one integer that appears an odd number of times.
Examples
[7] should return 7, because it occurs 1 time (which is odd).
[1,1,2] should return 2, because it occurs 1 time (which is odd).
[0,1,0,1,0] should return 0, because it occurs 3 times (which is odd).
[1,2,2,3,3,3,4,3,3,3,2,2,1] should return 4, because it appears 1 time (which is odd).
     */
public static void main(String[] args) {
    System.out.println(findOddInt(new int[]{7}));
    System.out.println(findOddInt(new int[]{1,1,2}));
    System.out.println(findOddInt(new int[]{0,1,0,1,0}));
    System.out.println(findOddInt(new int[]{1,2,2,3,3,3,4,3,3,3,2,2,1}));
}
public static int findOddInt(int[] arr){
    if (arr==null){return -1;}
    Map<Integer, Integer> numCount = new HashMap<>();

    for (int i =0; i<arr.length;i++){
        if (numCount.containsKey(arr[i])){
            int val = numCount.get(arr[i]);
            numCount.put(arr[i],++val);
        }
        else{numCount.put(arr[i],1);}
    }

    for(Map.Entry<Integer, Integer> e: numCount.entrySet()){
        if(e.getValue()%2>0){
            return e.getKey();
        }
    }
    return -1;
}
}
