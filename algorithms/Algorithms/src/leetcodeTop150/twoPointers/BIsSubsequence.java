package leetcodeTop150.twoPointers;

public class BIsSubsequence {
    /*
    Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
of the characters without disturbing the relative positions of the remaining characters.
(i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Input: s = "abc", t = "ahbgdc"
Output: true

Input: s = "axc", t = "ahbgdc"
Output: false

Constraints:
0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.
     */

    /*
    Time complexity Θ(max(n, m))
     */

    public static void main(String[] args) {
String t = "ahbgdc";
String s = "abc";
String s1 = "axc";

String t2 = "bbaaaa";
String s2 = "aaaaaa";
        System.out.println(isSubsequence(s, t)); //true
        System.out.println(isSubsequence(s1, t)); //false
        System.out.println(isSubsequence(s2, t2)); //false
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length()==0){return true;}
        else if(t.length()<s.length()){return false;}

        int lastI = -1;
        boolean flag = false;

        for (int i=0;i<s.length();i++){
            flag = false;
            for (int y=lastI+1;y<t.length();y++){
                if (s.charAt(i)==t.charAt(y)){
                    lastI=y;
                    flag = true;
                    break;
                }
            }
            if (!flag){return false;}
        }

        return flag;
    }
}
