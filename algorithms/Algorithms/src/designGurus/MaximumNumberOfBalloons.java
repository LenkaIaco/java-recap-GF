package designGurus;

import java.util.*;

public class MaximumNumberOfBalloons {
/*
Given a string, determine the maximum number of times the word "balloon" can be formed using the characters from the string.
    Each character in the string can be used only once.
    - Input: "balloonballoon"
        Expected Output: 2
    - Input: "bbaall"
        Expected Output: 0

        Constraints:
        1 <= text.length <= 104
        text consists of lower case English letters only.
 */

    /*
    Time complexity O(n) for string s / string "balloon" whichever shorter
    Space complexity O(1) for HashMap, as finite amount of chars, also for String "balloon"
     */
public static void main(String[] args) {
    String text1 = "balloon";
    String text2 = "balloo";
    String text3 = "balloonballoon";
    String text4 = "bbaall";

    System.out.println(countBalloons(text1));//exp. out.: 1
    System.out.println(countBalloons(text2));//exp. out.: 0
    System.out.println(countBalloons(text3));//exp. out.: 2
    System.out.println(countBalloons(text4));//exp. out.: 0
}
public static int countBalloons(String s){
    StringBuilder sb = new StringBuilder(s);
    Map<Character, Integer> counts = new HashMap<>();
    counts.put('b',0);
    counts.put('a',0);
    counts.put('l',0);
    counts.put('o',0);
    counts.put('n',0);

    for (int i=0;i<s.length();i++){
        Integer count = counts.get(s.charAt(i));
        if (count!=null){
            counts.put(s.charAt(i),count+1);
        }
    }

    String balloon = "balloon";
    int counter = 0;

    while (counts.size()>0) {
        for (int i = 0; i < balloon.length(); i++) {
            Integer count = counts.get(balloon.charAt(i));
            if (count>0){
                counts.put(balloon.charAt(i),count-1);
            }
            else{return counter;}
            if (i==balloon.length()-1){
                counter++;
            }
        }
    }
    return counter;
}
}
