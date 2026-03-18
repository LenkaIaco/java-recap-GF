public class SudokuValidator {
//    https://www.codewars.com/kata/63d1bac72de941033dbf87ae
    /*
    Sudoku is a game played on a 9x9 grid. The goal of the game is to fill all cells of the grid
    with digits from 1 to 9, so that:
    each column,
    each row, and
    each of the nine 3x3 sub-grids (also known as blocks)
    contain all the digits from 1 to 9.

    All inputs are guaranteed to be 2D boards of size 9x9 with possible values in range 0-9.
Rows, columns and blocks (3x3 small squares) must contain each number from range 1-9 exactly once.
User solution must not modify input boards.

Write a function that accepts a Sudoku board, and returns true if it is a valid Sudoku solution
 Boards containing one or more zeroes are considered to be invalid solutions.

 Examples
Valid board:

  5 3 4|6 7 8|9 1 2
  6 7 2|1 9 5|3 4 8
  1 9 8|3 4 2|5 6 7
  -----+-----+-----
  8 5 9|7 6 1|4 2 3
  4 2 6|8 5 3|7 9 1
  7 1 3|9 2 4|8 5 6
  -----+-----+-----
  9 6 1|5 3 7|2 8 4
  2 8 7|4 1 9|6 3 5
  3 4 5|2 8 6|1 7 9

  Invalid board:
              This column has two 3's
                        v
This cell has a 0 > 0 3 4|6 7 8|9 1 2
                    6 7 2|1 9 5|3 4 8
                    1 9 8|3 4 2|5 6 7
                    -----+-----+-----
                    8 5 9|7 6 1|4 2 3
                    4 2 6|8 5 3|7 9 1
                    7 1 3|9 2 4|8 5 6
                    -----+-----+-----
    This box has   /9 6 1|5 3 7|2 8 4
         two 3's >| 2 8 3|4 1 9|6 3 5 < This row has two 3's
                   \3 4 5|2 8 6|1 7 9
         */
public static void main(String[] args) {
int[][] validBoard = new int[][]{
        {5, 3, 4, 6, 7, 8, 9, 1, 2},
        {6, 7, 2,1, 9, 5,3, 4, 8},
        {1, 9, 8,3, 4, 2,5, 6, 7},
        {8, 5, 9,7, 6, 1,4 ,2, 3},
        { 4, 2, 6,8, 5, 3,7, 9, 1},
        { 7, 1, 3,9, 2, 4,8, 5, 6},
        { 9, 6, 1,5, 3, 7,2, 8, 4},
        { 2, 8, 7,4, 1, 9,6, 3, 5},
        {  3, 4 ,5,2, 8, 6,1, 7, 9},
};

int[][] invalidBoard = new int[][]{
        {5, 3, 4, 6, 7, 8, 9, 1, 2},
        {6, 7, 2,1, 9, 5,3, 4, 8},
        {1, 9, 8,3, 4, 2,5, 6, 7},
        {8, 5, 9,7, 6, 1,4 ,2, 3},
        { 4, 2, 6,8, 5, 3,7, 9, 1},
        { 7, 1, 3,9, 2, 4,8, 5, 6},
        { 9, 6, 1,5, 3, 7,2, 8, 4},
        { 2, 8, 3,4, 1, 9,6, 3, 5}, //this row has 2 3s and missing 7
        {  3, 4 ,5,2, 8, 6,1, 7, 9},
};

    int[][] invalidBoard1 = new int[][]{
            {0, 3, 4, 6, 7, 8, 9, 1, 2}, //this row has a 0 and no 5
            {6, 7, 2,1, 9, 5,3, 4, 8},
            {1, 9, 8,3, 4, 2,5, 6, 7},
            {8, 5, 9,7, 6, 1,4 ,2, 3},
            { 4, 2, 6,8, 5, 3,7, 9, 1},
            { 7, 1, 3,9, 2, 4,8, 5, 6},
            { 9, 6, 1,5, 3, 7,2, 8, 4},
            { 2, 8, 7,4, 1, 9,6, 3, 5},
            {  3, 4 ,5,2, 8, 6,1, 7, 9},
    };

    System.out.println(verifySudoku(validBoard));//exp.out true
    System.out.println(verifySudoku(invalidBoard));//exp.out false
    System.out.println(verifySudoku(invalidBoard1));//exp.out false
}

public static boolean verifySudoku (int[][]board){
    if (board==null){return false;}
    if (board.length!=9) {return false;}
    for (int i=0;i< board.length;i++){
        if (board[i].length!=9){return false;}
    }

    int[] horizontals = {1,2,3,4,5,6,7,8,9};
    int[] verticals = {1,2,3,4,5,6,7,8,9};
       for(int i=0;i<board.length;i++){
           boolean horizFlag = false;
           boolean vertFlag = false;
           horizontals = new int[]{1,2,3,4,5,6,7,8,9};
           verticals = new int[]{1,2,3,4,5,6,7,8,9};
        for(int y=0;y<board[i].length;y++){
            horizFlag=false;
            vertFlag=false;
           if(board[i][y]==0) {return false;}
           if(board[y][i]==0){return false;}

           for (int z=0;z<horizontals.length;z++){
               if(board[i][y]==horizontals[z]){horizFlag=true;
               horizontals[z]=0;}
               if(board[y][i]==verticals[z]){vertFlag= true;
               verticals[z]=0;}
           }
           if (!horizFlag||!vertFlag){return false;}
        }
    }
       return true;
}
}
