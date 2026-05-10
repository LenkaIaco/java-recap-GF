package leetcodeTop150.AArrayString;

import java.util.*;

public class JHIndex {
    /*
----------------
What is h-index?
Return the maximum n that matches the rule 'count n >= n':
"At least h papers have at least h citations":

[5]
does 5 get cited in >= 5 papers? No
...
does 1 get cited in >= 1 papers? Yes

H index: 1

 [3,0,6,1,5]

h	Need ≥ h citations	Do we have it?
0   0th paper ≥  yes
1	1 paper ≥ 1	yes (6)
2	2 papers ≥ 2	yes (6,5)
3	3 papers ≥ 3	yes (6,5,3)
4	4 papers ≥ 4	no (only 2 papers ≥ 4)

h‑index = 3.
----------------
Given an array of integers citations where citations[i] is the number of citations a researcher received
for their ith paper, return the researcher's h-index.

The h-index is defined as the maximum value of h such that the given researcher has published at least h papers
that have each been cited at least h times.

Examples:
Input: citations = [3,0,6,1,5]
Output: 3
Input: citations = [1,3,1]
Output: 1
     */

    /*
    Time complexity O(n^2)
    Space complexity  O(1)
     */
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        int[] citations1 = {1, 3, 1};
        int[] citations2 = {1, 0, 0};
        int[] citations3 = {100};
        int[] citations4 = {0, 0, 2};
        System.out.println(hIndex(citations));//3
        System.out.println(hIndex(citations1));//1
        System.out.println(hIndex(citations2));//1
        System.out.println(hIndex(citations3));//1
        System.out.println(hIndex(citations4));//1
    }

    public static int hIndex(int[] citations) {
        if (citations == null) {
            return 0;
        }
        if (citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int hCandidate = 0;
        for (int i = 0; i < citations.length; i++) {
            int untilEnd = citations.length - i;
            if (citations[i] <= untilEnd) {
                hCandidate = citations[i];
            }
        }

        int minimumH = citations.length;
        int minCount = 0;
        while (minimumH > 0) {
            if (minCount >= minimumH) {
                return minimumH;
            }
            minCount=0;
            for(int i = citations.length-1;i>=0;i--){
                if (minCount >= minimumH) {
                    return minimumH;
                }
                if (citations[i]>=minimumH){
                    minCount++;
                }
                else {
                        minimumH--;
                        break;
                }
            }
        }

        return Integer.max(hCandidate, minimumH);
    }
}