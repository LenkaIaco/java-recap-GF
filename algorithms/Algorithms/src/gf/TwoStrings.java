package gf;

public class TwoStrings {
    //https://www.hackerrank.com/challenges/two-strings
    /*
    Given two strings, determine if they share a common substring. A substring may be as small as one character.

Example: "and" "art"
These share the common substring "a"

twoStrings() has the following parameter(s):
    string s1,string s2
    s1 and s2 consist of characters in the range ascii[a-z].

Returns
    string: either YES or NO
     */
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 ="world";

        String s3 ="hi";
        String s4 = "world";

        System.out.println(twoStrings(s1, s2));
        System.out.println(twoStrings(s3, s4));
    }

    public static String twoStrings(String s1, String s2){
        if (s1==null||s2==null||s1.isEmpty()||s2.isEmpty()){return "NO";}
        for (int i =0; i<s1.length();i++){
            for (int y=i;y<s1.length();y++){
                String sub = s1.substring(i,y+1);
                if (s2.contains(sub)){
                    return "YES";
                }
            }
        }
        return "NO";
    }
}
