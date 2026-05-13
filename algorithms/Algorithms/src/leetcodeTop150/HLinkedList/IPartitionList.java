package leetcodeTop150.HLinkedList;

public class IPartitionList {
    /*
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes
greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.

Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
Explanation: make two lists: less than x [1,2,2] and same or greater than x [4,3,5]
Then concatenate

Input: head = [2,1], x = 2
Output: [1,2]

Constraints:
The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200
     */

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {return head;}

        ListNode smallHead = null;
        ListNode smallCurr = null;
        ListNode bigHead = null;
        ListNode bigCurr = null;

        ListNode curr = head;

        while (curr != null) {
            if (curr.val<x){
                if (smallHead==null){
                    smallHead = new ListNode();
                    smallHead.val = curr.val;
                    smallCurr = smallHead;
                } else{
                    ListNode newSmall = new ListNode();
                    newSmall.val = curr.val;
                    smallCurr.next = newSmall;
                    smallCurr = smallCurr.next;
                }
            } else{
                if (bigHead == null){
                    bigHead = new ListNode();
                    bigHead.val = curr.val;
                    bigCurr = bigHead;
                } else{
                    ListNode newBig = new ListNode();
                    newBig.val = curr.val;
                    bigCurr.next = newBig;
                    bigCurr = bigCurr.next;
                }
            }
            curr = curr.next;
        }

        if (smallHead==null){
            return bigHead;
        }
        if (bigHead==null){return smallHead;
        }
        smallCurr.next = bigHead;

        return smallHead;
    }
}
