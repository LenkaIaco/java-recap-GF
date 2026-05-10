package leetcodeTop150.FIntervals;

import java.util.*;

public class BMergeIntervals {
    /*
    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
    and return an array of the non-overlapping intervals that cover all the intervals in the input.
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
Example 3:

Input: intervals = [[4,7],[1,4]]
Output: [[1,7]]
Explanation: Intervals [1,4] and [4,7] are considered overlapping.

Constraints:
1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
     */

    /*
    Time complexity O(n^2) sorting
    Space complexity O(n) new array
     */
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals1 = {{1, 4}, {4, 5}};
        int[][] intervals2 = {{4, 7}, {1, 4}};

        System.out.println(Arrays.deepToString(merge(intervals)));//[[1,6],[8,10],[15,18]]
        System.out.println(Arrays.deepToString(merge(intervals1)));//[[1,5]]
        System.out.println(Arrays.deepToString(merge(intervals2)));//[1,7]]
    }

    public static int[][] merge(int[][] intervals) {

        for (int i = 0; i < intervals.length - 1; i++) {
            for (int y = i + 1; y < intervals.length; y++) {
                if (intervals[i][0] > intervals[y][0]) {
                    int[] placeholder = intervals[y];
                    intervals[y] = intervals[i];
                    intervals[i] = placeholder;
                } else if (intervals[i][0] == intervals[y][0]) {
                    if (intervals[i][1] > intervals[y][1]) {
                        int[] placeholder = intervals[y];
                        intervals[y] = intervals[i];
                        intervals[i] = placeholder;
                    }
                }
            }
        }

        List<int[]> l = new ArrayList<>();

        if (intervals.length > 1) {
            for (int i = 0; i < intervals.length; i++) {
                if (l.size() > 0) {
                    int[] last = l.get(l.size() - 1);
                    if (last[1] >= intervals[i][0] || last[0] == intervals[i][0]) {
                        int end = Integer.max(last[1],intervals[i][1]);
                        l.set(l.size()-1, new int[]{last[0],end});
                    } else {
                        l.add(intervals[i]);
                    }
                } else {
                    l.add(intervals[i]);
                    }
                }
            }

        int[][] result = new int[l.size()][2];
        int rows = 0;
        for (int[] arr : l) {
            result[rows] = arr;
            rows++;
        }

        return intervals.length>1 ? result : intervals;
    }
}
