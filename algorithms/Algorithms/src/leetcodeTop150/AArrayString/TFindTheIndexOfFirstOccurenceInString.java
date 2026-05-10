package leetcodeTop150.AArrayString;

public class TFindTheIndexOfFirstOccurenceInString {
    /*
    Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
    or -1 if needle is not part of haystack.

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.


Constraints:
1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
     */
/*
Time complexity O(m*n)
Space complexity O(1)
 */
    public static void main(String[] args) {
String haystack = "sadbutsad";
String needle = "sad";

String haystack1 = "mississippi";
String needle1 = "issip";
        System.out.println(strStr(haystack, needle)); //0
        System.out.println(strStr(haystack1, needle1)); //4
    }

    public static int strStr(String haystack, String needle) {
        if (haystack.length()<needle.length()){return -1;}

        int needleI = 0;
        for (int i=0;i<haystack.length();i++){
            needleI = 0;
           for (int y=0;y<needle.length();y++){
               if (i+y==haystack.length()){return -1;}
               if (haystack.charAt(i+y)==needle.charAt(y)){
                   needleI++;
               } else{
                   needleI = 0;
                   break;
               }
           }
           if (needleI==needle.length()){return i;}
        }

        return needleI==needle.length() ? haystack.length()-needle.length() : -1;
    }
}
