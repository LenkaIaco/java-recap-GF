package gf;

public class ValidParentheses {
    //https://www.codewars.com/kata/52774a314c2333f0a7000688
    /*
Write a function that takes a string of parentheses, and determines
if the order of the parentheses is valid.
The function should return true if the string is valid, and false if it's invalid.

Examples
"()"              =>  true
")(()))"          =>  false
"("               =>  false
"(())((()())())"  =>  true

Along with opening (() and closing ()) parenthesis, input may contain any valid ASCII characters.
Furthermore, the input string may be empty and/or not contain any parentheses at all.
Do not treat other forms of brackets as parentheses (e.g. [], {}, <>).
     */
    public static void main(String[] args) {
        String s = "()";
        String s1 =  ")(()))";
        String s2 = "(";
        String s3 = "(())((()())())";

        System.out.println(validParentheses(s));// exp. true
        System.out.println(validParentheses(s1)); // exp. false
        System.out.println(validParentheses(s2));// exp. false
        System.out.println(validParentheses(s3));// exp. true
    }

    public static boolean validParentheses(String s) {
        if (s == null) {
            return false;
        }
        if (s.isEmpty()) {
            return false;
        }
        if (s.length() == 1) {
            return false;
        }

        int openings = 0;
        int closings = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openings++;
            } else if (s.charAt(i) == ')') {
                if (openings > 0) {
                    openings--;
                } else {
                    return false;
                }
            }
        }
        return openings > 0 ? false : true;
    }
}
