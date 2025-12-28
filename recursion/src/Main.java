import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        System.out.println(bunnyEars(4));
//        System.out.println(mutatedEvenBunnies(6));
//        System.out.println(numberAdder(4));
//        System.out.println(strings("cinemaxxxks"));
//        System.out.println(fibonacciValue(12));
//        System.out.println(maxSum(new int[]{1, 2, 3, 4, 5}));
    }

    public static int numberAdder(int number) {
        if (number < 1) {
            return 0;
        } else {
            return number + numberAdder(number - 1);
        }
    }

    public static int bunnyEars(int bunnies) {
        if (bunnies <= 0) {
            return 0;
        } else if (bunnies == 1) {
            return 2;
        } else {
            return 2 + bunnyEars(bunnies - 1);
        }
    }

    public static int mutatedEvenBunnies(int bunnies) {
        if (bunnies <= 0) {
            return 0;
        } else if (bunnies == 1) {
            return 2;
        } else if (bunnies % 2 == 0) {
            return 3 + mutatedEvenBunnies(bunnies - 1);
        } else {
            return 2 + mutatedEvenBunnies(bunnies - 1);
        }
    }

    public static String strings(String s) {
        if (s.length() == 1) {
            if (s.equals("x")) {
                return "y";
            } else if (s.equals("X")) {
                return "Y";
            } else {
                return s;
            }
        } else {
            if (s.charAt(0) == 'x') {
                return 'y' + strings(s.substring(1));
            } else if (s.charAt(0) == 'X') {
                return 'Y' + strings(s.substring(1));
            }
        }
        return s.charAt(0) + strings(s.substring(1));
    }

    public static int fibonacciValue(int index) {
        if (index <= 0) {
            return 0;
        }
        if (index == 1) {
            return 1;
        } else {
            return fibonacciValue(index - 2) + fibonacciValue(index - 1);
        }
    }

    public static int maxSum(int[] array) {
        if (array.length <= 1) {
            return 0;
        } else {
            List<Integer> aList = new ArrayList<>(Arrays.stream(array).boxed().toList());
            aList.sort(Comparator.reverseOrder());
            int element0 = aList.get(0);
            aList.remove(0);
            int[] array2 = aList.stream().mapToInt(Integer::intValue).toArray();
            return element0 + maxSum(array2);
        }
    }
}
