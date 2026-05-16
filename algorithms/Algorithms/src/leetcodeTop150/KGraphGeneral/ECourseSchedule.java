package leetcodeTop150.KGraphGeneral;
import java.util.*;
public class ECourseSchedule {
    /*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates
that you must take course bi first if you want to take course ai.
For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.


Constraints:
1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites==null){return false;}
        if (prerequisites.length==0){return true;}
        List<List<Integer>> prereqList = new ArrayList<>();
        for (int i=0;i<numCourses;i++){
            prereqList.add(new ArrayList<>());
        }

        //fill each prereq's course list:
        for (int i=0;i<prerequisites.length;i++){
            int prereq = prerequisites[i][1];
            List<Integer> courseList = prereqList.get(prereq);
            courseList.add(prerequisites[i][0]);
        }

        /* walk each prereq's path up to the last course ->prereq -> prereq's prereq -> ... route
        to realize if they contain any loops = impossible paths to finish */
        // utilize helper state array(already walked path markers): 0 unwalked, 1 currently walking 2 walked previously successfully(without loops)
        int[] pathMarkers = new int[numCourses];

        for (int i=0;i<pathMarkers.length;i++){
            if (pathMarkers[i]==0){
                if (isPathCycling(prereqList,pathMarkers, i)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isPathCycling(List<List<Integer>> prereqList, int[] pathMarkers, int listIndex){
        if (pathMarkers[listIndex]==1){return true;} //we have been here already during current walk

        if (pathMarkers[listIndex]==2){return false;}
        pathMarkers[listIndex]=1;

        for (Integer i: prereqList.get(listIndex)){
            if (isPathCycling(prereqList,pathMarkers,i)){
                return true;
            }
        }
        pathMarkers[listIndex]=2;
        return false;
    }
}
