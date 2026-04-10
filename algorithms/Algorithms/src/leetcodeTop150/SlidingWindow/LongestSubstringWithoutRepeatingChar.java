package leetcodeTop150.SlidingWindow;

import java.util.*;

public class LongestSubstringWithoutRepeatingChar {

    /*
Given a string s, find the length of the longest substring without duplicate characters.

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
     */

    public static void main(String[] args) {
        String s = "abcabcbb";
       String s1 = "bbbbb";
        String s2 = "pwwkew";
        String s3 = " ";
        System.out.println(longest(s));//3
        System.out.println(longest(s1));//1
        System.out.println(longest(s2));//3
        System.out.println(longest(s3));//1
    }
    public static int longest(String s) {
        int maxLength = 0;
        int left = 0;
        Set<Character> chars = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (chars.contains(c)) {
                maxLength = Math.max(maxLength, chars.size());
                chars.remove(s.charAt(left));
                left++;
            }
            chars.add(c);
        }
        return Math.max(chars.size(),maxLength);
    }
}