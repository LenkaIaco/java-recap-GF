public class NumberAdder {
    public static void main(String[] args) {
        /** Task:
        // Implement "numberAdder" which is a recursive function that takes one parameter: n (number)
// and returns the sum of integers from 1 to n.
// The function should return 0 for inputs less than 1.
         */
        System.out.println(numberAdder(4));    //10
        System.out.println(numberAdder(7));  //28

    }

    public static int numberAdder(int n) {
        if (n < 1) {
            return 0;
        }
        return n + numberAdder(n - 1);
    }
}
