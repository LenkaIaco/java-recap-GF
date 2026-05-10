package leetcodeTop150.EHashmap;

import java.util.HashMap;
import java.util.Map;

public class ARansomNote {
    /*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters
 from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

Input: ransomNote = "a", magazine = "b"
Output: false
Input: ransomNote = "aa", magazine = "ab"
Output: false
Input: ransomNote = "aa", magazine = "aab"
Output: true

Constraints:
1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.
     */
    public static void main(String[] args) {
        System.out.println(canConstruct("a","b"));//false
        System.out.println(canConstruct("aa","ab"));//false
        System.out.println(canConstruct("aa","aab"));//true
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> chCounts = new HashMap<>();
        for (int i=0;i<magazine.length();i++){
            Integer count = chCounts.get(magazine.charAt(i));
            if (count == null){
                chCounts.put(magazine.charAt(i),1);
            }else {chCounts.put(magazine.charAt(i),++count);}
        }

        for (int i=0;i<ransomNote.length();i++){
            Integer count = chCounts.get(ransomNote.charAt(i));
            if (count==null||count==0){return false;}
            chCounts.put(ransomNote.charAt(i),--count);
        }
        return true;
    }


}