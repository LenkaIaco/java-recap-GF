package leetcodeTop150.twoPointers;

public class AValidPalindrome {
    /*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

Constraints:
1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
     */

    /*
    time complexity O(n) because of s.toLowerCase() and s.replaceAll()
    space complexity O(n) because of s.toLowerCase() and s.replaceAll()
     */
    public static void main(String[] args) {
        System.out.println(isPalindrome("Pana ,ma12")); // false
        System.out.println(isPalindrome("amanaplanacanalpanama")); // true
        System.out.println(isPalindrome("raceacar")); // false
        System.out.println(isPalindrome(" ")); // true
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");

        if (s.length() <=1) {return true;}

        for (int i = 0; i < s.length() / 2; i++) {
            char first = s.charAt(i);
            char second = s.charAt(s.length() - 1 - i);
            if (first!=second){return false;}
        }
        return true;
    }
}
