//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.*;
//import java.util.List;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class StreamUtils {
//    public static void main(String[] args) {
////        Exercise 1
////        Write a method to return a list of even numbers from the list of integers below using the Stream API.
////        List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
////        System.out.println(listEvenNumbers(numbers));
////        List<Integer> expectedOutput = Arrays.asList(-2, -4, -8, 12, 6, 10, 14);
////        System.out.println(expectedOutput);
////        System.out.println();
//
////        Exercise 2
////        Write a method to return a list of squares of positive numbers from the list of integers below using the Stream API.
////        List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
////        System.out.println(squarePositiveNumbers(numbers));
////        List<Integer> expectedOutput = Arrays.asList(1, 9, 144, 361, 36, 81, 100, 196);
////        System.out.println(expectedOutput);
////        System.out.println();
//
////        Exercise 3
////        Write a method to return a list of numbers whose square is greater than 20 from the list of integers below using the Stream API. The value 20 should be one of the method's parameters.
////        List<Integer> numbers = Arrays.asList(3, 9, 2, 8, 6, 5);
////        System.out.println(squaresAbove20(numbers));
////        List<Integer> expectedOutput = Arrays.asList(9, 8, 6, 5);
////        System.out.println(expectedOutput);
////        System.out.println();
//
////        Exercise 4
////        Write a method to return the average of odd numbers in the list of integers below using the Stream API. Implement this without calculating the sum first!
////        List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
////        System.out.println(averageOfOddNumbers(numbers));
////        double expectedOutput = 22.0 / 6.0;
////        System.out.println(expectedOutput);
////        System.out.println();
//
////        Exercise 5
////        Write a method to return the sum of odd numbers in the list of integers below using the Stream API.
////        List<Integer> numbers = Arrays.asList(5, 9, 1, 2, 3, 7, 5, 6, 7, 3, 7, 6, 8, 5, 4, 9, 6, 2);
////        System.out.println(sumOddNumbers(numbers));
////        int expectedOutput = 61;
//
////        Exercise 6
////        Write a method to return a list of uppercase characters from a given string using the Stream API.
////        String s = "Lorem Ipsum Dolor Sit Amet, Consectetur Adipiscing Elit. Morbi nec mattis odio.";
////        System.out.println(charactersToUppercase(s));
////        List<Character> expectedOutput = Arrays.asList('L', 'I', 'D', 'S', 'A', 'C', 'A', 'E', 'M');
//
////        Exercise 7
////        Write a method to return a list of strings which start with the specified character (method parameter) using the Stream API.
////        List<String> cities = Arrays.asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS");
////        System.out.println(wordsWhichStartWithLetter('R',cities));
////        System.out.println(wordsWhichStartWithLetter('N',cities));
////        List<String> expectedOutput;
////        expectedOutput = Arrays.asList("ROME"); // for 'R'
////        expectedOutput = Arrays.asList("NAIROBI", "NEW DELHI"); // for 'N'
//
////        Exercise 8
////        Write a method to return a string concatenated from a given list of characters using the Stream API.
////        List<Character> characters = Arrays.asList('L', 'o', 'r', 'e', 'm', ' ', 'i', 'p', 's', 'u', 'm');
////        System.out.println(joinCharactersToString(characters));
////        String expectedOutput = "Lorem ipsum";
//
////        Exercise 9
////        Write a method to return a map specifying the frequency of characters in a given string using the Stream API
////        String s = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt.";
////        System.out.println(countPerCharacter(s));
//////        { =12, a=2, c=4, d=7, e=8, g=1, i=10, l=2, ,=2, L=1, m=5, n=4, .=1, o=7, p=3, r=4, s=6, t=7, u=4}
//
////        Exercise 10
////        Create a Fox class with 3 properties: name, color and age. Create a list of foxes and add at least 8 instances to it. Then, using the Stream API
////        write a method to return a list of foxes of green color
////[Fox[4, GREEN, Skuld], Fox[9, GREEN, Hildr]]
////        write a method to return a list of foxes of green color younger than 5
////                [Fox[4, GREEN, Skuld]]
////        write a method to return a map specifying the frequency of foxes by color
////        {GREEN=2, WHITE=1, BLACK=1, GRAY=1, RED=3}
//
////        List<Fox> foxes = new ArrayList<>();
////        foxes.add(new Fox("A", "RED", 1));
////        foxes.add(new Fox("B", "GREEN", 2));
////        foxes.add(new Fox("C", "BLUE", 2));
////        foxes.add(new Fox("D", "GRAY", 3));
////        foxes.add(new Fox("E", "GREEN", 4));
////        foxes.add(new Fox("F", "WHITE", 5));
////        foxes.add(new Fox("G", "YELLOW", 5));
////        foxes.add(new Fox("H", "GREEN", 6));
////
////        System.out.println(greenFoxes(foxes));
////        System.out.println(greenFoxesUnderAge5(foxes));
////        System.out.println(countFoxesByColor(foxes));
//
////        Exercise 11
////        Find a random Wikipedia article and copy and save the contents to a text file //see wiki.txt file in the same folder as this java class.
////
////                Using the Stream API, write a method getWordFrequency which reads all text from the saved file and returns a map of word frequencies.
////
////        { Wikipedia=6, Australian=14, Australia=7, the=50, The=9 ...}
////        Next, using getWordFrequency and Stream API, write a method to return an ordered list Entry<String, Long> of the most common words in descending order. Keep in mind that the text contains punctuation characters which should be ignored. The result should be something like this:
////
////[the=50, No=46, and=38, in=37, of=30, Squadron=30, to=20, at=17, RAAF=17, 391=16 ...]
////        System.out.println(getWordFrequency("wiki.txt"));
////
////        Exercise 12
////        The swcharacters.csv file contains the list of characters from the Star Wars universe.
////        "BBY" stands for Before the Battle of Yavin, it's the "year zero" in the Galactic Standard Calendar. For the age calculation assume that the date today is 0BBY and (for simplicity) every character is alive.
////        Using Stream API write methods to perform the following exercises:
////        Return the name of the heaviest character (ignore characters whose mass/weight is unknown)
////        Grievous
////        Return the average height of male characters
////        179.237
////        Return the average height of female characters
////        165.471
////Return a map with the age distribution of the characters by gender (where the gender can be "male", "female" and "other")
////        The age groups are: "below 21", "between 21 and 40", "above 40" and "unknown" //note: there migt be a wrong amount in some of the total group counts count below
////        The result should be a Map<String, Map<String, Long>>
////                or, if you wish to be more precise Map<AgeGroup, Map<GenderGroup, Long>>
////        {
////            ABOVE_40 = {FEMALE=6, MALE=20, OTHER=2},
////                    BETWEEN_21_AND_40 = {FEMALE=1, MALE=5, OTHER=1},
////                    BELOW_21 = {FEMALE=1, MALE=3, OTHER=1},
////                    UNKNOWN = {FEMALE=11, MALE=34, OTHER=3}
////        }
//
//
//    }
//
//    public static List<Integer> listEvenNumbers(List<Integer> list) {
//        return list.stream()
//                .filter(x -> x % 2 == 0)
//                .collect(Collectors.toList());
//    }
//
//    public static List<Integer> squarePositiveNumbers(List<Integer> list) {
//        return list.stream()
//                .filter(x -> x > 0)
//                .map(x -> x * x)
//                .collect(Collectors.toList());
//    }
//
//    public static List<Integer> squaresAbove20(List<Integer> list) {
//        return list.stream()
//                .filter(x -> (x * x) > 20)
//                .collect(Collectors.toList());
//    }
//
//    public static Double averageOfOddNumbers(List<Integer> list) {
//        double average = (double) list.stream()
//                .filter(x -> x % 2 != 0)
//                .collect(Collectors.averagingDouble(x -> x));
//        return average;
//    }
//
//    public static int sumOddNumbers(List<Integer> list) {
//        return list.stream()
//                .filter(x -> x % 2 != 0)
//                .collect(Collectors.summingInt(x -> x)); // OR:  .mapToInt(x -> x).sum()
//    }
//
//    public static List<Character> charactersToUppercase(String s) {
//        return s.chars()
//                .filter(ch -> Character.isUpperCase(ch))
//                .mapToObj(c -> (char) c)
//                .collect(Collectors.toList());
////      RETURNS JUST LIST<Sring>: return Stream.of(s).filter(ch -> Character.isUpperCase(ch.charAt(0))).collect(Collectors.toList());
//    }
//
//    public static List<String> wordsWhichStartWithLetter(char letter, List<String> words) {
//        return words.stream()
//                .filter(word -> Character.toUpperCase(word.charAt(0)) == Character.toUpperCase(letter))
//                .collect(Collectors.toList());
//    }
//
//    public static String joinCharactersToString(List<Character> characters) {
//        return characters.stream()
//                .map(ch -> String.valueOf(ch))
//                .collect(Collectors.joining(""));
//    }
//
//    public static Map<Character, Long> countPerCharacter(String s) {
//        return Stream.of(s)
//                .flatMap(x -> x.chars().boxed())
//                .map(x -> (char) x.intValue())
//                .collect(Collectors.groupingBy(
//                        Function.identity(),
//                        Collectors.counting()));
//    }
//
//    public static List<Fox> greenFoxes(List<Fox> foxes) {
//        return foxes.stream().filter(fox -> fox.color.equals("GREEN")).collect(Collectors.toList());
//    }
//
//    public static List<Fox> greenFoxesUnderAge5(List<Fox> foxes) {
//        return foxes.stream().filter(fox -> fox.color.equals("GREEN") && fox.age < 5).toList();
//    }
//
//    public static Map<String, Long> countFoxesByColor(List<Fox> foxes) {
//        return foxes.stream()
//                .collect(Collectors.groupingBy(
//                        fox -> fox.color,
//                        Collectors.counting()));
//    }
//
//    public static Map<String, Long> getWordFrequency(String path) {
//        List<String> list = new ArrayList<>();
//        try {
//            list = Files.readAllLines(Path.of(path));
//        } catch (IOException e) {
//            System.out.println("File cannot be accessed");
//        }
//
//        return list.stream().flatMap(x -> Stream.of(x.split(" "))) //or: Arrays.stream(x.split(" "))
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//    }
//
//
//}
//
