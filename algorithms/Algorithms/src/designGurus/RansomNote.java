package designGurus;
import java.util.*;

public class RansomNote {
    /*
    Given two strings, one representing a ransom note and the another representing the available letters from
    a magazine, determine if it's possible to construct the ransom note using only the letters from the magazine.
    Each letter from the magazine can be used only once.
    Example:
    Input: Ransom Note = "hello", Magazine = "hellworld"
    Expected Output: true
    Input: Ransom Note = "notes", Magazine = "stoned"
    Expected Output: true
    Input: Ransom Note = "apple", Magazine = "pale"
    Expected Output: false
     Constraints:
    1 <= ransomNote.length, magazine.length <= 105
    ransomNote and magazine consist of lowercase English letters.
     */

    public static void main(String[] args) {
        System.out.println(canRansom("hellworld", "hello")); //exp.out.: true
        System.out.println(canRansom("stoned", "notes")); //exp.out.: true
        System.out.println(canRansom("pale", "apple")); //exp.out.: false

    }
    public static boolean canRansom(String magz, String note){
        if (magz.length() < note.length()) {
            return false;
        }
            Map<Character, Integer> magChCnt = new HashMap<>();


        for (int i=0;i<magz.length();i++){
            Integer count = magChCnt.get(magz.charAt(i));
            if (count == null){
                magChCnt.put(magz.charAt(i),1);
            } else{
                magChCnt.put(magz.charAt(i),count+1);
            }
        }

        for (int i=0;i<note.length();i++){
            Integer count = magChCnt.get(note.charAt(i));
            if (count ==null) {return false;}
            if (count == 0){return false;}
            else{
                magChCnt.put(note.charAt(i),--count);
            }
        }
        return true;
    }
}
