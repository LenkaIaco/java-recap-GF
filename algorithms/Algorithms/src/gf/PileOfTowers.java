package gf;

import java.util.Arrays;

public class PileOfTowers {
//    https://www.codewars.com/kata/61044b64704a9e0036162a1f
    /*
     there is a pile of n towels. A towel either has the color red or blue
     Whenever I grab a new one it's always the towel at the top of the pile(in array, rightmost)
     When re-washed, clean towels are placed on the pile again, the blue towels always on top of the red ones.

     An Example
If there are n=5 towels, a pile may be:
blue, red, blue, red, blue
If I grab t=3 towels during the week, this will be the remaining pile at the end of the week:
blue, red
After re-washing, the pile is:blue, red, red, blue, blue


Your Task: Sort the Pile
You are given an initial pile of towels as a sequence of the strings "red" and "blue".
On top of that, you receive a sequence of non-negative integers.
The first integer describes the number of used towels t in the first week,
the second integer describes the number of used towels t in the second week and so forth.

My question is: How will my pile of towels look like in the end
n = total towels
t = towels used/concrete week
It is ensured that 0 <= t <= n
     */
public static void main(String[] args) {
    System.out.println(Arrays.toString(sortingTowels(new String[] {"blue", "red", "blue", "red", "blue"} , new int[]{3}))); //"blue", "red", "red", "blue", "blue"
    System.out.println(Arrays.toString(sortingTowels(new String[] {"blue", "red", "blue", "red", "blue"} , new int[]{2, 1, 4, 2}))); //"blue", "red", "red", "blue", "blue"
}


public static String[] sortingTowels(String[]towels, int[]takes){
    if (towels==null||takes==null){return null;}
    if (towels.length==0||takes.length==0){return towels;}

     for (int i=0;i<takes.length;i++){
         int currentTakes = takes[i];
         String[] currTowels = new String[currentTakes];
         int redIndex = 0;
         int blueIndex = currTowels.length-1;
        for (int y=0;y<currentTakes;y++){
            String towel = towels[towels.length-1-y];
            if(towel.equals("blue")){
                currTowels[blueIndex]=towel;
                blueIndex--;
            }else {
                currTowels[redIndex] = towel;
                redIndex++;
            }
        }
        for (int z=0;z<currTowels.length;z++){
            int towelIndexFromBack = towels.length-currTowels.length+z;
            towels[towelIndexFromBack]=currTowels[z];
        }
     }
     return towels;
}

}
