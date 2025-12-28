public class GreatestCommonDivisor {
    /** Task:
     // Write a recursive method which returns the greatest common divisor (GCD)
     // of two numbers. The method should be able to handle negative numbers!
     */
    public static void main(String[] args) {

        System.out.println(greatestCommonDivisor(12, 7));

    }

    public static int greatestCommonDivisor(int n1, int n2){
        if (n2>n1){
            if (n2%n1==0) {return n1;} else{
                return greatestCommonDivisor(n1-1, n2);
            }
        }
        if (n1%n2==0){return n2;}
        return greatestCommonDivisor(n1, n2-1);
    }
}
