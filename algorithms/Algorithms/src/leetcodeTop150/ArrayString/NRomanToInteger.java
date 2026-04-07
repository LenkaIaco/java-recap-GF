package leetcodeTop150.ArrayString;

import java.util.*;

public class NRomanToInteger {

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
