package designGurus;

public class AAdjacentDuplicates {
    /*
    Give a string s, convert it into a valid string. A string is considered valid if
    it does not have any two adjacent duplicate characters.

    To make a string valid, we will perform a duplicate removal process.
    A duplicate removal consists of choosing two adjacent and equal letters and removing them.
    We repeatedly make duplicate removals on s until we no longer can.

    Return the final string after all such duplicate removals have been made.

    Input: "azxxzy"
    Expected Output: "ay"
    Description: We remove 'x' from "azxxzy" to get "azzy", then remove 'z' from "azzy" to get "ay"

    Constraints:

    1 <= str.length <= 105
    str consists of lowercase English letters.
     */

    /*
testing code:
String input = "azxxzy";
System.out.println(removeDuplicates(input));
 */
    /*
    Time complexity O(m^2) worst case. O(m * n) (m - length of s; n - number of function calls - worst case n=m, constants removed: (m + m-2 + m-4 ....)
    Space complexity O(m^2) (m iterations, but each StringBuilder created per function call has space complexity O(m) )
     */
    public static void main(String[] args) {
                System.out.println(noAdjacentDupes("azxxzy"));

    }

    public static String noAdjacentDupes(String s) {
        boolean found = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                i += 1;
                found = true;
                if (i + 1 == s.length() - 1) {
                    sb.append(s.charAt(i + 1));
                }
            } else {
                sb.append(s.charAt(i));
                if (i + 1 == s.length() - 1) {
                    sb.append(s.charAt(i + 1));
                }
            }
        }

        return found ? noAdjacentDupes(sb.toString()) : sb.toString();
    }
}
