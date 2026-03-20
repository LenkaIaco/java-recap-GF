package gf;

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
the selection cursor rotates horizontally but not vertically; that means that if I'm in the leftmost and I try to go left again
I'll get to the rightmost and vice versa from rightmost to leftmost.
Instead, if I try to go further up from the upmost or further down from the downmost, I'll just stay where I am located
Output

the list of characters who have been hovered by the selection cursor after all the moves
(ordered and with repetition, all the ones after a move, whether successful or not, see tests);

     */
    public static void main(String[] args) {
        String[][]  fighters = {
                {"Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega"},
                {"Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison"}
        };

        String[] moves = {"up", "left", "right", "left", "left"};
        String[] moves2 = {"right", "down", "left", "left", "left", "left", "right", "up"};

//  exp.out:['Ryu', 'Vega', 'Ryu', 'Vega', 'Balrog']
        System.out.println(characterPath(fighters, moves));

// exp.out: ['E.Honda', 'Chun Li', 'Ken', 'M.Bison', 'Sagat', 'Dhalsim', 'Sagat', 'Balrog']
        System.out.println(characterPath(fighters, moves2));
    }

    public static List<String> characterPath(String[][] selection, String[] moves){
        List<String> visited = new ArrayList<>();
        int row = 0;
        int col = 0;

        for (int i = 0; i<moves.length; i++){

        if (moves[i].equals("up")){
        if (row == 1) {row = 0;}
        }
        else if (moves[i].equals("down")){
            if (row ==0){row=1;}
        }
        else if (moves[i].equals("right")){
            if (col==selection[0].length-1){col=0;}
            else {col+=1;}
        }
        else if(moves[i].equals("left")){
            if (col==0){col=selection[0].length-1;}
            else {col-=1;}
        }
        visited.add(selection[row][col]);
        }
        return visited;

    }

}
