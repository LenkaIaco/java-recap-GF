package designGurus;
import java.util.*;
public class MeetingRooms {
    /*
    Problem Statement
Given an array of meeting intervals where intervals[i] = [starti, endi], return the minimum number of meeting rooms
needed so that no meetings overlap.

Examples
Example 1:
Input: intervals = [[10, 15], [20, 25], [30, 35]]
Expected Output: 1
Justification: There are no overlapping intervals in the given list. So, only 1 meeting room is enough for all the meetings.
Example 2:
Input: intervals = [[10, 20], [15, 25], [24, 30], [5, 14], [22, 28], [1, 4], [27, 35]]
Expected Output: 3
Justification: Let's see how many meetings overlap at the same time:
[1, 4] starts first.
Then [5, 14] begins, no overlap yet.
[10, 20] overlaps with [5, 14]
[15, 25] overlaps with [10, 20]
[22, 28] overlaps with [15, 25]
[24, 30] overlaps with both [22, 28] and [15, 25]
[27, 35] overlaps with [24, 30]
Example 3:
Input: intervals = [[10, 20], [20, 30]]
Expected Output: 1
Justification: The end time of the first meeting is the same as the start time of the second meeting.
So, one meeting can be scheduled right after the other in the same room.
Constraints:

1 <= intervals.length <= 104
0 <= starti < endi <= 106
     */
    /*
    Time complexity O(n^2) for array sorting + O(n*2) for iteration
    Space complexity O(n) for List<Integer[]>
     */
    public static void main(String[] args) {
        int[][] arr = {{10, 15}, {20, 25}, {30, 35}};
        int[][] arr1 = {{10, 20}, {15, 25}, {24, 30}, {5,14}, {22,28}, {1,4}, {27,35}};
        System.out.println(countMeetingRooms(arr));//exp.out.: 1
        System.out.println(countMeetingRooms(arr1));//exp.out.: 3
    }

 public static int countMeetingRooms(int[][]intervals){
     int counter = 0;
     List<Integer[]> rooms = new ArrayList<>();

     intervals = sortArray(intervals);

     for (int i=0;i<intervals.length;i++){
         if (rooms.isEmpty()){
             rooms.add(new Integer[]{intervals[i][0],intervals[i][1]});
             counter++;
         } else{
             boolean flag = false;
             for (int y=0;y<rooms.size();y++){
                 Integer[] room = rooms.get(y);
                 if (intervals[i][0]>room[1]){
                     flag = true;
                     rooms.set(y,new Integer[]{intervals[i][0],intervals[i][1]});
                     break;
                 }
             }
             if (!flag){
                 rooms.add(new Integer[]{intervals[i][0],intervals[i][1]});
                 counter++;
             }
         }
     }
     return counter;
 }

public static int[][] sortArray(int[][] intervals){
    for (int i=0;i< intervals.length-1;i++) {
        for (int y = i + 1; y < intervals.length; y++) {
            int[] current = intervals[i];
            int[] next = intervals[y];
            if (current[0] > next[0]) {
                intervals[i] = next;
                intervals[y] = current;
            } else if (current[0] == next[0]) {
                if (current[1] > next[1]) {
                    intervals[i] = next;
                    intervals[y] = current;
                }
            }
        }
    }
    return intervals;
}

}
