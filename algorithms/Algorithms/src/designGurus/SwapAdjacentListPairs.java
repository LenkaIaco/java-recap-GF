package designGurus;

import java.util.List;

public class SwapAdjacentListPairs {
    /*
    Given a singly linked list, swap every two adjacent nodes and return the head of the modified list.
If the total number of nodes in the list is odd, the last node remains in place.
Every node in the linked list contains a single integer value.

Input: [1, 2, 3, 4]
Output: [2, 1, 4, 3]
Justification: Pairs (1,2) and (3,4) are swapped.

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
     */

    /*
    Time Complexity O(n)
    Space Complexity O(1)
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next = new ListNode(2);
        head.next = next;
        ListNode next1 = new ListNode(3);
        next.next = next1;
        ListNode next2 = new ListNode(4);
        next1.next = next2;
        ListNode result = swapAdjacent(head);
        ListNode current = result;
        while(current!=null){
            System.out.print(current.val);
            current = current.next;
            if (current!=null){
                System.out.print(", ");
            }
        }

    }
    public static ListNode swapAdjacent(ListNode head){
        if(head==null){return head;}
        ListNode futureHead = head.next;
        ListNode prev = null;
        ListNode current = head;
        ListNode next = head.next;
        while (current!=null&&next!=null){
            ListNode temp = next.next;
            current.next = temp;
            next.next = current;
            if (prev!=null){
                prev.next = next;
            }
            prev = current;
            current = temp;
            if (current==null){break;}
            next = temp.next;
        }

        return futureHead;
    }
}
