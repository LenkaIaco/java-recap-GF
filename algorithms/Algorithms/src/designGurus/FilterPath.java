package designGurus;

import java.util.Stack;

public class FilterPath {
    /*
    Given an absolute file path in a Unix-style file system, simplify it by converting ".." to the previous directory
        and removing any "." or multiple slashes. The resulting string should represent the shortest absolute path.
        - Constraints:
            1 <= path.length <= 3000
            path consists of English letters, digits, period '.', slash '/' or '_'.
            path is a valid absolute Unix path.
        - Example1:
            input path "/a//b////c/d//././/.."
            Expected Output: "/a/b/c"
        - Example2:
        Input: path = "/../"
        Expected Output: "/"
         */
    /*
    Time complexity O(n) for n = string length
    Space complexity O(n) path stack and stringbulider + O(n^2) in while loop, for lastIndexOf() is O(n)
     */

    public static void main(String[] args) {
        String path = "/a//b////c/d//././/..";
        System.out.println(resolveAbsolute(path)); //exp. out.: "/a/b/c"
    }

    public static String resolveAbsolute(String originalPath){

        if (originalPath==null){return null;}
        if (originalPath.length()<=1){return originalPath;}
        int prevCounter = 0;
        char prev = (char)0;
        Stack<Character> path = new Stack<>();

        for (int i=originalPath.length()-1; i>=0;i--){
            if(originalPath.charAt(i)=='.'){
                if(prev=='.'){
                    prevCounter++;
                    prev=(char)0;
                } else{prev = '.';}
            }
           else if (originalPath.charAt(i)=='/'){
               if(prev!='.'&&path.size()!=0){
                   if (prev!='/'){
                       path.push('/');
                   }
               }
                prev='/';
            }
           else{
               path.push(originalPath.charAt(i));
               prev = originalPath.charAt(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        int iterations = path.size();
        for (int i=0;i<iterations;i++){
            sb.append(path.pop());
        }

        int lastSlash = sb.lastIndexOf("/");
        while(prevCounter>0){
            sb = sb.delete(lastSlash,sb.length());
            prevCounter--;
            lastSlash = sb.lastIndexOf("/");
        }
        return sb.toString();
    }

    /*
    public static String resolveAbsolute(String originalPath) {
    if (originalPath == null) return null;
    if (originalPath.length() <= 1) return originalPath;

    String[] parts = originalPath.split("/");
    Deque<String> stack = new ArrayDeque<>();

    // Traverse in forward order — O(n) total
    for (String part : parts) {
        if (part.equals("..")) {
            if (!stack.isEmpty()) stack.pop(); // go up one level
        } else if (!part.isEmpty() && !part.equals(".")) {
            stack.push(part);                  // normal segment
        }
    }

    // Build result — O(n)
    StringBuilder sb = new StringBuilder();
    List<String> segments = new ArrayList<>(stack);
    Collections.reverse(segments);
    for (String seg : segments) {
        sb.append("/").append(seg);
    }

    return sb.length() == 0 ? "/" : sb.toString();
}
     */
}
