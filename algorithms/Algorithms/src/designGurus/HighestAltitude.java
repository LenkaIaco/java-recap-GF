package designGurus;

public class HighestAltitude {
    /*
     A bike rider is going on a ride. The road contains n + 1 points at different altitudes.
     The rider starts from point 0 at an altitude of 0
Given an array of integers gain of length n, where gain[i] represents the net gain in altitude between points
i and i + 1 for all (0 <= i < n), return the highest altitude of a point.

Examples
Example 1
Input: gain = [-5, 1, 5, 0, -7]
Expected Output: 1
Justification: The altitude changes are [-5, -4, 1, 1, -6], where 1 is the highest altitude reached.
Example 2
Input: gain = [4, -3, 2, -1, -2]
Expected Output: 4
Justification: The altitude changes are [4, 1, 3, 2, 0], where 4 is the highest altitude reached.
     */

    /*
    Time complexity O(n) for n= input array length
    Space complexity O(1) for variables altitude and max
     */
    public static void main(String[] args) throws IllegalArgumentException{
int[] gain1 = {-5, 1, 5, 0, -7};
int[] gain2 ={4, -3, 2, -1, -2};

        System.out.println(maxAltitudeReached(gain1)); //exp. out.: 1
        System.out.println(maxAltitudeReached(gain2)); //exp. out.: 4
    }

    public static int maxAltitudeReached(int[] arr) throws IllegalArgumentException{
        if(arr==null){throw new IllegalArgumentException("Invalid array"); }
        if (arr.length==0){throw new IllegalArgumentException("Invalid array");}
        int altitude = 0;
        int max = altitude;

        for(int i=0;i<arr.length;i++){
             altitude = altitude + arr[i];
            if (max<altitude){max = altitude;}
        }
        return max;
    }
}
