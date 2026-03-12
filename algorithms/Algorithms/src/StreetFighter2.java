import java.util.ArrayList;
import java.util.List;

public class StreetFighter2 {
    //https://www.codewars.com/kata/5853213063adbd1b9b0000be
    /*
    Selection Grid Layout:
| Ryu  | E.Honda | Blanka  | Guile   | Balrog | Vega    |
| Ken  | Chun Li | Zangief | Dhalsim | Sagat  | M.Bison |

Input
the list of game characters in a 2x6 grid;
the initial position of the selection cursor (top-left is (0,0));
a list of moves of the selection cursor (which are up, down, left, right);

Selection cursor is circular horizontally but not vertically!

Output

the list of characters who have been hovered by the selection cursor after all the moves
(ordered and with repetition, all the ones after a move, whether successful or not, see tests);
     */
    public static void main(String[] args) {
        String[][]  fighters = {
                {"Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega"},
                {"Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison"}
        };


    }

    public static String characterPath(String[][] selection, String[] moves){
        List<String> visited = new ArrayList<>();

        
        for (int i = 0; i<moves.length; i++){
        if (moves[i].equals("up")||moves[i].equals("down")){

        }
        }

    }
}
