package designGurus;

import java.util.*;

public class TwoListsIterator {
    /*
Given two 1d vectors, implement an iterator to return their elements alternately.

Implement the Solution class:

Solution(List<int> v1, List<int> v2) is a constructor.
int next() returns the current element of the iterator and moves the iterator to the next element.
boolean hasNext() returns true if the iterator still has elements, and false otherwise.

Constraints:

0 <= v1.length, v2.length <= 1000
1 <= v1.length + v2.length <= 2000
-231 <= v1[i], v2[i] <= 231 - 1
 */

    //see TwoListsSolution class
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1,3,5));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(2,4,6));

        TwoListsSolution tls = new TwoListsSolution(l1,l2);

        // Expected output: 1,2,3,4,5
        while (tls.hasNext()){
            System.out.print(tls.next());
            if (tls.hasNext()){
                System.out.print(", ");
            }
        }
    }
}
