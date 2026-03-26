package designGurus;

import java.util.*;

public class LargestPalindromeNumber {
    /*
       Given a string s containing 0 to 9 digits, create the largest possible palindromic number using the
        string characters. It should not contain leading zeroes. A palindromic number reads the same backward
        as forward.
        If it's not possible to form such a number using all digits of the given string, you can skip some of them.
       Input: s = "323211444" Expected Output: "432141234"
       Input: s = "998877" Expected Output: "987789"
       Input: s = "54321" Expected Output: "5"

       Constraints:
           1 <= num.length <= 105
            num consists of digits.
     */

    /*
    Time complexity
        O(nlogn) sorting + O(n) helper iterations +
        O(n) stringbuilder multiples appending has condition-only inner loop:
            considered a constant, as times it runs for i's:
            are based on a fixed(shared) amount of i multiples/2
            are running only sometimes(conditional, not always)
    Space complexity O(n) stringbuilder, helper array, HashMap
     */

    public static void main(String[] args) {
        String s = "323211444";
        String s1 = "998877";
        String s2 = "54321";
        System.out.println(largestPalindrome(s)); //exp.out:  "432141234"
        System.out.println(largestPalindrome(s1)); //exp.out:  "987789"
        System.out.println(largestPalindrome(s2)); //exp.out:  "5"
    }

    public static String largestPalindrome(String s){
        if (s==null){return null;}
        if(s.length()==0){return s;}

        StringBuilder sb = new StringBuilder();

        Map<Character,Integer> counts = countChars(s);
        int[] nums =charsToNums(s);
        Arrays.sort(nums);

        if (nums[nums.length-1]==0){return "";}

        for (int i=nums.length-1;i>=0;i--){
            char c = String.valueOf(nums[i]).charAt(0);
            int count = counts.get(c);
            int multiples = count/2;
            if (multiples>0){
                for (int y=0;y<multiples;y++){
                    sb.append(nums[i]);
                }
            }
            int remainder = count - multiples*2;
            counts.put(c, remainder);
        }

        int palindromeIndex = sb.length()-1;
        for (int i=nums.length-1;i>=0;i--){
            char c = String.valueOf(nums[i]).charAt(0);
           int remainder =  counts.get(c);
           if (remainder >0){
               sb.append(nums[i]);
               break;
           }
        }

        for (int i=palindromeIndex;i>=0;i--){
            sb.append(sb.charAt(i));
        }
        return sb.toString();
    }

    public static int[] charsToNums(String s){
        int[] nums = new int[s.length()];
        for (int i=0;i<s.length();i++){
            nums[i] = Integer.valueOf(String.valueOf(s.charAt(i)));
        }
        return nums;
    }

    public static Map<Character, Integer> countChars(String s){
        Map<Character,Integer> counts = new HashMap<>();

        for (int i = 0;i<s.length();i++){
            Integer count = counts.get(s.charAt(i));
            if (count==null){
                counts.put(s.charAt(i),1);
            }else{
                counts.put(s.charAt(i),count+1);
            }
        }
        return counts;
    }

}
