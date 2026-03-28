package designGurus;

public class RemoveSameCharDiffCase {
    /*
    Given a string of English lowercase and uppercase letters, make the string "good" by removing
            two adjacent characters that are the same but in different cases.

            Continue to do this until there are no more adjacent characters of the same letter but in different cases.
            An empty string is also considered "good".

            Input: "AaBCcdEeff"
            Output: "Bdff"

            Constraints:
            1 <= s.length <= 100
            s contains only lower and upper case English letters.
     */
    /*
    Time complexity O(n)
    Space complexity O(n) for StringBuilder
     */
    public static void main(String[] args) {
        System.out.println(removeAdjacentCases("AaBCcdEeff"));//exp.out.: "Bdff"
    }

    public static String removeAdjacentCases(String s) {
        if (s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();


        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] != chars[i + 1] && Character.toLowerCase(chars[i]) == Character.toLowerCase(chars[i + 1])) {
                chars[i] = '.';
                chars[i + 1] = '.';
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '.') {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
