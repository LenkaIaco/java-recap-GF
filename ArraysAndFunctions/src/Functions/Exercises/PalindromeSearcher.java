package Functions.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromeSearcher {
    public static void main(String[] args) {
//        Create a function named search() following your current language's style guide.
//        It should take a string, search for palindromes of length at least 3 within it and return them in an array.
//
//        Hint: create a function named isPalindrome() which takes a string as an input and returns true/false depending on
//        whether the string is a palindrome or not.

        System.out.println(Arrays.toString(search("lalala heleh")));
//        System.out.println(searchP("lalala heleh"));


    }

    public static String[] search(String s) {
        List<String> palindromes = new ArrayList<>();
        for (int i = 0; i < s.length() - 3; i++) {
            for (int y = i + 2; y < s.length(); y++) {
                int x1 = i;
                int x2 = y;
                boolean isPalindrome = false;
                while (x1 < x2) {
                    if (s.charAt(x1) == s.charAt(x2)) {
                        isPalindrome = true;
                        x1++;
                        x2--;
                    } else {
                        isPalindrome = false;
                        break;
                    }
                }

                if (isPalindrome) {
                    palindromes.add(s.substring(i, y + 1));
                }

            }
        }

        String[] strings = palindromes.toArray(new String[0]);
        return strings;
    }


}
