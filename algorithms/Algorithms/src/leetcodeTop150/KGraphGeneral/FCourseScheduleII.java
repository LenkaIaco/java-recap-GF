package leetcodeTop150.KGraphGeneral;

import java.util.*;

public class FCourseScheduleII {
    /*
There are a total of numCourses courses you have to take, labeled from 0 to (numCourses - 1).
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi
first if you want to take course ai.
For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses.
If there are many valid answers, return any of them. If it is impossible to finish all courses,
return an empty array.

Examples:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

Input: numCourses = 1, prerequisites = []
Output: [0]


Constraints:
1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.
     */
    public static void main(String[] args) {
        int[][] prerequisites = {{1,0}};
        int [] result = findOrder(2, prerequisites);
        System.out.println(Arrays.toString(result));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites==null){return new int[0];}
        if (prerequisites.length==0){
            int[] result = new int[numCourses];
            for (int i=0;i<numCourses;i++){
                result[i]=i;
            }
            return result;
        }

        /*we need to create a list that mimics int[][] prerequisities, but with size of numCourses.
        That way, if numcourses > prerequisities.length, courses without prerequisities will not be omitted
         by the recursive function and get added into the result
         */
        List<List<Integer>> prereqList = new ArrayList<>();
        for (int i=0;i<numCourses;i++){
            prereqList.add(new ArrayList<>());
        }

        //fill each prereq's course list:
        for (int i=0;i<prerequisites.length;i++){
            int course = prerequisites[i][0];
            List<Integer> prereqL = prereqList.get(course);
            prereqL.add(prerequisites[i][1]);
        }

        /* walk each prereq's path up to the last course ->prereq -> prereq's prereq -> ... route
        to realize if they contain any loops = impossible paths to finish */
        // utilize helper state array(already walked path markers): 0 unwalked, 1 currently walking 2 walked previously successfully(without loops)
        int[] pathMarkers = new int[numCourses];
        List<Integer> resultList = new ArrayList<>();
        int start = -1;
        for (int i=0;i<pathMarkers.length;i++){
            start = i;
            if (pathMarkers[i]==0){
                if (isPathCycling(prereqList,pathMarkers, i, resultList)){
                    return new int[0];
                }
            }
        }
        int[] result =new int[0];

        if (start !=-1){
            result = resultList.stream().mapToInt(Integer::intValue).toArray();
            }
        return result;
    }

    public static boolean isPathCycling(List<List<Integer>> prereqList, int[] pathMarkers, int i, List<Integer> result){
        if (pathMarkers[i]==1){return true;} //we have been here already during current walk

        if (pathMarkers[i]==2){return false;}
        pathMarkers[i]=1;
        List<Integer> currPrereq = prereqList.get(i);
        if (!currPrereq.isEmpty()) {
            if (isPathCycling(prereqList, pathMarkers, prereqList.get(i).get(0), result)) {
                return true;
            }
        }
        pathMarkers[i]=2;
        result.add(i);
        return false;
    }
}
