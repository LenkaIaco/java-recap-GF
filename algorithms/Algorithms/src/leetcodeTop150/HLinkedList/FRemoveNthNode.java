package leetcodeTop150.HLinkedList;

import java.util.*;

public class FRemoveNthNode {
    /*
    Given the head of a linked list, remove the nth node from the end of the list and return its head.

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Input: head = [1], n = 1
Output: []
Input: head = [1,2], n = 1
Output: [1]

Constraints:
The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
     */

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.val = 1;
        ListNode result = removeNthFromEnd(head, 1);
        ListNode curr = result;
        while (curr!=null){
            System.out.println(curr.val);
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        List<ListNode> ln = new ArrayList<>();
        ListNode curr = head;

        while (curr != null) {
            ln.add(curr);
            curr = curr.next;
        }

        int indexRemove = ln.size() - n;
        if (indexRemove - 1 >= 0) {
            if (indexRemove != ln.size() - 1) {
                ln.get(indexRemove - 1).next = ln.get(indexRemove + 1);
            } else {
                ln.get(indexRemove - 1).next = null;
            }
        }
        if (indexRemove == 0) {
            if (ln.size()>1) {
                head = ln.get(indexRemove + 1);
            } else {head = null;}
        }
        return head;
    }
}
