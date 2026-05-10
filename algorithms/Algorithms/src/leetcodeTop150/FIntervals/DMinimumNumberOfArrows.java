package leetcodeTop150.FIntervals;

public class DMinimumNumberOfArrows {
    /*
 There are some spherical balloons taped onto a flat wall that represents the XY-plane.
 The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes
 a balloon whose horizontal diameter stretches between xstart and xend.
 You do not know the exact y-coordinates of the balloons.
Arrows can be shot up directly vertically (in the positive y-direction) from different points
along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend.
There is no limit to the number of arrows that can be shot.
A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
Given the array points, return the minimum number of arrows that must be shot to burst all balloons.

Examples:
Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2

Input: points = [[1,2],[3,4],[5,6],[7,8]]
Output: 4

Input: points = [[1,2],[2,3],[3,4],[4,5]]
Output: 2

Constraints:
1 <= points.length <= 105
points[i].length == 2
-231 <= xstart < xend <= 231 - 1
     */

    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        int[][] points1 = {{1,2},{3,4},{5,6},{7,8}};
        int[][] points2 = {{1,2},{2,3},{3,4},{4,5}};
        int[][] points3 = {{77171087,133597895},{45117276,135064454},{80695788,90089372},
                {91705403,110208054},{52392754,127005153},{53999932,118094992},{11549676,55543044},
                {43947739,128157751},{55636226,105334812},{69348094,125645633}};

        System.out.println(findMinArrowShots(points)); //2
        System.out.println(findMinArrowShots(points1)); //4
        System.out.println(findMinArrowShots(points2)); //2
        System.out.println(findMinArrowShots(points3)); //3
    }

    public static int findMinArrowShots(int[][] points) {

        if (points.length>105)
    for (int i = 0; i<points.length;i++){
        for (int y= i+1; y< points.length;y++){
            if (points[i][0]>points[y][0]){
                int[] placeholder = points[i];
                points[i]=points[y];
                points[y]= placeholder;
            } else if (points[i][0]==points[y][0]){
                if (points[i][1]>points[y][1]){
                    int[] placeholder = points[i];
                    points[i]=points[y];
                    points[y]= placeholder;
                }
            }
        }
    }

    int counter = 0;
    int overlapStart = -1;
    int overlapEnd = -1;
        for (int i=0;i< points.length;i++){
                if (i != points.length - 1) {
                    if (overlapStart == -1) {
                        if (points[i][1] >= points[i + 1][0] && points[i][1] <= points[i + 1][1]
                                ||
                                points[i + 1][1] >= points[i][0] && points[i + 1][1] <= points[i][1]
                        ) {
                            overlapStart = Math.min(points[i][1], points[i + 1][0]);
                            overlapEnd = points[i][1] > points[i + 1][0] ? Math.min(points[i][1], points[i + 1][1]) : points[i + 1][0];
                        } else {
                            counter++;
                        }
                    } else {
                        if (overlapEnd >= points[i + 1][0] && overlapEnd <= points[i + 1][1]
                                ||
                                points[i + 1][1] >= overlapStart && points[i + 1][1] <= overlapEnd
                        ) {
                            overlapStart = Math.max(overlapStart, points[i+1][0]);
                            overlapEnd = Math.min(overlapEnd, points[i+1][1]);
                        } else {
                            counter++;
                            overlapStart = -1;
                            overlapEnd = -1;
                        }
                    }
                }else { counter++;}
        }

        return counter;
    }
}
