package designGurus;

import javax.print.DocFlavor;
import java.util.ArrayDeque;

public class ReverseString {
    /*
            Given a string, write a function that uses a stack to reverse the string.
            The function should return the reversed string.
     */

    /*
    Time complexity O(n)
    Space complexity  O(n)
     */

    public static void main(String[] args) {
        String s = "akneL";
        String s2 = "smhtirogla";
        System.out.println(reverseString(s));
        System.out.println(reverseString(s2));
    }

    public static String reverseString(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        int stackSize = stack.size();
        char[] charArray = new char[stackSize];
        for (int i = 0; i < stackSize; i++) {
            charArray[i] = stack.pop();
        }
        return String.valueOf(charArray);
    }
}
