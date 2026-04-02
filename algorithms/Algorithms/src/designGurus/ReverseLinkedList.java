package designGurus;

import java.util.*;

public class ReverseLinkedList {
    /*
     Given the head of a singly linked list, return the head of the reversed list.
    Input: [3, 5, 2]
    Output: [2, 5, 3]
     */
    /*
    Time complexity reverseDirect():  O(n)
    Space complexity reverseDirect(): O(1)

    Time complexity reverseIndirect(): O(n)
    Space complexity reverseIndirect(): O(n)
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(3);
        ListNode next3 = new ListNode(4);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        ListNode currIndirect = reverseIndirect(head);
        String result = "";
        while (currIndirect != null) {
            result = result + currIndirect.val + ", ";
            currIndirect = currIndirect.next;
        }
        result = result.substring(0, result.length() - 2);
        System.out.println(result);


        ListNode headDir = new ListNode(1);
        ListNode next1Dir = new ListNode(2);
        ListNode next2Dir = new ListNode(3);
        ListNode next3Dir = new ListNode(4);
        headDir.next = next1Dir;
        next1Dir.next = next2Dir;
        next2Dir.next = next3Dir;
        ListNode currDirect = reverseDirect(headDir);
        String result2 = "";
        while (currDirect != null) {
            result2 = result2 + currDirect.val + ", ";
            currDirect = currDirect.next;
        }
        result2 = result2.substring(0, result2.length() - 2);
        System.out.println(result2);
    }


        public static ListNode reverseDirect (ListNode head){
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }



    public static ListNode reverseIndirect(ListNode head) {
        List<Integer> l = new ArrayList<>();

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            l.add(curr.val);
            prev = curr;
            curr = curr.next;
        }

        int lastInd = l.size() - 1;
        int firstInd = 0;

        while (lastInd > firstInd) {
            int last = l.get(lastInd);
            l.set(lastInd, l.get(firstInd));
            l.set(firstInd, last);
            lastInd--;
            firstInd++;
        }

        ListNode head2 = new ListNode(l.get(0));
        ListNode current = head2;
        for (int i = 1; i < l.size(); i++) {
            current.next = new ListNode(l.get(i));
            current = current.next;
        }

        return head2;
    }
}
