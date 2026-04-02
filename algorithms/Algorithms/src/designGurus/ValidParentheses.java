package designGurus;

public class ValidParentheses {
    /*
    Given a string s containing (, ), [, ], {, and } characters. Determine if a given string of parentheses is balanced.

A string of parentheses is considered balanced if every opening parenthesis has a corresponding closing parenthesis
in the correct order.

 Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
     */
    /*
    Time complexity O(n)
    Space complexity O(1)
     */
    public static void main(String[] args) {
        String s1 = "{[()]}";
        String s2 = "{[}]";
        String s3 = "(]";
        String s4 = "{[()]()}";

        System.out.println(parenthesesValid(s1));//true
        System.out.println(parenthesesValid(s2)); //false
        System.out.println(parenthesesValid(s3));//false
        System.out.println(parenthesesValid(s4));//true
    }
    public static boolean parenthesesValid(String s) {
        if (s.length()==1){return false;}
    int round =0;
    int curly =0;
    int square =0;

    for (int i=0;i<s.length();i++){
         if (s.charAt(i)=='('){round++;}
        else if (s.charAt(i)=='{'){curly++;}
        else if(s.charAt(i)=='['){square++;}
        else if(s.charAt(i)==')'){
            if (i>0){if (s.charAt(i-1)=='['||s.charAt(i-1)=='{'){return false;}}
            if (round>0){round--;}else{return false;}}
        else if(s.charAt(i)=='}'){
             if (i>0){if (s.charAt(i-1)=='['||s.charAt(i-1)=='('){return false;}}
            if (curly>0){curly--;}else{return false;}}
        else if(s.charAt(i)==']'){
             if (i>0){if (s.charAt(i-1)=='('||s.charAt(i-1)=='{'){return false;}}
            if (square>0){square--;}else{return false;}}
    }

    return round==0 && curly==0 && square==0;
    }

}
