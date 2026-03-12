import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalDifference {
    //https://www.hackerrank.com/challenges/diagonal-difference/problem
    /*
    Given a square matrix, calculate the absolute difference between the sums of its diagonals.
    1 2 3
    4 5 6
    9 8 9

    15-17 = - 2 -> 2
     */
    public static void main(String[] args) {
        List<List<Integer>> l1 = new ArrayList<>();
        l1.add(new ArrayList<>(Arrays.asList(1,2,3)));
        l1.add(new ArrayList<>(Arrays.asList(4,5,6)));
        l1.add(new ArrayList<>(Arrays.asList(9,8,9)));

        List<List<Integer>> l2 = new ArrayList<>();
        l2.add(new ArrayList<>(Arrays.asList(11,2,4)));
        l2.add(new ArrayList<>(Arrays.asList(4,5,6)));
        l2.add(new ArrayList<>(Arrays.asList(10,8,-12)));

        System.out.println(diagonalDifference(l1)); //exp.out: 2
        System.out.println(diagonalDifference(l2)); //ex. out: 15
        }

    public static int diagonalDifference(List<List<Integer>> arr) {
    int size = 0;
        if (arr==null) {return 0;}
        for (List l : arr){
            if (l == null) {return 0;}
        }
        //symmetric array check:
        size = arr.get(0).size();
        for (List l : arr){
            if (l.size()!=size || l.size()!=arr.size()){
                return 0;
            }
        }

        int diagCount1 = 0;
        int diagCount2 = 0;
        for(int i=0; i<arr.size();i++){
            int increment1 = arr.get(i).get(i);
            int secondIndex = arr.get(i).size()-1-i;
            int increment2 = arr.get(i).get(secondIndex);
        diagCount1+=increment1;
        diagCount2+=increment2;
        }

        int difference = diagCount1-diagCount2;

    return Math.abs(difference);
    }
}
