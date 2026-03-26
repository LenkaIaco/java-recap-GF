package designGurus;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    /*
    Given a string, determine the length of the longest palindrome that can be constructed using the characters from the string.
        Return the maximum possible length of the palindromic string.

        Input: "bananas"
         Output: 5

         Constraints:
            1 <= s.length <= 2000
            s consists of lowercase and/or uppercase English letters only.
         */

        /*
        Time complexity: O(n) iteration string and hashmap
         Space complexity: O(n) hashmap
     */
        public static void main(String[] args) {
            System.out.println(longestPalindrome("bananas")); //exp.out: 5
        }

        public static int longestPalindrome (String s){
            s = s.toLowerCase();
            Map<Character,Integer> counts = new HashMap<>();
            for (int i=0;i<s.length();i++){
                Integer count = counts.get(s.charAt(i));
                if (count==null){counts.put(s.charAt(i),1);
                } else {
                    counts.put(s.charAt(i),count+1);
                }
            }
            int length = 0;

            for (Map.Entry<Character,Integer> e :counts.entrySet()){
                if (e.getValue()>1){
                    int increase = e.getValue()/2;
                    length+=increase*2;
                    counts.put(e.getKey(),e.getValue()-increase);
                }
            }

            if(counts.values().contains(1)){length++;}

            return length;
        }
}
