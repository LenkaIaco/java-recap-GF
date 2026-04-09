package leetcodeTop150.arrayString;

import java.util.*;

public class NRomanToInteger {
    /*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

Examples:

Input: s = "III"
Output: 3
Explanation: III = 3.

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

Constraints:
1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].
     */

    public static void main(String[] args) {
       String s = "III";
       String s1 =  "LVIII";
       String s2 =  "MCMXCIV";
        System.out.println(romanToInt(s));//3
        System.out.println(romanToInt(s1));//58
        System.out.println(romanToInt(s2));//1994
    }

    public static int romanToInt(String s) {
        char[] romans = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] values = {1,5,10,50,100,500,1000};
        Map<Character, Integer> chart= new HashMap<>();
        for (int i=0; i< values.length; i++){
            chart.put(romans[i],values[i]);
        }

        int result = 0;
        for (int i=s.length()-1;i>=0;i--){
            int faceVal = chart.get(s.charAt(i));
            if (i==0){result+=faceVal;
            } else{
                    if (s.charAt(i-1)=='I'){
                        if (s.charAt(i)=='X'){result+=9;i--;}
                        else if (s.charAt(i)=='V'){result+=4; i--;}
                        else{result+=faceVal;}
                    } else if (s.charAt(i-1)=='X'){
                        if (s.charAt(i)=='L'){result+=40;i--;}
                        else if (s.charAt(i)=='C'){result+=90;i--;}
                        else {result+=faceVal;}
                    } else if (s.charAt(i-1)=='C'){
                        if (s.charAt(i)=='D'){result+=400;i--;}
                        else if(s.charAt(i)=='M'){result+=900;i--;}
                        else {result+=faceVal;}
                    }
                    else{result+=faceVal;}


         }
        }
        return result;
    }
}
