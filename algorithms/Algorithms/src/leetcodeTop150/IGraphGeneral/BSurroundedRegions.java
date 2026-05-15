package leetcodeTop150.IGraphGeneral;

import java.util.Arrays;

public class BSurroundedRegions {
    /*
You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

Connected: A cell is connected to adjacent cells horizontally or vertically.
Region: A region is formed by connected 'O' cells.
Surround: A region is surrounded if none of the 'O' cells in that region is on the edge of the board:
i/j==0 ||
i===arr.length-1 ||
j== arr[i].length-1

Goal: capture a surrounded region:
replace all 'O's of the surrounded region with 'X's in-place within the original board.
You do not need to return anything.

Examples:

Input: board =
[["X","X","X","X"],
 ["X","O","O","X"],
 ["X","X","O","X"],
 ["X","O","X","X"]]

Output:
[["X","X","X","X"],
 ["X","X","X","X"],
 ["X","X","X","X"],
 ["X","O","X","X"]]

Explanation:
In the above diagram, the bottom region is not captured because
 it is on the edge of the board and
 cannot be surrounded.

Example 2:
Input: board = [["X"]]
Output: [["X"]]


Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
     */

    public static void main(String[] args) {
char[][] input = {
        {'X','X','X','X'},
        {'X','O','O','X'},
        {'X','X','O','X'},
        {'X','O','X','X'}
};
        solve(input);
        System.out.println(Arrays.deepToString(input));
    }

    public static void solve(char[][] board) {
        for (int i=0;i<board.length;i++){
            for (int y=0;y<board[i].length;y++){
            if (i==0||i==board.length-1||y==0||y==board[i].length-1){
                if (board[i][y]=='O'){
                    markNotSurrounded(board, i, y);
                }
            }
            }
        }

        for (int i=0;i<board.length;i++){
            for (int y=0;y<board[i].length;y++){
                if (board[i][y]=='O'){
                    board[i][y]='X';
                }
            }
        }

        for (int i=0;i<board.length;i++){
            for (int y=0;y<board[i].length;y++){
                if (board[i][y]=='S'){
                    board[i][y]='O';
                }
            }
        }
    }

    public static void markNotSurrounded(char[][]board, int i, int j){
        if (i<0||j<0||i>board.length-1|| j>board[i].length-1){return;}
        if (board[i][j]=='X'||board[i][j]=='S'){return;}
        if (board[i][j]=='O'){board[i][j]='S';}
        markNotSurrounded(board,i,j+1);
        markNotSurrounded(board,i,j-1);
        markNotSurrounded(board,i+1,j);
        markNotSurrounded(board,i-1,j);
    }
}
