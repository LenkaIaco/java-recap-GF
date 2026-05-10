package leetcodeTop150.GStack;

import javax.print.DocFlavor;
import java.util.*;

public class BSimplifyPath {
    /*
You are given an absolute path for a Unix-style file system, which always begins with a slash '/'.
Your task is to transform this absolute path into its simplified canonical path:
A single period '.' represents the current directory.
A double period '..' represents the previous/parent directory.
Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.
Any sequence of periods that does not match the rules above should be treated as a valid directory or file name. For example, '...' and '....' are valid directory or file names.
The simplified canonical path should follow these rules:

The path must start with a single slash '/'.
Directories within the path must be separated by exactly one slash '/'.
The path must not end with a slash '/', unless it is the root directory.
The path must not have any single or double periods ('.' and '..') used to denote  current or parent directories.
Return the simplified canonical path.

Input: path = "/home/"   Output: "/home"
Input: path = "/home//foo/"   Output: "/home/foo"
Input: path = "/home/user/Documents/../Pictures"   Output: "/home/user/Pictures"
Input: path = "/../"   Output: "/"   Going one level up from the root directory is not possible.
Input: path = "/.../a/../b/c/../d/./"   Output: "/.../b/d"   "..." is a valid name for a directory in this problem.

Constraints:
1 <= path.length <= 3000
path consists of English letters, digits, period '.', slash '/' or '_'.
path is a valid absolute Unix path.
     */
    public static void main(String[] args) {
        String path = "/home/";
        String path1 = "/home//foo/";
        String path2 = "/home/user/Documents/../Pictures";
        String path3 = "/../";
        String path4 = "/.../a/../b/c/../d/./";
        String path5 = "/..hidden";
        String path6 = "/a//b////c/d//././/..";

        System.out.println(simplifyPath(path));  //Output: "/home"
        System.out.println(simplifyPath(path1));  //Output: "/home/foo"
        System.out.println(simplifyPath(path2));  //Output: "/home/user/Pictures"
        System.out.println(simplifyPath(path3));  //Output: "/"
        System.out.println(simplifyPath(path4));  //Output: "/.../b/d"
        System.out.println(simplifyPath(path5));  //Output: "/..hidden"
        System.out.println(simplifyPath(path6));  //Output: "/a/b/c"
    }

    public static String simplifyPath(String path) {
        String[] sequences = path.split("/");
        Deque<String> updSequences = new ArrayDeque<>();
        for (int i = 0; i < sequences.length; i++) {
          if (!sequences[i].isEmpty()){
              if (sequences[i].equals("..")){
                  if (updSequences.size()>=1){
                      updSequences.pop();
                  }
              } else if (!sequences[i].equals(".")){updSequences.push("/"+sequences[i]);}
          }
        }

        if (updSequences.isEmpty()){return "/";}

        String[] flipped = new String[updSequences.size()];
        for (int i=flipped.length-1;i>=0;i--){
            flipped[i]=updSequences.pop();
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<flipped.length;i++){
            sb.append(flipped[i]);
        }

        return sb.toString();
    }
}
