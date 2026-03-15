public class MultiplesOf3Or5 {
//    https://www.codewars.com/kata/514b92a657cdc65150000006
    /*
    If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
    The sum of these multiples is 23.

Finish the solution so that it returns sum of all the multiples of 3 or 5 below the number passed in.

Note: If a number is a multiple of both 3 and 5, only count it once.
     */
public static void main(String[] args) {
    System.out.println(sumMultiples3And5(10)); //23
}

public static int sumMultiples3And5(int n){
    if (n<=0){return 0;}
    int sumMultiples = 0;
    for (int i=0; i<n;i++){
        if(i%3==0){
            sumMultiples+=i;
        }else if(i%5==0){
            sumMultiples+=i;
        }
    }
    return sumMultiples;
}
}
