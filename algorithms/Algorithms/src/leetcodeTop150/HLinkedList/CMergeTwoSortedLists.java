package leetcodeTop150.HLinkedList;

import java.util.List;

public class CMergeTwoSortedLists {
    /*
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list.
The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Input: list1 = [], list2 = []
Output: []
Input: list1 = [], list2 = [0]
Output: [0]

Constraints:
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
     */
    public static void main(String[] args) {
        ListNode lOne = new ListNode(); lOne.val = 1;
        ListNode lOne1 = new ListNode(); lOne1.val = 2;
        ListNode lOne2 = new ListNode(); lOne2.val = 4;
        lOne.next = lOne1;
        lOne1.next = lOne2;

        ListNode lTwo =new ListNode(); lTwo.val = 1;
        ListNode lTwo1 =new ListNode(); lTwo1.val = 3;
        ListNode lTwo2 =new ListNode(); lTwo2.val = 4;
        lTwo.next = lTwo1;
        lTwo1.next = lTwo2;

//        ListNode result =  mergeTwoLists(lOne, lTwo);
//        ListNode currPrint = result;
//        while(currPrint!=null){
//            System.out.println(currPrint.val);
//            currPrint = currPrint.next;
//        }

        ListNode l1 = new ListNode(); l1.val = 2;
        ListNode l2 = new ListNode(); l2.val = 1;
        ListNode result2 = mergeTwoLists(l1,l2);
        ListNode currPrint2 = result2;
        while(currPrint2!=null){
            System.out.println(currPrint2.val);
            currPrint2 = currPrint2.next;
        }
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode resultHead = new ListNode();
        ListNode current = resultHead;
        ListNode curr1 = list1;
        ListNode curr2 = list2;

        while (curr1 != null && curr2 != null) {
            if (current.next!=null){
                current.next.next = new ListNode();
                current = current.next.next;
            }
            current.val = curr1.val;
            current.next = new ListNode();
            current.next.val = curr2.val;

            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        if (curr1 != null) {
            current.next.next = new ListNode();
            current = current.next.next;
            while (curr1 != null) {
                current.val = curr1.val;
                curr1 = curr1.next;
                if (curr1!=null){
                    current.next = new ListNode();
                    current = current.next;
                }
            }
        } else if (curr2!=null){
            current.next.next = new ListNode();
            current = current.next.next;
            while (curr2!=null){
                current.val = curr2.val;
                curr2 = curr2.next;
                if (curr2!=null){
                    current.next = new ListNode();
                    current = current.next;
                }
            }
        }
        return resultHead;
    }
}
