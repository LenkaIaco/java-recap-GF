import java.util.Scanner;

public class Calculator {
    public static void main(String... args) {

    // Create a simple calculator application which reads parameters from the prompt and prints the result back.
    // The calculator should support the following operators: +, -, *, /, %
    // The format of the input expressions must be: {operator} {operand} {operand}
    // Input examples:
    //    "+ 3 3" (the result will be 6)
    //    "* 4 4" (the result will be 16)
    //    "/ 4 3" (the result will be 1)
    //
    // In the division (/) case, the result should be a whole number, e.g. 20 / 8 = 2, 10 / 3 = 3, etc.

    // To make it work use the `Scanner` class to get input from the user. Create a method named `calculate()` and
    // pass the input as a parameter into it. The method should return a result of the calculation as an `Integer`.
    //
    // The process should work like this:
    // - Start the program
    // - Print: "Please type in the expression:" using System.out.println
    //   (Wait for the user input)
    // - After receiving the input print the result number to the prompt
    // - Exit the program


    // Input & Output
    //
    // Please type in the expression:
    // + 10 3
    // 13


        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter operand, first number, second number in the format: {operator} {operand} {operand} Example: + 2 2 ");
        String input = scan.nextLine();
//        char[] arrayInput = input.toCharArray();
//        System.out.println(arrayInput);
//        char operator = arrayInput[0];
//        int number1 = Character.getNumericValue(arrayInput[2]);
//        int number2 = Character.getNumericValue(arrayInput[4]);
//        System.out.println(number2);
//
//
//        if (operator == '+') {int resultAdd =  (int) Math.addExact(number1,number2); System.out.println(resultAdd);}
//       if (operator == '-')  {int resultSubtract = (int) Math.subtractExact(number1,number2);
//           System.out.println(resultSubtract);}
//        if (operator == '*')  {int resultMultiply = (int) Math.multiplyExact(number1,number2);
//            System.out.println(resultMultiply);}
//        if (operator == '/' || operator == '%')  { int resultDivide = (int) Math.floorDiv(number1,number2);
//            System.out.println(resultDivide);}

            System.out.println(calculate(input));
    }

public static int calculate(String input){
    char[] arrayInput = input.toCharArray();
    char operator = arrayInput[0];
    int number1 = Character.getNumericValue(arrayInput[2]);
    int number2 =  Character.getNumericValue(arrayInput[4]);

int result = 0;
    if (operator == '+') {int resultAdd =  Math.addExact(number1,number2); result= resultAdd;}
    if (operator == '-')  {int resultSubtract = Math.subtractExact(number1,number2); result= resultSubtract;}
    if (operator == '*')  {int resultMultiply = Math.multiplyExact(number1,number2); result= resultMultiply;}
    if (operator == '/'|| operator == '%')  { int resultDivide = Math.floorDiv(number1,number2); result= resultDivide;}
return result;
}
}
