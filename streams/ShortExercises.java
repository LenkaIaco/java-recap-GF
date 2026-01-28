import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Map.Entry;
import java.io.InputStream;

public class ShortExercises {
    volatile int val = 0;
    //        Exercise 1
//        Write a method to return a list of even numbers from the list of integers below using the Stream API.
//        List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
//        System.out.println(listEvenNumbers(numbers));
//        List<Integer> expectedOutput = Arrays.asList(-2, -4, -8, 12, 6, 10, 14);
//        System.out.println(expectedOutput);
//        System.out.println();

    public static List<Integer> evenNumbers(List<Integer> numList) {
        return numList.stream().filter(s -> s % 2 == 0).collect(Collectors.toList());
    }
//        Exercise 2
//        Write a method to return a list of squares of positive numbers from the list of integers below using the Stream API.
//        List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
//        System.out.println(squarePositiveNumbers(numbers));
//        List<Integer> expectedOutput = Arrays.asList(1, 9, 144, 361, 36, 81, 100, 196);
//        System.out.println(expectedOutput);
//        System.out.println();

    public static List<Integer> numbersSquared(List<Integer> origList) {
        return origList.stream().filter(s -> s > 0).map(s -> s * s).toList();
    }

    //        Exercise 3
//        Write a method to return a list of numbers whose square is greater than 20 from the list of integers
//        below using the Stream API. The value 20 should be one of the method's parameters.
//        List<Integer> numbers = Arrays.asList(3, 9, 2, 8, 6, 5);
//        System.out.println(squaresAbove20(numbers));
//        List<Integer> expectedOutput = Arrays.asList(9, 8, 6, 5);
//        System.out.println(expectedOutput);
//        System.out.println();

    public static List<Integer> squareGreaterThan(List<Integer> numbers, int number) {
        return numbers.stream().filter(s -> s * s > number).toList();
    }

//    Exercise 4
//        Write a method to return the average of odd numbers in the list of integers below using the Stream API. Implement this without calculating the sum first!
//        List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
//        System.out.println(averageOfOddNumbers(numbers));
//        double expectedOutput = 22.0 / 6.0;
//        System.out.println(expectedOutput);
//        System.out.println();

    public static double oddAverage(List<Integer> numbers) {
        return numbers.stream().filter(i -> i % 2 != 0).collect(Collectors.averagingDouble(Double::valueOf));
//numbers.stream().filter(s -> s%2>0).mapToInt(Integer::intValue).average().getAsDouble();
    }

    //        Exercise 5
//        Write a method to return the sum of odd numbers in the list of integers below using the Stream API.
//        List<Integer> numbers = Arrays.asList(5, 9, 1, 2, 3, 7, 5, 6, 7, 3, 7, 6, 8, 5, 4, 9, 6, 2);
//        System.out.println(sumOddNumbers(numbers));
//        int expectedOutput = 61;

    public static int sumOdd(List<Integer> numbers) {
        return numbers.stream().filter(s -> s % 2 > 0).mapToInt(Integer::intValue).sum();
    }

    //        Exercise 6
//        Write a method to return a list of uppercase characters from a given string using the Stream API.
//        String s = "Lorem Ipsum Dolor Sit Amet, Consectetur Adipiscing Elit. Morbi nec mattis odio.";
//        System.out.println(charactersToUppercase(s));
//        List<Character> expectedOutput = Arrays.asList('L', 'I', 'D', 'S', 'A', 'C', 'A', 'E', 'M');
    public static List<Character> uppercaseCharacters(String s) {
        return s.chars().filter(c -> Character.isUpperCase(c))
                .mapToObj(i -> (char) i).toList();
    }

//        Exercise 7
//        Write a method to return a list of strings which start with the specified character (method parameter) using the Stream API.
//        List<String> cities = Arrays.asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS");
//        System.out.println(wordsWhichStartWithLetter('R',cities));
//        System.out.println(wordsWhichStartWithLetter('N',cities));
//        List<String> expectedOutput;
//        expectedOutput = Arrays.asList("ROME"); // for 'R'
//        expectedOutput = Arrays.asList("NAIROBI", "NEW DELHI"); // for 'N'

    public static List<String> startingWith( Character starter, List<String> list) {
        return list.stream().filter(s -> s.startsWith(String.valueOf(starter))).toList();
    }

    //        Exercise 8
//        Write a method to return a string concatenated from a given list of characters using the Stream API.
//        List<Character> characters = Arrays.asList('L', 'o', 'r', 'e', 'm', ' ', 'i', 'p', 's', 'u', 'm');
//        System.out.println(joinCharactersToString(characters));
//        String expectedOutput = "Lorem ipsum";
    public static String charsToString(List<Character> chars) {
        return chars.stream().map(c -> String.valueOf(c)).collect(Collectors.joining());
    }

//        Exercise 9
//        Write a method to return a map specifying the frequency of characters in a given string using the Stream API
//        String s = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt.";
//        System.out.println(countPerCharacter(s));

    /// /        { =12, a=2, c=4, d=7, e=8, g=1, i=10, l=2, ,=2, L=1, m=5, n=4, .=1, o=7, p=3, r=4, s=6, t=7, u=4}

    public static Map<Character, Long> charFrequency(String s) {
        return s.chars().mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(c -> {
                    return c;
                }, Collectors.counting()));
    }
//        Exercise 10
//        Create a Fox class with 3 properties: name, color and age. Create a list of foxes and add at least 8 instances to it. Then, using the Stream API
//        write a method to return a list of foxes of green color
//[Fox[4, GREEN, Skuld], Fox[9, GREEN, Hildr]]
//        write a method to return a list of foxes of green color younger than 5
//                [Fox[4, GREEN, Skuld]]
//        write a method to return a map specifying the frequency of foxes by color
//        {GREEN=2, WHITE=1, BLACK=1, GRAY=1, RED=3}

//        List<Fox> foxes = new ArrayList<>();
//        foxes.add(new Fox("A", "RED", 1));
//        foxes.add(new Fox("B", "GREEN", 2));
//        foxes.add(new Fox("C", "BLUE", 2));
//        foxes.add(new Fox("D", "GRAY", 3));
//        foxes.add(new Fox("E", "GREEN", 4));
//        foxes.add(new Fox("F", "WHITE", 5));
//        foxes.add(new Fox("G", "YELLOW", 5));
//        foxes.add(new Fox("H", "GREEN", 6));
//
//        System.out.println(greenFoxes(foxes));
//        System.out.println(greenFoxesUnderAge5(foxes));
//        System.out.println(countFoxesByColor(foxes));

    public static List<Fox> filterColor(String color, List<Fox> allFoxes) {
        return allFoxes.stream().filter(f -> f.getColor().equals(color)).toList();
    }

    public static List<Fox> filterColorAndAge(String color, int age, List<Fox> allFoxes) {
        return allFoxes.stream().filter(f -> f.getColor().equals(color) && f.getAge() < age).toList();
    }

    public static long countColor(String color, List<Fox> allFoxes) {
        return allFoxes.stream().filter(f -> f.getColor().equals(color)).collect(Collectors.counting());
    }

//        Exercise 11
//        Find a random Wikipedia article and copy and save the contents to a text file //see wiki.txt file in the same folder as this java class.
//
//                Using the Stream API, write a method getWordFrequency which reads all text from the saved file and returns a map of word frequencies.
//
//        { Wikipedia=6, Australian=14, Australia=7, the=50, The=9 ...}
//        Next, using getWordFrequency and Stream API, write a method to return an ordered list Entry<String, Long> of the most common words in descending order. Keep in mind that the text contains punctuation characters which should be ignored. The result should be something like this:
//
//[the=50, No=46, and=38, in=37, of=30, Squadron=30, to=20, at=17, RAAF=17, 391=16 ...]
//        System.out.println(getWordFrequency("wiki.txt"));
//
    public static Map<String, Long> getWordFrequency(String fileinProject){
        InputStream inputstream = ShortExercises.class.getResourceAsStream(fileinProject);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputstream));
        List<String> lines = new ArrayList<>();

        try(bufferedReader){
            lines = bufferedReader.lines().toList();
        } catch (IOException e){e.printStackTrace();}

//   regex + replaceAll:  ^what is NOT   [any of]  chars,digits,SPACE ; Then, split by 1 or more spaces:
//   replaceAll("[^A-Za-z ]"," ").split("\\s+"))
      String[] arr =  lines.stream().collect(Collectors.joining())
                .replace("\n", " ")
                        .replace(",", "")
                        .replace(".", "")
                        .replace("(", "")
                        .replace(")", "")
                        .replace("[", " ")
                        .replace("]", "")
                        .replace(":", "")
                        .replace("\"", "")
                        .replace("/", "")
              .split(" ");

       return Arrays.stream(arr).collect(Collectors.groupingBy(
                s-> {return s;},
                Collectors.counting()
        ));
    }

    public static List<Entry<String, Long>> orderFrequencyDescending(Map<String, Long> wordFrequencies){
       return wordFrequencies.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).toList();
    }
}


