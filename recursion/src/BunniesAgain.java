public class BunniesAgain {
    public static void main(String[] args) {
        /**Task:
        // We have bunnies standing in a line numbered as 1, 2, ... The "odd" bunnies
// (1, 3, ...) have the usual number of ears = 2. However, the even bunnies
// (2, 4, ...) have 3 ears each (because they have a raised foot). Write
// a recursive method which accepts the number of bunnies as a parameter
// and returns the total number of "ears" in the bunny line. The method should be
// able to handle invalid input (e.g. negative numbers).
         */
        System.out.println(bunnyEars(1));  //2
        System.out.println(bunnyEars(3));  //7
        System.out.println(bunnyEars(4));  //10
        System.out.println(bunnyEars(5));  //12
        System.out.println(bunnyEars(6));  //15
        System.out.println(bunnyEars(7));  //17
    }

    public static int bunnyEars(int numberOfBunnies) {
        if (numberOfBunnies <= 0) {
            return 0;}

 //        return (numberOfBunnies%2 ==0) ? 3 + bunnyEars(numberOfBunnies-1) : 2 + bunnyEars(numberOfBunnies -1);

        if (numberOfBunnies % 2 == 0) {
            return (3 + bunnyEars(numberOfBunnies - 1));
        }

        return (2 + bunnyEars(numberOfBunnies - 1));

    }
}
