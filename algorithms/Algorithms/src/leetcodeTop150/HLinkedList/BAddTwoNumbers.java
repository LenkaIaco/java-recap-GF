package leetcodeTop150.HLinkedList;

import java.math.BigInteger;
import java.util.*;

public class BAddTwoNumbers {
    /*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Input: l1 = [0], l2 = [0]
Output: [0]

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
     */

    public static void main(String[] args) {
        ListNode l = new ListNode();        l.val = 9;
        ListNode l1 = new ListNode();        l1.val = 9;
        l.next = l1;

        ListNode lo = new ListNode();  lo.val = 9;

        ListNode result = addTwoNumbers2(l,lo);
        ListNode iter = result;
        while (iter!=null){
            System.out.println(iter.val);
            iter = iter.next;
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();

        ListNode current1 = l1;

        while (current1 != null) {
            stack1.push(current1.val);
            current1 = current1.next;
        }

        ListNode current2 = l2;
        while (current2 != null) {
            stack2.push(current2.val);
            current2 = current2.next;
        }

        String num1 = "";
        while (!stack1.isEmpty()) {
            num1 = num1 + String.valueOf(stack1.pop());
        }
        String num2 = "";
        while (!stack2.isEmpty()) {
            num2 = num2 + String.valueOf(stack2.pop());
        }

        BigInteger bi1 = new BigInteger(num1);
        BigInteger bi2 = new BigInteger(num2);

        BigInteger sum = bi1.add(bi2);

        String sumStr = String.valueOf(sum);

        ListNode head = new ListNode();
        ListNode curr = head;


        for (int i = sumStr.length() - 1; i >= 0; i--) {
            Integer val = Integer.valueOf(sumStr.substring(i, i + 1));
            curr.val = val;
            if (i > 0) {
                ListNode nextLN = new ListNode();
                curr.next = nextLN;
                curr = nextLN;
            }
        }
        return head;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int remainder = 0;
        ListNode sumHead = new ListNode();
        ListNode sumCurr = sumHead;
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        while (curr1!=null&&curr2!=null){
            int sumLastDigit = (curr1.val+curr2.val+remainder) % 10;
             remainder = (curr1.val+curr2.val+remainder) / 10;
            sumCurr.val = sumLastDigit;
            curr1 = curr1.next;
            curr2 = curr2.next;
            if (curr1!=null&&curr2!=null){
                ListNode newLN = new ListNode();
                sumCurr.next = newLN;
                sumCurr= sumCurr.next;
            }
        }


       if (curr1!=null){
            while (curr1!=null){
                int lastDigit = (remainder + curr1.val) %10;
                remainder = (remainder + curr1.val) / 10;
                ListNode newLN = new ListNode();
                newLN.val= lastDigit;
                sumCurr.next = newLN;
                sumCurr = sumCurr.next;
                curr1=curr1.next;
            }
        } else if (curr2!=null){
           while (curr2!=null) {
               int lastDigit = (remainder + curr2.val) % 10;
               remainder = (remainder + curr2.val) / 10;
               ListNode newLN = new ListNode();
               newLN.val = lastDigit;
               sumCurr.next = newLN;
               sumCurr = sumCurr.next;
               curr2 = curr2.next;
           }
       }
            if (remainder!=0){
                ListNode ln = new ListNode();
                ln.val = remainder;
                sumCurr.next = ln;
            }

       return sumHead;
    }
}
//                ListNode newLN = new ListNode();
//                newLN.val= remainder;
//                sumCurr.next = newLN;