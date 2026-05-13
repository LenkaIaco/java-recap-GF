package leetcodeTop150.HLinkedList;

import java.util.*;

public class HRotateList {
    /*
    Given the head of a linked list, rotate the list to the right by k places.

Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Input: head = [0,1,2], k = 4
Output: [2,0,1]

Constraints:
The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 10^9
     */

    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0) {
            return head;
        }
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        List<ListNode> list = new ArrayList<>();
        while (current != null) {
            list.add(current);
            current = current.next;
        }
        int reduceK = k % list.size();
        if (reduceK == 0) {
            return head;
        }

        int newHeadIndex = list.size() - reduceK;
        ListNode newHead = list.get(newHeadIndex);
        ListNode oldTail = list.get(list.size() - 1);
        oldTail.next = head;
        ListNode newTail = list.get(newHeadIndex - 1);
        newTail.next = null;

        return newHead;
    }

    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode newTail = null;
        ListNode oldTail = null;
        ListNode curr = head;
        ListNode newHead = null;
        int counter = -1;

        while (curr!=null){
            counter++;
            oldTail = curr;
            curr = curr.next;
        }
        int listSize = counter + 1;
        int shifts = k % listSize;
        if (shifts==0){return head;}
        int newHeadInd = listSize-shifts;
            curr = head;
            counter = -1;
            while (curr!=null){
                counter++;
                if (counter == newHeadInd-1){newTail=curr;}
                if (counter==newHeadInd){
                    newHead = curr;
                }
                curr = curr.next;
            }


        oldTail.next = head;
        newTail.next=null;
        return newHead;
    }
}
