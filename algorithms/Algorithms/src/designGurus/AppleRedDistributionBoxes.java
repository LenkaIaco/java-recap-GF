package designGurus;

import java.util.Arrays;
import java.util.Comparator;

public class AppleRedDistributionBoxes {
      /*
        --- SORTING ---
        You are given an array apple of size n, where the apple[i] represents the number of apples in ith pack.
        You are also given an array capacity of size m, where capacity[j] is a number of apples that can be stored
         in the jth box.
        Return the minimum number of boxes you need to use to put these all n packs of apples into boxes.
        Note: You are allowed to distribute apples from the same pack into different boxes.
        Examples
            Input: apple = [4, 5, 6], capacity = [5, 10]
            Expected Output: 2
            Input: apple = [2, 3, 1], capacity = [4, 2, 5, 1]
            Expected Output: 2
        Constraints:
            1 <= n == apple.length <= 50
            1 <= m == capacity.length <= 50
            1 <= apple[i], capacity[i] <= 50
            The input is generated such that it's possible to redistribute packs of apples into boxes.
         */

    /*
    Time complexity: O(nlogn) + O(n) + O(m) (Arrays.sort() + n: apples.length + m: boxes.length)
Space complexity: O(1)
     */
    public static void main(String[] args) {
        int [] apples = {2,3,1};
        int [] boxCapacities = {4, 2, 5, 1};
        int [] boxCapacities2 = {7};
        int [] apples3 = {4,5,6};
        int [] boxCapacities3 = {5,10};
        System.out.println(distributeApples(apples, boxCapacities)); // expected output: 2
        System.out.println(distributeApples(apples, boxCapacities2)); // expected output: 1
        System.out.println(distributeApples(apples3, boxCapacities3)); // expected output: 2
    }

    public static int distributeApples(int[] apples, int[]boxes){
        int allApples = 0;
        for (int i=0;i<apples.length;i++){
            if (apples[i]<0){apples[i]=0;}
            allApples+=apples[i];
        }
        Arrays.sort(boxes);
        int counter=0;
        for (int i=boxes.length-1;i>=0;i--){
            if (boxes[i]<0){boxes[i]=0;}
            allApples-=boxes[i];
            counter++;
            if (allApples<=0){return counter;}
        }

        return counter;
    }

}
