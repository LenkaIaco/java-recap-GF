package designGurus;

import java.util.*;

public class MergeTwoSortedLists {
    /*
    Given the head of two sorted linked lists, l1 and l2,
    return a new sorted list created by merging together the nodes of the first two lists.
    - Input:
            [1, 3, 5]
            [2, 4, 6]
            - Expected Output:
            [1, 2, 3, 4, 5, 6]

The linked list are a class ListNode containing
            the value
            the next reference
            constructors(empty, arg, args)

    Constraints:
    The number of nodes in both lists is in the range [0, 50].
            -100 <= Node.val <= 100
    Both list1 and list2 are sorted in non-decreasing order.
            */

    /*
    Time complexity O(n) (iteration of the whole listnode 1 and 2, whichever bigger wins the notation)
    Space complexity O(m+n) (arraylist of size l1+l2, arr[] of same size)
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode next1A = new ListNode(3);
        ListNode next1B = new ListNode(5);
        l1.next = next1A;
        next1A.next = next1B;

        ListNode l2 = new ListNode(2);
        ListNode next2A = new ListNode(4);
        ListNode next2B = new ListNode(6);
        l2.next = next2A;
        next2A.next = next2B;


        ListNode ln1 = new ListNode(1);
        ListNode ln1A = new ListNode(2);
        ListNode ln1B = new ListNode(3);
        ln1.next = ln1A;
        ln1A.next =ln1B;

        ListNode ln2 = new ListNode(4);
        ListNode ln2A = new ListNode(5);
        ListNode ln2B = new ListNode(6);
        ln2.next = ln2A;
        ln2A.next = ln2B;

        System.out.println(Arrays.toString(mergedList(l1,l2)));//exp.out  [1, 2, 3, 4, 5, 6]
        System.out.println(Arrays.toString(mergedList(l2,l1)));//exp.out  [1, 2, 3, 4, 5, 6]
        System.out.println(Arrays.toString(mergedList(ln1,ln2)));//exp.out  [1, 2, 3, 4, 5, 6]
    }

    public static int[] mergedList(ListNode l1, ListNode l2){
        List<Integer> l = new ArrayList<>();
        ListNode next1 = l1;
        ListNode next2= l2;
        while (next1!=null&&next2!=null){
            if (next1.val<next2.val){
                l.add(next1.val);
                next1 = next1.next;
            }
            else{
                l.add(next2.val);
                next2 = next2.next;
            }
        }

        if (next1!=null){
            while(next1!=null){
                l.add(next1.val);
                next1=next1.next;
            }
        }

        if (next2!=null){
            while(next2!=null){
                l.add(next2.val);
                next2=next2.next;
            }
        }

        int[] result = l.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }

}
