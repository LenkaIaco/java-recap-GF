package designGurus;

public class MinimumParentheses {
    /*
    Given a string str containing '(' and ')' characters, find the minimum number of parentheses that need
        to be added to a string of parentheses to make it valid.
        A valid string of parentheses is one where each opening parenthesis '(' has a corresponding closing
        parenthesis ')' and vice versa. The goal is to determine the least amount of additions needed to achieve
        this balance.
        "(()"; output 1
        "))(("; output 4
        "(()())("; output 1
        "((()))"; output 0
     */

    /*
    Time complexity O(n)
    Space complexity O(1)
     */
    public static void main(String[] args) {
        System.out.println(parenthesesToAdd("(()"));//ex.out.: 1
        System.out.println(parenthesesToAdd("))(("));//ex.out.: 4
        System.out.println(parenthesesToAdd( "(()())(")); //ex.out.: 1
        System.out.println(parenthesesToAdd("((()))"));//ex.out.: 0
    }
    public static int parenthesesToAdd(String s){
        int cCount = 0;
        int counter = 0;

        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==')') {
                if (cCount == 0) {
                    counter++;
                } else {
                    cCount--;
                }
            } else if(s.charAt(i)=='('){
                  cCount++;
                }
            }

        if (cCount>0){
            counter+=cCount;
        }
        return counter;
    }
}
