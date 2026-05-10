package leetcodeTop150.AArrayString;

public class SZigzagConversion {
/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);

Examples

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

Input: s = "A", numRows = 1
Output: "A"

Constraints:
1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
 */

 /*
    Time complexity O(n) for s.length() (each loop either stops at s.length,
                                      or the m*n looping number rows*cols is proportional to s.length * constant
    Space complexity O(n) for stringbuilder and new string
 */
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s,3));// "PAHNAPLSIIGYIR"
        System.out.println(convert(s,4));// "PINALSIGYAHRPI"

    }

    public static String convert(String s, int numRows) {
        if (numRows==1){return s;}

        int climbDist = numRows-2;
        int len = 0;
        boolean climb = false;
        int numCols = 0;
        while (len<s.length()){
            if (!climb){
                len+=numRows;
                numCols++;
                climb = true;
            } else{
                for (int i = 0;i<climbDist;i++){
                    len++;
                    numCols++;
                    if (len==s.length()){break;}
                }
            }
        }

        char[][] arr = new char[numRows][numCols];
        int nextI = 0;
        int rowIndex = numRows-2;
        int direction = 1;

        for (int y=0;y<numCols;y++){
            if (nextI==s.length()){break;}
            if (direction==1){
                for (int i=0;i<numRows;i++){
                    if (nextI==s.length()){break;}
                    arr[i][y] = s.charAt(nextI);
                    nextI++;
                }
                direction =-1;
                rowIndex=numRows-2;
            }
            else {
                if (rowIndex==0){direction=1;}
                else {
                arr[rowIndex][y]=s.charAt(nextI);
                nextI++;
                rowIndex+=direction;
                }
            }

            }

        StringBuilder sb = new StringBuilder();

        for (int i=0;i<numRows;i++){
            for (int y=0;y<numCols;y++){
                if (arr[i][y]!=(char)0){
                    sb.append(arr[i][y]);
                }
            }
        }

        return sb.toString();
    }
}
