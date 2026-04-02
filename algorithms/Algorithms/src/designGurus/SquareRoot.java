package designGurus;

public class SquareRoot {
    /*
    Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
        The returned integer should be non-negative as well.
        You must not use any built-in exponent function or operator.
        Input: x = 8
        Output: 2
        Explanation: The square root of 8 is 2.8284

        Input: x = 2
        Output: 1
        Explanation: The square root of 2 is 1.414

        Constraints:
        0 <= x <= 231 - 1
     */
    /*
    Time complexity roundedSqrt1   O(1)
    Time complexity roundedSqrt2
    n/2 + n/4 + n/8 + ...+ n/x
    simplified:             n/2^k = 1 //shrinking each iteration
                              2^k = n //expressed in terms of growth
                                k = log2n --> logn  // growth per iteration


            O() - > O(logn)
    Space complexity roundedSqrt1 + roundedSqrt2:  O(1)
     */

    public static void main(String[] args) {
        System.out.println(roundedSqrt1(8)); // exp.output 2
        System.out.println(roundedSqrt1(2)); // exp.output 1
        System.out.println(roundedSqrt1(230)); // exp.output 15
        System.out.println(roundedSqrt2(8)); // exp.output 2
        System.out.println(roundedSqrt2(2)); // exp.output 1
        System.out.println(roundedSqrt2(230)); // exp.output 15
    }
    public static int roundedSqrt1(int num) {
        if (num == 0 || num == 1) {
            return num;
        }
        int iterations = 0;
        if (num > 100) {
            iterations = 10;
        }
        for (int i = iterations; i <= 15 ; i++) {
            if (i * i <= num && (i + 1) * (i + 1) > num) {
                return i;
            }
        }
        return -1;
    }

    public static int roundedSqrt2(int num){
       int start = 0;
      int end = num /2;
      if (num==0){return 0;}
      if (num<=2){return 1;}
      int result = -1;
      while(start<end){
        int dist = (end-start) /2;
       int half = start +dist;
          if (half*half>num){
              end= half;
          } else if(half*half<num){
              if ((half+1)*(half+1)>num){return half;}
              start = half+1;
          } else{return half;}
      }
      return result;
    }

}
