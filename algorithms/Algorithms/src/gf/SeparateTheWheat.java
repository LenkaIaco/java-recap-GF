package gf;

import java.util.Arrays;

public class SeparateTheWheat {
    // https://www.codewars.com/kata/5bdcd20478d24e664d00002c
    /*
    Given a sequence of n integers , separate the negative numbers (chaff) from positive ones (wheat).

    Sequence size is at least 3
Return a new sequence, such that negative numbers (chaff) come first, then positive ones (wheat).

Example
wheatFromChaff ({7, -8, 1 ,-2}) ==> return ({-2, -8, 1, 7})
wheatFromChaff ({-31, -5, 11 , -42, -22, -46, -4, -28 }) ==> return ({-31, -5,- 28, -42, -22, -46 , -4, 11})
     */
    public static void main(String[] args) {
        long[] arr1 = new long[]{7L, -8L, 1L ,-2L};
        long[] arr2 = new long[]{-31L, -5L, 11L ,-42L, -22L, -46L,-4L,-28L};

        //exp. out: ({-2, -8, 1, 7})
        System.out.println(Arrays.toString(wheatFromChaff(arr1)));

// {-31, -5,- 28, -42, -22, -46 , -4, 11}
        System.out.println(Arrays.toString(wheatFromChaff(arr2)));
    }

    public static long[] wheatFromChaff(long[] values) {
    int positiveIndex = values.length-1;
    for (int i=0;i<positiveIndex; i++){
        if (values[i]>=0){
            if (positiveIndex==i) {return values;}
            long intermediate = values[positiveIndex];
            values[positiveIndex] = values[i];
            values[i]=intermediate;
            positiveIndex--;
            i--;
        }
    }

    return values;
    }

}
