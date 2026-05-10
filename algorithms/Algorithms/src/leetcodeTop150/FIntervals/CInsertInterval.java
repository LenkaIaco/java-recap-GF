package leetcodeTop150.FIntervals;

import java.util.*;

public class CInsertInterval {
    /*
    You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi]
    represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
    You are also given an interval newInterval = [start, end] that represents the start and end
     of another interval.
Insert newInterval into intervals such that intervals is still sorted in ascending order by starti
and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
Return intervals after the insertion.
Note that you don't need to modify intervals in-place. You can make a new array and return it.

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]

Constraints:
0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105
     */
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        int[][] intervals1 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval1 = {4, 8};

        System.out.println(Arrays.deepToString(insert(intervals, newInterval))); // [[1,5],[6,9]]
        System.out.println(Arrays.deepToString(insert(intervals1, newInterval1))); //[[1, 2], [3, 10], [12, 16]]
        System.out.println(Arrays.deepToString(insert2(intervals, newInterval))); // [[1,5],[6,9]]
        System.out.println(Arrays.deepToString(insert2(intervals1, newInterval1))); //[[1, 2], [3, 10], [12, 16]]

    }

//    public static int[][] insert(int[][] intervals, int[] newInterval) {
//
//        if (intervals.length==0) return new int[][]{newInterval};
//
//        List<int[]> container = new ArrayList<>();
//        container.add(intervals[0]);
//        boolean added = false;
//        for (int i = 0; i < intervals.length; i++) {
//            if (added) {
//                int[] current = container.get(container.size() - 1);
//                if (intervals[i][0] > current[1]){
//                    container.add(intervals[i]);
//                } else{
//                    int first = current[0];
//                    int second = Integer.max(current[1], intervals[i][1]);
//                    container.set(container.size()-1, new int[]{first, second});
//                }
//            } else {
//                int[] current = container.get(container.size() - 1);
//                if (newInterval[1] < current[0]) {
//                    container.set(container.size() - 1, newInterval);
//                    container.add(current);
//                    added = true;
//                } else {
//                    if (newInterval[0] > current[1]) {
//                        container.add(current);
//                        added = true;
//                    } else {
//                        int first = Math.min(newInterval[0], current[0]);
//                        int second = Math.max(newInterval[1], current[1]);
//                        container.set(container.size() - 1, new int[]{first, second});
//                        added = true;
//                    }
//                }
//            }
//        }
//
//        int[][] result = new int[container.size()][2];
//        int index = 0;
//        for (int[] arr : container) {
//            result[index] = arr;
//            index++;
//        }
//        return result;
//    }


    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int first = newInterval[0];
        int second = newInterval[1];

        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        //overlap anything check
        int firstI = -1;
        Set<Integer> overlaps = new HashSet<>();

        int addAfter = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (first >= intervals[i][0] && first <= intervals[i][1]
                    ||
                    second >= intervals[i][0] && second <= intervals[i][1]
                    ||
                    intervals[i][0] >= first && intervals[i][0] <= second
                    ||
                    intervals[i][1] >= first && intervals[i][1] <= second
            ) {
                overlaps.add(i);
                if (firstI == -1) {
                    firstI = i;
                }
            }
            if (i != intervals.length - 1 && newInterval[0] > intervals[i][1] && newInterval[1] < intervals[i + 1][0]) {
                addAfter = i;
            }
        }

        //no overlaps handling
        List<int[]> resultIntervals = new ArrayList<>();
        if (overlaps.isEmpty()) {
            if (newInterval[1] < intervals[0][0]) {
                resultIntervals.add(newInterval);
            } else if (newInterval[0] > intervals[intervals.length - 1][1]) {
                addAfter = intervals.length - 1;
            }
        }

        // merge intervals incl overlaps
        for (int i = 0; i < intervals.length; i++) {
            if (overlaps.contains(i)) {
                int firstCand = Integer.min(intervals[i][0], newInterval[0]);
                int secondCand = Math.max(intervals[i][1], newInterval[1]);
                if (i == firstI) {
                    resultIntervals.add(new int[]{firstCand, secondCand});
                } else {
                    int[] last = resultIntervals.get(resultIntervals.size() - 1);
                    int candLast1 = Math.min(last[0], firstCand);
                    int candLast2 = Math.max(last[1], secondCand);
                    resultIntervals.set(resultIntervals.size() - 1, new int[]{candLast1, candLast2});
                }
            } else {
                resultIntervals.add(new int[]{intervals[i][0], intervals[i][1]});
            }

            if (i == addAfter) {
                resultIntervals.add(newInterval);
            }
        }

        return listToDeepArray(resultIntervals);
    }


    public static int[][] insert2(int[][] intervals, int[] newInterval) {

        if (intervals.length==0){return new int[][]{newInterval};}
        int startI = 0;

        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] > intervals[i][0]) {
                startI = i + 1;
            }
        }

        List<int[]> inclNew = new ArrayList<>();
        for (int i = 0; i < startI; i++) {
            inclNew.add(intervals[i]);
        }
        inclNew.add(newInterval);
        for (int i=startI;i<intervals.length;i++){
            inclNew.add(intervals[i]);
        }

        //merge newInterval+overlaps

        List<int[]> result = new ArrayList<>();

        for (int i=0;i<inclNew.size();i++){
            if (i>=startI){
                int[] lastAdded = result.isEmpty() ? null : result.get(result.size()-1);
                if (lastAdded==null){
                    result.add(inclNew.get(i));
                } else{
                    if (lastAdded[1]>=inclNew.get(i)[0]&&lastAdded[1]<=inclNew.get(i)[1]
                            ||
                            inclNew.get(i)[1]>=lastAdded[0]&&inclNew.get(i)[1]<=lastAdded[1]
                    ) {
                        int addFirst = Math.min(lastAdded[0], inclNew.get(i)[0]);
                        int addLast = Math.max(lastAdded[1], inclNew.get(i)[1]);
                        result.set(result.size()-1,new int[]{addFirst, addLast});
                    } else{
                        result.add(inclNew.get(i));
                    }
                }
            }
            else{result.add(inclNew.get(i));}
        }
        return listToDeepArray(result);
    }


    public static int[][] listToDeepArray(List<int[]> input) {
        int[][] output = new int[input.size()][2];

        for (int i = 0; i < output.length; i++) {
            output[i] = input.get(i);
        }
        return output;
    }
}
