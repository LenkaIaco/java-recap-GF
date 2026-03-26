package designGurus;
import java.util.Set;
import java.util.HashSet;

public class JewelsAndStones {
    /*
    Given two strings. The first string represents types of jewels, where each character is a unique type of jewel.
The second string represents stones you have, where each character represents a type of stone.
Determine how many of the stones you have are also jewels.
Example:
    Input: Jewels = "abc", Stones = "aabbcc"
    Expected Output: 6
     */
    /*
    Time Complexity O(m+n) for n = jewels and stones iteration (whichever longer) --> O(n)
    Space complexity O(n) for jewels HashSet
     */

    public static void main(String[] args) {
        String jewels = "abc";
        String stones = "aabbcc";
        System.out.println(countJewels(jewels,stones));//exp.out: 6
    }

    public static int countJewels(String jewels, String stones){
        if (jewels==null||stones==null){return -1;}
        if(jewels.length()==0 || stones.length()==0){return 0;}
        int counter = 0;
         Set<Character> jewelSet = new HashSet<>();
         for (int i=0;i<jewels.length();i++){
             jewelSet.add(jewels.charAt(i));
         }

         for(int i=0;i<stones.length();i++){
             if(jewelSet.contains(stones.charAt(i))){
                 counter++;
             }
         }
         return counter;
    }
}
