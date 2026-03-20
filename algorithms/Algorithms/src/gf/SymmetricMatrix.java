package gf;

public class SymmetricMatrix {
    /*
    Create a function named `isSymmetric`
that takes an n×n integer matrix (two dimensional array) as a parameter
and returns `true` if the matrix is symmetric
or `false` if it is not.

Symmetric means it has identical values along its diagonal axis from top-left to bottom-right,
as in the first example.
Write at least 2 different unit test cases.

Example 1:
  [1, 0, 1],
  [0, 2, 2],
  [1, 2, 5]
Output: true

Example 2:
  [7, 7, 7],
  [6, 5, 7],
  [1, 2, 1]
Output:false
     */
    public static void main(String[] args) {
    int[][] symmetric = {
            {1,0,1},
            {0,2,2},
            {1,2,5}
    };
    int[][] asymmetric = {
            {7,7,7},
            {6,5,7},
            {1,2,1}
    };

        System.out.println(isSymmetric(symmetric)); //exp. true
        System.out.println(isSymmetric(asymmetric)); //exp. false
    }

    public static boolean isSymmetric(int[][] matrix){
        if(matrix==null){return false;}
        if (matrix.length==0){return false;}
        if(matrix[0].length==0){return false;}
        if(matrix.length!=matrix[0].length){return false;}

        int length2D = matrix[0].length;
        for (int i=0;i< matrix.length;i++){
            if(matrix[i].length!=length2D){return false;}
        }

        for (int i=0;i<matrix.length;i++){
            for(int y=0;y<matrix[i].length;y++){
                if (matrix[i][y]!=matrix[y][i]){return false;}
            }
        }

        return true;
    }
}
