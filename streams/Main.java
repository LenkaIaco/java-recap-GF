import java.io.FilterOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //        Exercise 1
//        Write a method to return a list of even numbers from the list of integers below using the Stream API.
        List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
        System.out.println(ShortExercises.evenNumbers(numbers));
        List<Integer> expectedOutput = Arrays.asList(-2, -4, -8, 12, 6, 10, 14);
        System.out.println(expectedOutput);
        System.out.println();

        //        Exercise 2
//        Write a method to return a list of squares of positive numbers from the list of integers below using the Stream API.
        List<Integer> numbers2 = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
        System.out.println(ShortExercises.numbersSquared(numbers2));
        List<Integer> expectedOutput2 = Arrays.asList(1, 9, 144, 361, 36, 81, 100, 196);
        System.out.println(expectedOutput2);
        System.out.println();

        //        Exercise 3
//        Write a method to return a list of numbers whose square is greater than 20 from the list of integers
//        below using the Stream API. The value 20 should be one of the method's parameters.
        List<Integer> numbers3 = Arrays.asList(3, 9, 2, 8, 6, 5);
        System.out.println(ShortExercises.squareGreaterThan(numbers3, 20));
        List<Integer> expectedOutput3 = Arrays.asList(9, 8, 6, 5);
        System.out.println(expectedOutput3);
        System.out.println();

        //    Exercise 4
//        Write a method to return the average of odd numbers in the list of integers below using the Stream API. Implement this without calculating the sum first!
        List<Integer> numbers4 = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
        System.out.println(ShortExercises.oddAverage(numbers4));
        double expectedOutput4 = 22.0 / 6.0;
        System.out.println(expectedOutput4);
        System.out.println();

        //        Exercise 5
//        Write a method to return the sum of odd numbers in the list of integers below using the Stream API.
        List<Integer> numbers5 = Arrays.asList(5, 9, 1, 2, 3, 7, 5, 6, 7, 3, 7, 6, 8, 5, 4, 9, 6, 2);
        System.out.println(ShortExercises.sumOdd(numbers5));
        int expectedOutput5 = 61;
        System.out.println(expectedOutput5);

        //        Exercise 6
//        Write a method to return a list of uppercase characters from a given string using the Stream API.
        String s = "Lorem Ipsum Dolor Sit Amet, Consectetur Adipiscing Elit. Morbi nec mattis odio.";
        System.out.println(ShortExercises.uppercaseCharacters(s));
        List<Character> expectedOutput6 = Arrays.asList('L', 'I', 'D', 'S', 'A', 'C', 'A', 'E', 'M');
        System.out.println(expectedOutput6);

//        Exercise 7
//        Write a method to return a list of strings which start with the specified character (method parameter) using the Stream API.
        List<String> cities = Arrays.asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS");
        System.out.println(ShortExercises.startingWith('R',cities));
        System.out.println(ShortExercises.startingWith('N',cities));
        List<String> expectedOutput7;
        expectedOutput7 = Arrays.asList("ROME"); // for 'R'
        System.out.println(expectedOutput7);
        expectedOutput7 = Arrays.asList("NAIROBI", "NEW DELHI"); // for 'N'
        System.out.println(expectedOutput7);

        //        Exercise 8
//        Write a method to return a string concatenated from a given list of characters using the Stream API.
        List<Character> characters = Arrays.asList('L', 'o', 'r', 'e', 'm', ' ', 'i', 'p', 's', 'u', 'm');
        System.out.println(ShortExercises.charsToString(characters));
        String expectedOutput8 = "Lorem ipsum";
        System.out.println(expectedOutput8);

        //        Exercise 9
//        Write a method to return a map specifying the frequency of characters in a given string using the Stream API
        String str9 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt.";
        System.out.println(ShortExercises.charFrequency(str9));
        System.out.println("{ =12, a=2, c=4, d=7, e=8, g=1, i=10, l=2, ,=2, L=1, m=5, n=4, .=1, o=7, p=3, r=4, s=6, t=7, u=4}");

        //        Exercise 10
//        Create a Fox class with 3 properties: name, color and age. Create a list of foxes and add at least 8 instances to it. Then, using the Stream API
//        write a method to return a list of foxes of green color
//[Fox[4, GREEN, Skuld], Fox[9, GREEN, Hildr]]
//        write a method to return a list of foxes of green color younger than 5
//                [Fox[4, GREEN, Skuld]]
//        write a method to return a map specifying the frequency of foxes by color
//        {GREEN=2, WHITE=1, BLACK=1, GRAY=1, RED=3}

        List<Fox> foxes = new ArrayList<>();
        foxes.add(new Fox("A", "RED", 1));
        foxes.add(new Fox("B", "GREEN", 2));
        foxes.add(new Fox("C", "BLUE", 2));
        foxes.add(new Fox("D", "GRAY", 3));
        foxes.add(new Fox("E", "GREEN", 4));
        foxes.add(new Fox("F", "WHITE", 5));
        foxes.add(new Fox("G", "YELLOW", 5));
        foxes.add(new Fox("H", "GREEN", 6));

        System.out.println(ShortExercises.filterColor("GREEN",foxes));
        System.out.println(ShortExercises.filterColorAndAge("GREEN",5, foxes));
        System.out.println(ShortExercises.countColor("GREEN",foxes));

    }
}
