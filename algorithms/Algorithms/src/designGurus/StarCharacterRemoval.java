package designGurus;
import java.sql.Array;
import java.util.*;
public class StarCharacterRemoval {
     /*
    Given a string s, where * represents a star. We can remove a star along with its closest non-star character
    to its left in a single operation.

    The task is to perform as many such operations as possible until all stars have been removed and return
    the resultant string:
        Input: "abc*de**f"
        Expected Output: "abf"
     Constraints:
        1 <= s.length <= 105
        s consists of lowercase English letters and stars *.
        The operation above can be performed on s.
     */

    /*
    Time complexity O(n)
    Space complexity O(m)
     */
     public static void main(String[] args) {
         System.out.println(removeStarChars( "abc*de**f"));//exp.out.: "abf"
     }
    public static String removeStarChars(String s){
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int counter = 0;
        for (int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='*'){counter++;}
            else {
                if(counter==0){
                    stack.push(s.charAt(i));
                }else{
                    counter--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int size = stack.size();
        for (int i=0;i<size;i++){
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
