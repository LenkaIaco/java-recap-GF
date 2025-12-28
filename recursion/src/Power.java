public class Power {
    public static void main(String[] args) {
        /**Task:
// Given base and n that are both 1 or more, write a recursive method (no loops)
// which returns the value of base to the n-th power, so powerN(3, 2) is 9 (3 squared).
         */
        System.out.println(baseN(2,3));
        System.out.println(baseN(3,3));
    }

    public static int baseN(int base, int nPower){
        if (nPower==1){return base;}
        return base * baseN(base, nPower-1);
    }

}
