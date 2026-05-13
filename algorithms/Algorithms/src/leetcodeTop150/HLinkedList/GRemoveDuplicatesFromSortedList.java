package leetcodeTop150.HLinkedList;
import java.util.*;
public class GRemoveDuplicatesFromSortedList {
    /*
Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list. Return the linked list sorted as well.
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
Input: head = [1,1,1,2,3]
Output: [2,3]

Constraints:
The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
     */

    public static void main(String[] args) {
        ListNode one = new ListNode();
        one.val = 1;
        ListNode two = new ListNode();
        two.val = 2;
        ListNode three = new ListNode();
        three.val = 3;
        ListNode four = new ListNode();
        four.val = 3;
        one.next = two;
        two.next = three;
        three.next = four;

        ListNode result = deleteDuplicates(one);
        while (result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if (head==null){return null;}
        if(head.next==null){return head;}
        ListNode curr = head;
        Set<Integer> dupes = new HashSet<>();
        Deque<ListNode> stack = new ArrayDeque<>();
        while (curr!=null){
            if(dupes.isEmpty()){
                ListNode currCopy = new ListNode();
                currCopy.val = curr.val;
                if (!stack.isEmpty()){
                    stack.peek().next = currCopy;
                }
                    stack.push(currCopy);
                    dupes.add(currCopy.val);
                    curr = curr.next;
            } else{
                if (dupes.contains(curr.val)){
                    if (!stack.isEmpty()&&stack.peek().val==curr.val){
                        stack.pop();
                        if (!stack.isEmpty()){stack.peek().next = null;}
                    }
                    curr = curr.next;
                } else{
                    ListNode currCopy = new ListNode();
                    currCopy.val = curr.val;
                    if (!stack.isEmpty()){stack.peek().next = currCopy;}
                    stack.push(currCopy);
                    dupes.add(curr.val);
                    curr = curr.next;
                }
            }
        }

        return stack.isEmpty() ? null : stack.getLast();
    }



    }
