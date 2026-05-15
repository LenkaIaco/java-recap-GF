package leetcodeTop150.IGraphGeneral;

public class ANumberOfIslands {
    /*
    Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Examples:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
     */

    public static int numIslands(char[][] grid) {
    int counter = 0;

    for (int i=0;i<grid.length;i++){
        for (int y=0;y<grid[i].length;y++){
            if (grid[i][y]=='1'){
                counter++;
                depthFirst(grid, i, y);
            }
        }
    }
    return counter;
    }

    public static void depthFirst (char[][] grid, int i, int j){
        if (i<0 || i> grid.length-1 || j<0 || j> grid[i].length-1){return;}
        if (grid[i][j]=='0'){return;}
        else {grid[i][j]='0';}

        depthFirst(grid, i+1,j);
        depthFirst(grid, i-1,j);
        depthFirst(grid, i,j+1);
        depthFirst(grid, i,j-1);
    }
}
