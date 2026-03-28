package designGurus;

public class RemoveDuplicatesSortedList {
    /*
    Given a sorted linked list, remove all the duplicate elements to leave only distinct numbers.
    The linked list should remain sorted, and the modified list should be returned.
    Input: 1 -> 2 -> 2 -> 3
    Output: 1 -> 2 -> 3
    Constraints:

    The number of nodes in the list is in the range [0, 300].
    -100 <= Node.val <= 100
    The list is guaranteed to be sorted in ascending order.
     */
    /*
    Time complexity O(n)
    Space complexity O(1)
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(2);
        ListNode next3 = new ListNode(3);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;

       ListNode result = deleteDuplicates(head);
       ListNode current = result;
        System.out.print(current.val);
        current = current.next;
       while(current!=null){
           System.out.print(", " + current.val );
           current = current.next;
       }
    }

    public static ListNode deleteDuplicates(ListNode head){
        if (head==null){return null;}
        if (head.next==null){return head;}
        ListNode prev = head;
        ListNode curr = head.next;
        while(curr!=null){
            if (prev.val==curr.val){
                ListNode saveNext = curr.next;
                prev.next = saveNext;
                curr = prev.next;
            } else{
                prev = prev.next;
                curr = curr.next;
            }
        }
        return head;
    }
}
