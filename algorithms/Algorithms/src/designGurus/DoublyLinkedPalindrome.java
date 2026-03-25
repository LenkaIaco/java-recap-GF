package designGurus;

public class DoublyLinkedPalindrome {
    /*
     Given a doubly linked list, determine whether it is a palindrome.
    A doubly linked list is a palindrome if it reads the same backward as forward, utilizing the previous and next
    pointers of the nodes.

    Input: 1 <-> 2 <-> 3 <-> 2 <-> 1
    Output: true
     */

    /*
    Time complexity O(n) for length of Doubly linked list
    Space complexity O(1)
     */
    public static void main(String[] args) {
        DoublyLinkedNode last = new DoublyLinkedNode(1);
        DoublyLinkedNode mid = new DoublyLinkedNode(2);
        last.prev = mid;
        mid.next = last;
        DoublyLinkedNode first = new DoublyLinkedNode(1);
        first.next = mid;
        mid.prev = first;

        DoublyLinkedNode head = new DoublyLinkedNode(3);
        DoublyLinkedNode next1 = new DoublyLinkedNode(4);
        head.next = next1;
        next1.prev = head;
        DoublyLinkedNode next2= new DoublyLinkedNode(4);
        next1.next = next2;
        next2.prev = next1;
        DoublyLinkedNode next3 = new DoublyLinkedNode(3);
        next2.next = next3;
        next3.prev = next2;

        DoublyLinkedNode nonPalHead = new DoublyLinkedNode(0);
        DoublyLinkedNode nonPalNext1 =  new DoublyLinkedNode(5);
        DoublyLinkedNode nonPalNext2 =  new DoublyLinkedNode(5);
        DoublyLinkedNode nonPalNext3 =  new DoublyLinkedNode(9);
        DoublyLinkedNode nonPalNext4 =  new DoublyLinkedNode(10);

nonPalHead.next = nonPalNext1;
nonPalNext1.prev = nonPalHead;
nonPalNext1.next = nonPalNext2;
nonPalNext2.prev = nonPalNext1;
nonPalNext2.next = nonPalNext3;
nonPalNext3.prev = nonPalNext2;
nonPalNext3.next = nonPalNext4;
nonPalNext4.prev = nonPalNext3;



        System.out.println(isPalindrome(first)); //exp. out.: true
        System.out.println(isPalindrome(head)); //exp. out.: true
        System.out.println(isPalindrome(nonPalHead)); //exp. out.: false

    }

    public static boolean isPalindrome(DoublyLinkedNode head) {
        if (head == null) {
            return false;
        }
        DoublyLinkedNode forward = head.next;
        if (forward == null) {
            return false;
        }


        while (forward != null) {
            if (forward.next != null) {
                forward = forward.next;
            } else {
                break;
            }
        }

        DoublyLinkedNode currLast = forward;
        DoublyLinkedNode currFirst = head;

        while (currFirst != null) {
            if (currFirst.val != currLast.val) {
                return false;
            }
            currLast = currLast.prev;
            currFirst = currFirst.next;
        }

        return true;
    }

}
