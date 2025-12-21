package Functions.Exercises;

public class Factorial {
    public static void main(String[] args) {
        //  Create the usual class wrapper (Factorial) and main method on your own

// - Create a function called `calculateFactorial()`
//   that returns the factorial of its input
//
// - Example: calculateFactorial(5) = 1 * 2 * 3 * 4 * 5 = 120
        System.out.println(calculateFactorial(5));
    }
    public static int calculateFactorial(int input) {
        int factorial = 1;
        for (int i = 1; i <=input ; i++) {
        factorial = factorial*i;
        }
        return factorial;
    }
//    public static int calculateFactorial2(int number){
//        if (number<2) return number;
//        int factorial = 1;
//        while (number>1){
//            factorial = factorial * number;
//            number--;
//        }
//        return factorial;
//    }
}
