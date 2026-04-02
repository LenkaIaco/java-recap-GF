package designGurus;

import java.util.*;

public class StackSorting {
    /*
Given a stack, sort it using only stack operations (push and pop).

You can use an additional temporary stack, but you may not copy the elements into any other data structure
(such as an array). The values in the stack are to be sorted in descending order, with the largest elements on top.
 - Constraints: N/A
 - Example:
     Input: [34, 3, 31, 98, 92, 23]
     Output: [3, 23, 31, 34, 92, 98]
 */
    /*
    Time complexity: dominated by the 2D while loop: O(n*(n-1))->simplifies to O(n^2)
    Space complexity O(n)
     */
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = {34, 3, 31, 98, 92, 23};
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        try {
            Stack s = sortValues(stack);
            System.out.println(s);
        } catch (IllegalArgumentException e) {

            System.out.println("Missing input stack");
        }
    }

    public static Stack<Integer> sortValues(Stack<Integer> stack) throws IllegalArgumentException {
        if (stack == null) {
            throw new IllegalArgumentException("Input missing.");
        }
        Stack<Integer> aux = new Stack();
        Stack<Integer> result = new Stack();
        int min = Integer.MAX_VALUE;
        while (stack.size() > 0) {
            if (stack.size() == 1) {
                if (stack.peek() < min) {
                    result.push(stack.pop());
                    if (min != Integer.MAX_VALUE) {
                        aux.push(min);
                    }
                    min = Integer.MAX_VALUE;
                } else {
                    aux.push(stack.pop());
                    result.push(min);
                    min = Integer.MAX_VALUE;
                }
                while (aux.size() > 0) {
                    stack.push(aux.pop());
                }
            } else {
                if (stack.peek() < min) {
                    if (min != Integer.MAX_VALUE) {
                        aux.push(min);
                    }
                    min = stack.pop();
                } else {
                    aux.push(stack.pop());
                }
            }
        }

        return result;
    }
}
