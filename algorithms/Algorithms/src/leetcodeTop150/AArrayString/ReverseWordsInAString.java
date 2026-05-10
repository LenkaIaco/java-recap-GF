package leetcodeTop150.AArrayString;

public class ReverseWordsInAString {
/*
Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words.
The returned string should only have a single space separating the words. Do not include any extra spaces.

Input: s = "the sky is blue"
Output: "blue is sky the"

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

Constraints:
1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
 */
    public static void main(String[] args) {
        String s = "the sky is blue";
        String s1 = "  hello world  ";
        String s2 = "a good   example";
        String s3 = "a ";

//        System.out.println(reverseWords(s));//ex.out.:"blue is sky the"
        System.out.println(reverseWords(s1));//ex.out.: "world hello"
        System.out.println(reverseWords(s2));//ex.out.:"example good a"
        System.out.println(reverseWords(s3));//ex.out.: "a"
    }

    public static String reverseWords(String s) {
        String[] sArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = sArr.length - 1; i >= 0; i--) {
            if (!sArr[i].isEmpty() && !sArr[i].isBlank()) {
                sb.append(sArr[i]);
                if (i != 0) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString().trim();
    }

}
