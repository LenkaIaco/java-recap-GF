package leetcodeTop150.HLinkedList;

import java.util.ArrayList;
import java.util.List;

public class EReverseLinkedListII {
    /*
Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes
of the list from position left to position right, and return the reversed list.

Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Input: head = [5], left = 1, right = 1
Output: [5]

Constraints:
The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
     */

    public static void main(String[] args) {
        ListNode ln = new ListNode();
        ListNode ln1 = new ListNode();
        ln.val = 3;
        ln1.val = 5;
        ln.next = ln1;

        ListNode result = reverseBetween(ln, 1,2);
        ListNode curr = result;
        while (curr!=null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
    public static  ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head;
        List<ListNode> l = new ArrayList<>();
        while (curr!=null){
            l.add(curr);
            curr = curr.next;
        }
        int start = left-1;
        int end = right-1;
        if (start-1>=0){
            ListNode before = l.get(start-1);
            before.next = l.get(end);
        } else{
            head = l.get(end);
        }

        if (end<l.size()-1){
            ListNode after = l.get(end+1);
            l.get(start).next = after;
        } else {
            l.get(start).next = null;
        }
        while (end>start){
            l.get(end).next = l.get(end-1);
            end--;
        }
        return head;
    }

}
