package unitTesting.fibonacci;
//The first two values in the sequence are 0 and 1 (essentially 2 base cases).
// Each subsequent value is the sum of the previous two values,
// so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
// Define a recursive fibonacci(n) method that

// returns the nth fibonacci number,
// with n=0 representing the start of the sequence.
// The method should be able to handle invalid input (e.g. negative numbers)
public class Fibonacci {
  public static void main(String[] args) {
    Fibonacci fClass = new Fibonacci();
    System.out.println(fClass.fibonacciValue(3));
  }
//  for testing method, test all different eventual outcomes ()lines 18, 22, 23
  public int fibonacciValue (int fibonacciIndex) {
    if (fibonacciIndex < 0) {
      throw new UnsupportedOperationException("Fibonacci index cannot be negative");
    }
//    try {
      if (fibonacciIndex <= 1) {
        return fibonacciIndex;
      } return fibonacciValue(fibonacciIndex - 1) + fibonacciValue(fibonacciIndex - 2);
//    } catch
  }


}
