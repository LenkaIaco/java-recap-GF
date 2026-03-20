package gf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubarrayDivision {
    /*
    Lily decides to share a segment of her chocolate bar such that:

    The length of the segment matches Ron's birth month, and,
    The sum of the integers on the squares is equal to his birth day.

    Determine how many ways she can divide the chocolate.

    Example
    int [] arr = {2,2,1,3,2};
    d=4, m=2

     */
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>(Arrays.asList(1,2,1)); //d3 m2, ex.out:2
        List<Integer> l1= new ArrayList<>(Arrays.asList(1,1,1,1,1,1)); // d3 m2 e.out:0
        List<Integer> l2= new ArrayList<>(Arrays.asList(4)); // d4 m1 e.out:1

        System.out.println(birthday(l,3,2));
        System.out.println(birthday(l1,3,2));
        System.out.println(birthday(l2,4,1));
    }

    public static int birthday(List<Integer> s, int d, int m) {
        if (s==null){return 0;}
        if (m>s.size()){return 0;}
        int counter =0;
        for (int i =0;i<s.size();i++){
            if(i+m-1>= s.size()){break;}
            int digitSum= 0;
            for (int y=i;y<i+m;y++){
               digitSum+= s.get(y);
            }
            if (digitSum==d){counter++;}
        }
        return counter;
    }
}
