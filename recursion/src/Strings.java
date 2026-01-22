import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.Arrays;

public class Strings {
    public static void main(String[] args) {
        /**Task:
        // Given a string, write a recursive (no loops) method which returns
// a new string with the lowercase 'x' chars changed to 'y' chars.
*/
        System.out.println(xToY("luckx-duckx"));
        System.out.println(xToY("hexagon"));
        System.out.println(xToY("xx"));
    }

    public static String xToY(String s){
        if (s==null || s.length()==0) {return "";}
        if (s.charAt(0)=='x') {
            return "y".concat(xToY(s.substring(1)));
        }

        return String.valueOf(s.charAt(0)).concat(xToY(s.substring(1)));
    }

}
