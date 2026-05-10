package leetcodeTop150.EHashmap;

import java.util.*;

public class BIsomorphicStrings {
    /*
 Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order
 of characters. No two characters may map to the same character, but a character may map to itself.

Input: s = "egg", t = "add"
Output: true
    The strings s and t can be made identical by:
    Mapping 'e' to 'a'.
    Mapping 'g' to 'd'.

Input: s = "f11", t = "b23"
Output: false
The strings s and t can not be made identical as '1' needs to be mapped to both '2' and '3'.

Input: s = "paper", t = "title"
Output: true


Constraints:
1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.
     */

    public static void main(String[] args) {
 String s = "egg"; String t = "add";
 String s1 = "f11"; String t1 = "b23";
 String s2 = "paper"; String t2 = "title";
 String s3 = "badc"; String t3 = "baba";

        System.out.println(isIsomorphic(s,t));//true
        System.out.println(isIsomorphic(s1,t1));//false
        System.out.println(isIsomorphic(s2,t2));//true
        System.out.println(isIsomorphic(s3,t3));//false
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> charMapS = new HashMap<>();
        for (int i=0;i<s.length();i++){
            Character valS = charMapS.get(s.charAt(i));
            if (valS ==null){
                if (charMapS.values().contains(t.charAt(i))){
                    return false;
                }else{
                charMapS.put(s.charAt(i),t.charAt(i));}
            } else {
                if (t.charAt(i) != valS) {
                    return false;
                }
            }
        }
        return true;
    }
}
