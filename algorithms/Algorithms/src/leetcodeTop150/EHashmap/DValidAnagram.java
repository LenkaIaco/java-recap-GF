package leetcodeTop150.EHashmap;

import java.util.*;

public class DValidAnagram {
    /*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Input: s = "anagram", t = "nagaram"
Output: true

Input: s = "rat", t = "car"
Output: false

Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
     */

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        String s1 = "rat";
        String t1 = "car";

        System.out.println(isAnagram(s,t));//true
        System.out.println(isAnagram(s1,t1));//false
    }
    public static boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){return false;}
        Map<Character, Integer> counts = new HashMap<>();

        for (int i=0;i<s.length();i++){
            Integer count = counts.get(s.charAt(i));
            if (count==null) {
                counts.put(s.charAt(i), 1);
            }else{counts.put(s.charAt(i),++count);}
        }

        for (int i=0;i<t.length();i++){
            Integer count = counts.get(t.charAt(i));
            if (count==null||count==0){
                return false;
            }
            else {counts.put(t.charAt(i),--count);}
        }
        for (Integer i: counts.values()){
            if (i!=0){return false;}
        }
        return true;
    }

    }
