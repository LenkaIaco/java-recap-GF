package designGurus;

import java.util.*;

public class LargestSubstringUniqueChars {
    /*
     Given a string, identify the length of its longest segment that contains distinct characters.
    In other words, find the maximum length of a substring that has no repeating characters.
    Example:
        Input: "abcdaef"
        Expected Output: 6
    Constraints:
        0 <= s.length <= 5 * 104
        s consists of English letters, digits, symbols and spaces.
     */

    /*
    Time Complexity O(n^2)
    Space Complexity O(1) for hashset, because it holds a limited amount of unique characters
     */
    public static void main(String[] args) {
        System.out.println(longestUnique("abcdaef")); //exp.out: 6
    }

public static int longestUnique (String s){
    if (s.length()<=1){return s.length();}
Set<Character> uniqs = new HashSet<>();
    int longest = 0;
    for (int i=0;i<s.length();i++){
        for (int y=i;y<s.length();y++) {
            if (!uniqs.contains(s.charAt(y))) {
                uniqs.add(s.charAt(y));
            } else {
                if (uniqs.size() > longest) {
                    longest = uniqs.size();
                    uniqs.clear();
                    break;
                }
            }
        }
    }
    return longest;
}
}
