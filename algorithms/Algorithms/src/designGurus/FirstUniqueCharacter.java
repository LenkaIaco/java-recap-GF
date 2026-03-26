package designGurus;
import java.sql.Time;
import java.util.*;

public class FirstUniqueCharacter {
    /* Given a string, identify the position of the first character that appears only once in the string.
    If no such character exists, return -1.

    Example 1: "apple" Output: 0
    Constraints:
    1 <= s.length <= 105
    s consists of only lowercase English letters.
     */

    /*
    Time complexity O(n) where n = string's length
    Space complexity O(n) for HashMap creation
     */
    public static void main(String[] args) {
        String appleString = "apple";
        System.out.println(uniqueIndexFirst(appleString));  // result: 0
    }

    public static int uniqueIndexFirst(String s){
        Map<Character, Integer> charCount = new HashMap<>();

        for(int i=0;i<s.length();i++){
            Integer currCount = charCount.get(s.charAt(i));
            if (currCount==null){
                charCount.put(s.charAt(i),1);
            }else{
                charCount.put(s.charAt(i),currCount+1);
            }
        }

        for (int i=0;i<s.length();i++){
            Integer currCount = charCount.get(s.charAt(i));
            if(currCount==1){return i;}
        }

        return -1;
    }

}
