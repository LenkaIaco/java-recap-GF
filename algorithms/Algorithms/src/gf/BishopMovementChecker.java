package gf;

public class BishopMovementChecker {
//    https://www.codewars.com/kata/6135e4f40cffda0007ce356b
    /*
    Your job given a bishop's start position (pos1 / startPos) find if the end position (pos2 / endPos) given is possible within n moves.
INPUT :
startPos (1st param) ==> The position at which bishop is at
endPos   (2nd param) ==> The position at which he is supposed to end at
number   (3rd param) ==> The number of moves allowed to bishop to move to said position

8 |_|#|_|#|_|#|_|#|
7 |#|_|#|_|#|_|#|_|
6 |_|#|_|#|_|#|_|#|
5 |#|_|#|_|#|_|#|_|
4 |_|#|_|#|_|#|_|#|
3 |#|_|#|_|#|_|#|_|
2 |_|#|_|#|_|#|_|#|
1 |#|_|#|_|#|_|#|_|
   a b c d e f g h
The board is a 8 x 8 board goes from a1 to h8

BISHOP MOVEMENT :
The bishop chess piece moves in any direction diagonally.
Chess rules state that there is no limit to the number of squares a bishop can travel on the chessboard, as long as there is not another piece obstructing its path.
Bishops capture opposing pieces by landing on the square occupied by an enemy piece.

OUTPUT :
true/false whether within n moves he can move from start pos to end pos

NOTES :
Return true if start and end position are same; even if number of moves is 0
Both start and end positions will always be valid (so within a1 ---> h8)
Input positions will always follow this pattern : f1 (i.e : Char(representing one of a-h)Number(represnting one of 1-8) on chess board)
The alphabet will always be lowercase followed immediately by number no space.
For our purpose, chess board is always empty, i.e: the bishop is the only one that can be played.
The number of moves n will always be whole number i.e : 0 or greater.
Your bishop may only move using its predefined moment method (it may not act like a queen or knight).
     */
public static void main(String[] args) {
    System.out.println(canBMove("a1", "a1", 0)); //true
    System.out.println(canBMove("c3", "c3", 5)); //true
    System.out.println(canBMove("a1", "b2", 1)); //true
    System.out.println(canBMove("a1", "h7", 3)); //false
    System.out.println(canBMove("a1", "h8", 3)); //true
    System.out.println(canBMove("c1", "d3", 10)); //false
    System.out.println(canBMove("c1", "d2", 10)); //false
}

public static boolean canBMove(String pos1, String pos2, int moves){
    if(pos1==pos2){return true;}
    String even = "aceg";
    String odd = "bdfh";

    String numbers = "12345678";
    String letters = "abcdefgh";

    int startInd = Integer.parseInt(pos1.substring(1));
    int endInd = Integer.parseInt(pos2.substring(1));

    String startLett = pos1.substring(0,1);
    String endLett = pos2.substring(0,1);


    int startLettInd = letters.indexOf(startLett.charAt(0));
    int endLettInd =letters.indexOf(endLett.charAt(0));
    int distanceLetters = Math.abs(endLettInd-startLettInd);

    int startIntInd = numbers.indexOf(pos1.charAt(1));
int endIntInd = numbers.indexOf(pos2.charAt(1));
  int distanceNumbers = Math.abs(endIntInd - startIntInd);

    //check move validity
 if(distanceLetters%2!=0&&distanceNumbers%2==0){return false;}
 if(distanceLetters%2==0&&distanceNumbers%2!=0){return false;}

    int minMoves = 0;
if(distanceNumbers==distanceLetters){minMoves = 1;}
else { minMoves = 2;}

return moves%2 == minMoves%2 ;
}

public static boolean checkMoveValidity(int startInd, int endInd, String startLett, String endLett){
    String even = "aceg";
    String odd = "bdfh";


    if ((endInd-startInd)%2==0){
        if (even.contains(startLett) && !even.contains(endLett)) {return false;}
        if (odd.contains(startLett) && !odd.contains(endLett)){return false;}
    }
    else {
        if (even.contains(startLett) && even.contains(endLett)) {return false;}
        if (odd.contains(startLett) && !odd.contains(endLett)){return false;}
    }

    return true;
}

}
