package designGurus;

import java.util.*;

public class BinaryNumbersToN {
    /*
    ---QUEUE---
        Given an integer N, generate all binary numbers from 1 to N and return them as a list of strings.
        Input: N = 2
        Output: ["1", "10"]

        Input: N = 5
        Output: ["1", "10", "11", "100", "101"]
     */

    /*
    Time complexity: O(n*m) where n = iterations i, m = length of current binary num
    Space complexity: can be measured in 2 ways:
        Peak live memory (most common) → max memory occupied at any given moment
        Total allocated memory ->per all iterations (important for GC pressure)
     Mostly, peak live memory is being considered as the main data.

         peak live memory: O(m):
            each iteration, a new String builder nad a new reverse array are created, each memory space = m
         total allocated memory: O(m*n) - n iterations, m memory space for sb and arr

     */

    public static void main(String[] args) {
        List<String> result = generateBinaryNumbers(6);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i) + ", ");
        }
    }

    public static List<String> generateBinaryNumbers(int n) {
        List<String> binaries = new LinkedList<>();
        Stack<String> last = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (i==0){binaries.add("1");last.push("1");}
            else{
                if (last.peek().equals("0")) {
                    last.pop();
                    last.push("1");
                } else {
                    int counter = 0;
                    while (last.size() > 0) {
                        if (last.peek().equals("1")) {
                            last.pop();
                            counter++;
                        }else{break;}
                    }
                    if (last.size() > 0) {
                        last.pop();
                        last.push("1");
                    } else {
                        last.push("1");
                    }
                    for (int y = 0; y < counter; y++) {
                        last.push("0");
                    }
                }
                String[] reversed = new String[last.size()];
                int index = 0;
                while (last.size() > 0) {
                    reversed[reversed.length - 1 - index] = last.pop();
                    index++;
                }
                StringBuilder sb = new StringBuilder();
                for (int z = 0; z < reversed.length; z++) {
                    sb.append(reversed[z]);
                    last.push(reversed[z]);
                }
                binaries.add(sb.toString());
            }
        }

        return binaries;
    }
}
