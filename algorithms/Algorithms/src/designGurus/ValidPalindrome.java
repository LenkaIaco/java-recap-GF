package designGurus;

public class ValidPalindrome {
    /*
     Given string s, determine whether it's possible to make a given string palindrome by removing
         at most one character.
        A palindrome is a word or phrase that reads the same backward as forward.
        Example:
        Input: "abeccdeba" Output: true
        Input: "abcdef" Output: false
        Constraints:
        1 <= s.length <= 105
        str consists of lowercase English letters.
     */

    /*
    Time complexity
    canPalindrome:      O(n*(n-1)/2) --> O(n^2)
    canPalindrome2:     O(n)
    Space complexity
     canPalindrome:     O(n^2)
     canPalindrome2:    O(1)
     */

    public static void main(String[] args) {
        String s1 = "racecar";
        String s2 = "abccdba";
        String s3 = "abcdef";
        String s4 = "aaa";

        System.out.println(canPalindrome2(s1));//true
        System.out.println(canPalindrome2(s2));//true
        System.out.println(canPalindrome2(s3));//false
        System.out.println(canPalindrome2(s4));//true
    }
    public static boolean canPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return flag;
        }
        flag = true;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s);
            sb.deleteCharAt(i);
            flag = true;
            for (int y = 0; y < sb.length() / 2; y++) {
                if (sb.charAt(y) != sb.charAt(sb.length() - 1 - y)) {
                    flag = false;
                    break;
                }
            }
            if (flag){return flag;}
        }
        return flag;
    }

    public static boolean canPalindrome2(String s) {
        if (s.length()==1){return true;}
        boolean flag = true;
        for (int i=0;i<s.length()/2;i++){
            if (s.charAt(i)!=s.charAt(s.length()-1-i)){
                flag = false;
                break;
            }
        }
        if (flag){return flag;}

        int left = 0;
        int right = s.length()-1;
        for (int i=0;i<s.length();i++) {
            flag =true;
            while (left < right) {
                if(left==i){left++;}
                if (s.charAt(left)!=s.charAt(right)){
                    flag = false;
                    break;
                }
                left++;
                right--;
                if (left == i) {
                    left++;
                }
                if (right==i){right--;}
            }
            if (flag){return flag;}
            left = 0;
            right = s.length()-1;
        }
        return flag;
    }

}


