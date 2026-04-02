package designGurus;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
public class SortVowels {
    /*
    Given a string s, return an updated string t such that all consonants in the string s stay in their original
positions while any vowels in the string are reordered according to their ASCII values.
The vowels are 'A', 'E', 'I', 'O', and 'U'. These vowels can appear in lowercase or uppercase.
All other letters except vowels are consonants.
Examples
    Input: "gamE"
    Expected Output: "gEma"
    Justification: The vowels in "gamE" are 'a' and 'E'. Sorting these by ASCII values, 'E' comes before 'a'.
Constraints:
    1 <= s.length <= 105
    s consists only of letters of the English alphabet in uppercase and lowercase.
     */

    /*
    Time complexity O(n) (because sorting of ascii chars will always work with same-sized array even if input grows)
    Space complexity O(n)
     */

    public static void main(String[] args) {
    String s = "gamE";
        System.out.println(orderVowelsASCII(s));//exp.out.: "gEma"
    }


    public static String orderVowelsASCII(String s){
        if (s.length()==1){return s;}
        Map<Integer,Integer> vowelsCounts = new HashMap<>();
        String vowls = "aeiouAEIOU";
        for (int i=0;i<vowls.length();i++){
            vowelsCounts.put((int)vowls.charAt(i),0);
        }

        for (int i=0;i<s.length();i++){
            Integer count = vowelsCounts.get((int)s.charAt(i));
            if (count!=null){
                vowelsCounts.put((int)s.charAt(i),count+1);
            }
        }

        List<Integer> asciiSorted = new ArrayList<>(vowelsCounts.keySet());
        asciiSorted.sort(Comparator.naturalOrder());
        char[] sCh = s.toCharArray();
        for (int i=0;i<sCh.length;i++){
            if (vowelsCounts.containsKey((int)sCh[i])) {
                for (int y=0;y<asciiSorted.size();y++){
                    Integer replaceCount = vowelsCounts.get(asciiSorted.get(y));
                    if (replaceCount>0){
                        sCh[i]=(char)asciiSorted.get(y).intValue();
                        vowelsCounts.put(asciiSorted.get(y),replaceCount-1);
                        break;
                    }
                }
            }
        }
        return String.valueOf(sCh);
    }
}
