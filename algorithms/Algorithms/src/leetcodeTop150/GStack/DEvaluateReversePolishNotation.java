package leetcodeTop150.GStack;
import java.util.*;
public class DEvaluateReversePolishNotation {
    /*
You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
Evaluate the expression. Return an integer that represents the value of the expression.

Note that:
The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.

Input: tokens = ["2","1","+","3","*"]   Output: 9

Input: tokens = ["4","13","5","/","+"]   Output: 6

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22

Constraints:
1 <= tokens.length <= 104
tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
     */
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        String[] tokens1 = {"4","13","5","/","+"};
        String[] tokens2 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

        System.out.println(evalRPN(tokens)); //9
        System.out.println(evalRPN(tokens1)); //6
        System.out.println(evalRPN(tokens2)); //22
    }

    public static int evalRPN(String[] tokens) {
        Deque<Integer> numStack = new ArrayDeque<>();
        for (int i=0;i<tokens.length;i++){
            if (tokens[i].equals("+")){
                int second = Integer.valueOf(numStack.pop());
                int first = Integer.valueOf(numStack.pop());
                numStack.push(first+second);
            }else if (tokens[i].equals("-")){
                int second = Integer.valueOf(numStack.pop());
                int first = Integer.valueOf(numStack.pop());
                numStack.push(first-second);
            } else if (tokens[i].equals("*")){
                int second = Integer.valueOf(numStack.pop());
                int first = Integer.valueOf(numStack.pop());
                numStack.push(first*second);
            } else if (tokens[i].equals("/")){
                int second = Integer.valueOf(numStack.pop());
                int first = Integer.valueOf(numStack.pop());
                numStack.push(first/second);
            }
            else {
                numStack.push(Integer.valueOf(tokens[i]));}
        }
        return numStack.pop();
    }
}
