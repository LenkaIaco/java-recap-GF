package leetcodeTop150.EHashmap;

import java.util.HashSet;
import java.util.Set;

public class GHappyNumber {
    /*
Write an algorithm to determine if a number n is happy.
A happy number is a number defined by the following process:
Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Input: n = 19
Output: true
Explanation:
1 + 81 = 82
64 + 4 = 68
36 + 64 = 100
1 + 0 + 0 = 1

Input: n = 2
Output: false


Constraints:
1 <= n <= 231 - 1
     */
    public static void main(String[] args) {
        System.out.println(isHappy2(19));//true
        System.out.println(isHappy2(2));//false
        System.out.println(isHappy2(7));//true
    }
    public static boolean isHappy(int n) {

        String nS = String.valueOf(n);
        boolean repeats = false;
        Set<Integer> prevs = new HashSet<>();
        while(!repeats){
            int sum = 0;
            for (int i=0;i<nS.length();i++){
                Integer intg = Integer.valueOf(nS.substring(i,i+1));
                sum+=intg*intg;
            }
            if (sum==1){return true;}
            if (!prevs.contains(sum)){
                prevs.add(sum);
            } else{repeats=true;}
            nS = String.valueOf(sum);
        }

        return Integer.valueOf(nS)==1;
    }

    public static boolean isHappy2(int n){
        Set<Integer> previous = new HashSet<>();
        while (n!=1&&!previous.contains(n)){
            previous.add(n);
            int sum = 0;
            while (n>0) {
                int digit = n % 10;
                sum += digit * digit;
                n/=10;
            }
           n = sum;
        }
        return n==1;
    }
}
