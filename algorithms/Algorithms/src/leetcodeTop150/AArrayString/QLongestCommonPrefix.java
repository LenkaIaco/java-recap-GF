package leetcodeTop150.AArrayString;

public class QLongestCommonPrefix {
    /*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Input: strs = ["flower","flow","flight"]
Output: "fl"

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.
     */

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String[] strs1 = {"dog", "racecar", "car"};
        String[] strs2 = {"a"};

//        System.out.println(longestCommonPrefix(strs)); // "fl"
//        System.out.println(longestCommonPrefix(strs1)); // ""
        System.out.println(longestCommonPrefix(strs2)); // "a"
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        int prefixI = -1;
        for (int i = 1; i < strs.length; i++) {
            int index = -1;
            int loops = Integer.min(strs[i].length(), strs[i - 1].length());

            for (int y = 0; y < loops; y++) {
                if (strs[i].charAt(y) == strs[i - 1].charAt(y)) {
                    index = y;
                } else {
                    break;
                }
            }
            if (index == -1) {
                return "";
            } else {
                prefixI = prefixI == -1 ? index : Math.min(prefixI, index);
            }
        }
        return prefixI == -1 ? "" : strs[0].substring(0, prefixI + 1);
    }
}
