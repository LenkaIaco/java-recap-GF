package gf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueInOrder {
//    https://www.codewars.com/kata/54e6533c92449cc251001667
    /*
    Implement the function unique_in_order which takes as argument a sequence
    and returns a list of items without any elements with the same value next to each other
    and preserving the original order of elements.

For example:

uniqueInOrder('AAAABBBCCDAABBB') == ['A', 'B', 'C', 'D', 'A', 'B']
uniqueInOrder('ABBCcAD')         == ['A', 'B', 'C', 'c', 'A', 'D']
uniqueInOrder([1,2,2,3,3])       == [1,2,3]
     */
    public static void main(String[] args) {
String s = "AAAABBBCCDAABBB";
String s1 = "ABBCcAD";
String s2 = "12233";

        System.out.println(Arrays.toString(uniques(s))); //ex. out 'A', 'B', 'C', 'D', 'A', 'B'
        System.out.println(Arrays.toString(uniques(s1)));// exp. 'A', 'B', 'C', 'c', 'A', 'D'
        System.out.println(Arrays.toString(uniques(s2)));//exp. 1,2,3
    }

    public static char[] uniques(String sequence){
        if (sequence==null){return null;}
        if (sequence.isEmpty()){return new char[0];}
        char[] sequenceArr = sequence.toCharArray();
        List<Character> cList = new ArrayList<>();
        for (int i=0;i<sequenceArr.length;i++){
            if(i==0){cList.add(sequenceArr[i]);}
            else{
                if (cList.get(cList.size()-1)!=sequenceArr[i]){
                    cList.add(sequenceArr[i]);
                }
            }
        }
        char[] result = new char[cList.size()];
        int index = 0;
        for (Character c: cList){
            result[index]=c;
            index++;
        }
        return result;
    }

}
