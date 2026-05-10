package leetcodeTop150.EHashmap;
import java.util.*;
public class CWordPattern {
    /*
Given a pattern and a string s, find if s follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern
and a non-empty word in s. Specifically:
Each letter in pattern maps to exactly one unique word in s.
Each unique word in s maps to exactly one letter in pattern.
No two letters map to the same word, and no two words map to the same letter.

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Explanation:
'a' maps to "dog".
'b' maps to "cat".

Input: pattern = "abba", s = "dog cat cat fish"
Output: false

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false

Constraints:
1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lowercase English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.
     */

    public static void main(String[] args) {
        System.out.println(wordPattern("abba","cat dog dog cat"));    //true
        System.out.println(wordPattern("abba","cat dog dog fish"));  //false
        System.out.println(wordPattern("aaaa","cat dog dog cat"));    //false
        System.out.println(wordPattern("aaaa","aa aa aa aa"));    //false
    }

    public static boolean wordPattern(String pattern, String s) {
    String[] words = s.split(" ");
    if (words.length!=pattern.length()){return false;}
    Map<Character, String> map = new HashMap<>();
    for (int i=0;i<pattern.length();i++){
        char c = pattern.charAt(i);
        String word = map.get(pattern.charAt(i));
        if (word==null){
            if (map.values().contains(words[i])){
                return false;
            }else{
                map.put(pattern.charAt(i),words[i]);
            }
        }else{
            if (!word.equals(words[i])){
                return false;
            }
        }
    }
    return true;
    }
}
