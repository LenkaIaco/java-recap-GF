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

//    public static int greatestCommonDivisor(int n1, int n2){
//        if (n1==0 || n2==0) {return 0;}
//        if (n1==n2) {return n1;}
//
//        int divisorStart;
//        if (n1>n2) {divisorStart=n2;}
//        else {divisorStart = n1;}
//
//        if (divisorStart == 1){return divisorStart;}
//
//        boolean bothDivisible = (n1 % divisorStart==0) && (n2 % divisorStart ==0) ;
//
//        if (n1<n2) {n1 = n1-1;
//        } else{n2 = n2-1;}
//
//        return bothDivisible ? divisorStart : greatestCommonDivisor(n1, n2);
//    }

}
