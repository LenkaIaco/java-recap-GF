package designGurus;

import java.util.Stack;

public class BinaryConversion {
    /*    --STACK--
    Given a positive integer n, write a function that returns its binary equivalent as a string.
    The function should not use any in-built binary conversion function.
     */

    /*
    Time complexity: O(n) + O(n) -> n=stack.size() building + popping ----> O(n)
    Space complexity: O(n^2) -> new string creation is O(n) each iteration(n iterations),
    as old String with underlying char array is discarded and a new is allocated
     */

    public static void main(String[] args) {
        System.out.println(decimalToBinary(2)); // binary: 10
        System.out.println(decimalToBinary(7)); // binary: 111
        System.out.println(decimalToBinary(18)); // binary: 10010
        System.out.println(decimalToBinary(4)); // binary: 100
    }
    public static String decimalToBinary(int num){
        int exponent = 0;
        int binaryNum = 2;
        Stack<Integer> stackBin = new Stack<>();
        stackBin.push(1);

        while (num>=stackBin.peek()){
            stackBin.push(stackBin.peek()*2);
        }

        String result = "";

        while (num>0){
            if (num<stackBin.peek()){
                if (result.equals("")){
                    stackBin.pop();
                }else {
                    result = result+"0";
                    stackBin.pop();
                }
            }
            else if (num==stackBin.peek()){
                result = result+"1";
                num = num - stackBin.peek();
                stackBin.pop();
                for (int i = 0;i<stackBin.size();i++){
                    result = result + "0";
                }
            }
            else{
                num = num - stackBin.peek();
                result = result + "1";
                stackBin.pop();
            }
        }
        return result;
    }
}
