import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JosephusProblem {
    /**
     * - What the hell is Josephus Problem?
     * Flavius Josephus was a famous historian of the first century. During the Jewish-Roman war, he was among a band of 41 Jewish rebels trapped in a cave by the Romans. Preferring suicide to capture, the rebels decided to kill themselves. Using a method to form a circle and in clockwise direction everybody kills the person on his left side until everyone dies. But Josephus, wanted none of this suicide nonsense and therefore quickly calculated where he should stand in the circle so that he will be the last one (he knew who is the first one). So basically Josephus Problem is when you have a circle of n people standing and you want to cross out every second person step-by-step until only one remains. for more detail check Josephus Problem on Wikipedia]
     * - Exercise
     * Write a function getWinningSeat (Java, JavaScript, TypeScript) / WinningSeat (C#), get_winning_seat (c++, python) to solve the Josephus Problem. The program should ask for a number which represents the number of people playing the "game". The return value should be the number of the "winning" seat.
     * - Examples
     * number of people	| number of the winning seat
     * 1	| 1
     * 2	| 1
     * 3	| 3
     * 7	| 7
     * 12	| 9
     * 41	| 19
     * - Solution:
     * - Input: Please enter the number of players:  12
     * - Output: The winning seat is 9
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of players:");
        int circleOfDeathSize = scan.nextInt();
        List<Integer> groupArray = new ArrayList<>();
        for (int i = 0; i < circleOfDeathSize; i++) {
            groupArray.add(i + 1);
        }
        System.out.println(groupArray);
        int loop = 0;
        while (groupArray.size() > 1) {

            {
                if (loop % 2 == 0) {
                    {List<Integer> intermediate = new ArrayList<>();
                        for (int j=0; j<groupArray.size();j+=2) {
                               intermediate.add( groupArray.get(j));
                            } groupArray = intermediate;
                    }
                } else if (loop % 2 != 0) {
                    List<Integer> intermediate = new ArrayList<>();
                        for (int j=1; j<groupArray.size();j+=2) {
                            intermediate.add( groupArray.get(j));
                        }groupArray = intermediate;
                }
                System.out.println(groupArray);
                loop = loop + 1;
            }
        }
        System.out.println("The survivor is number "+groupArray.get(0));


    }
}
