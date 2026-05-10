package leetcodeTop150.GStack;

import java.util.*;

public class AValidParentheses {
    /*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.

Input: s = "()"  Output: true
Input: s = "()[]{}"  Output: true
Input: s = "(]"  Output: false
Input: s = "([])"  Output: true
Input: s = "([)]"  Output: false

Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
     */
    public static void main(String[] args) {
       String s = "()";
       String s1 = "()[]{}";
       String s2 = "(]";
       String s3 = "([])";
       String s4 = "([)]";

        System.out.println(isValid(s)); //true
        System.out.println(isValid(s1)); //true
        System.out.println(isValid(s2)); //false
        System.out.println(isValid(s3)); //true
        System.out.println(isValid(s4)); //false
    }
    public static boolean isValid(String s) {

        Deque<Character> openPars = new ArrayDeque<>();

        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                openPars.push(s.charAt(i));
            } else if(s.charAt(i)==')'){
                Character curr = openPars.isEmpty() ? null : openPars.peek();
                if (curr==null || curr!='('){
                    return false;
                } else{openPars.pop();}
            } else if (s.charAt(i)==']'){
                Character curr = openPars.isEmpty() ? null : openPars.peek();
                if (curr==null||curr!='['){return false;} else{openPars.pop();}
            } else if (s.charAt(i)=='}'){
                Character curr = openPars.isEmpty() ? null : openPars.peek();
                if (curr == null || curr!='{'){return false;} else{openPars.pop();}
            }
        }

        return openPars.isEmpty();
    }
}
