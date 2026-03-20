package gf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareTheTriplets {
    //https://www.hackerrank.com/challenges/compare-the-triplets
    /*
    a = alice scores per round
    b = bob's scores per round
    a = [1, 2, 3]
b = [3, 2, 1]

For round *0*, Bob is awarded a point because a[0] < b[0].
For the equal elements a[1] and b[1], no points are earned.
Finally, for elements 2, a[2] > b[2] so Alice receives a point.
The return array is [1, 1] with Alice's score first and Bob's second.

     */
    public static void main(String[] args) {
        List<Integer> alice = new ArrayList<>(Arrays.asList(5, 6, 7));
        List<Integer> bob = new ArrayList<>(Arrays.asList(3,6,10));
        System.out.println(compareTriplets(alice,bob)); //ex.result {1,1}
    }

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    if (a == null || b == null) {return null;}
    if (a.size()!=b.size() || a.size()==0) {return new ArrayList<>();}

    List<Integer> results = new ArrayList<>(List.of(0,0));

    for (int i=0; i<a.size();i++){
        int aBefore = results.get(0);
        int bBefore =results.get(1);

        if (a.get(i)>b.get(i)){results.set(0,++aBefore);}
        else if (b.get(i)>a.get(i)){results.set(1,++bBefore);}
    }

    return results;
    }
}
