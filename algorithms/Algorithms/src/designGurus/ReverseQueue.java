package designGurus;

import java.util.*;

public class ReverseQueue {
    /*Given the head of a singly linked list, return the head of the reversed list.
Example 1:   Input: [3, 5, 2]
    Expected Output: [2, 5, 3]
Example 2:   Input: [7]
    Expected Output: [7]
Example 3:   Input: [-1, 0, 1]
    Expected Output: [1, 0, -1]
     */

    /*
    Time complexity O(n)
    Space complexity O(n)
     */

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);

        Queue<Integer> q2 = new LinkedList<>();
//[7, 8, 9, 10, 11]
        q2.add(7);
        q2.add(8);
        q2.add(9);
        q2.add(10);
        q2.add(11);

        System.out.println(reverseQueue(q));
        System.out.println(reverseQueue(q2));
    }

    public static Queue<Integer> reverseQueue(Queue<Integer> q) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Integer current = q.peek();
        while ( current != null){
            stack.push(q.poll());
            current = q.peek();
        }

        while (stack.size()>0){
        q.add(stack.pop());
        }
        return q;
    }
}
