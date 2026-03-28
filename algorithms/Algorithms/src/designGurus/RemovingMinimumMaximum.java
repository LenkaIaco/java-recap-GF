package designGurus;

public class RemovingMinimumMaximum {
    /* Determine the minimum number of deletions required to remove the smallest and the largest elements
        from an array of integers.
        In each deletion, you are allowed to remove either the first (leftmost) or the last (rightmost)
        element of the array.
           Input: [3, 2, 5, 1, 4]  Output: 3
            [7, 5, 6, 8, 1] Output: 2
            Input: [2, 4, 10, 1, 3, 5]  Output: 4
        Constraints:
            1 <= nums.length <= 105
            -105 <= nums[i] <= 105
            The integers in nums are distinct.
         */

    /*
    Time complexity O(n) to identify min/max in arr
    Space complexity O(1) created constants(in size) -> do not scale w input
     */

    public static void main(String[] args) {
        System.out.println(minDeletions(new int[]{3,2,5,1,4})); //exp.out.: 3
        System.out.println(minDeletions(new int[]{2,4,10,1,3,5}));//exp.out.:4
    }

    public static int minDeletions(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        int max = arr[0];
        int maxIndex = 0;
        int min = arr[0];
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }

        int maxDist = determineDist(maxIndex, arr);
        int minDist = determineDist(minIndex, arr);
        int mutualDist = 0;
        if (maxIndex > minIndex) {
            mutualDist = maxIndex - minIndex;
        } else {
            mutualDist = minIndex - maxIndex;
        }


        int counter = 0;

        if (mutualDist < maxDist || mutualDist < minDist) {

            if (minDist < maxDist) {
                counter += counterIncreaseIndependent(minIndex, arr.length);
                counter += mutualDist;
            } else {
                counter += counterIncreaseIndependent(maxIndex, arr.length);
                counter += mutualDist;
            }
        } else {
            counter += counterIncreaseIndependent(maxIndex, arr.length);
            counter += counterIncreaseIndependent(minIndex, arr.length);
        }
        return counter;
    }


    public static int counterIncreaseIndependent(int index, int arrLength) {
        int counter = 0;
        if (index < arrLength / 2) {
            counter = index+1;
        } else {
            counter = arrLength - index;
        }
        return counter;
    }

    public static int determineDist(int index, int[] arr) {
        int dist = 0;
        if (index >= arr.length / 2) {
            dist = arr.length - 1 - index;
        } else {
            dist = index;
        }
        return dist;
    }

}
