import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentCounter {
    public static void main(String... args) {
        List<Map<String, Object>> studentMaps = new ArrayList<>();

        // Given this list of hash maps...

        Map<String, Object> student0 = new HashMap<>();
        student0.put("name", "Theodor");
        student0.put("age", 9);
        student0.put("candies", 2);
        studentMaps.add(student0);

        Map<String, Object> student1 = new HashMap<>();
        student1.put("name", "Paul");
        student1.put("age", 10);
        student1.put("candies", 1);
        studentMaps.add(student1);

        Map<String, Object> student2 = new HashMap<>();
        student2.put("name", "Mark");
        student2.put("age", 7);
        student2.put("candies", 3);
        studentMaps.add(student2);

        Map<String, Object> student3 = new HashMap<>();
        student3.put("name", "Peter");
        student3.put("age", 12);
        student3.put("candies", 5);
        studentMaps.add(student3);

        Map<String, Object> student4 = new HashMap<>();
        student4.put("name", "Olaf");
        student4.put("age", 12);
        student4.put("candies", 7);
        studentMaps.add(student4);

        Map<String, Object> student5 = new HashMap<>();
        student5.put("name", "George");
        student5.put("age", 3);
        student5.put("candies", 2);
        studentMaps.add(student5);

        // Create a function called getListOfNames() which takes a list of student maps (studentMaps) and returns
        // the names of students (as a list of strings) who have more than 4 candies
        // Expected output: [Peter, Olaf]

        // Create a function called getSumOfAges() which takes a list of student maps (studentMaps) and returns
        // the sum (as an integer) of the ages of students who have less than 5 candies
        // Expected output: 29

        System.out.println(getListOfNames(studentMaps));
        System.out.println(getSumOfAges(studentMaps));

    }

    public static int getSumOfAges(List<Map<String, Object>> listOfMaps) {
        int agesLess5 = 0;
        for (Map<String, Object> entry : listOfMaps) {
            if ((int) entry.get("candies") < 5) {
                agesLess5 = agesLess5 + (int) entry.get("age");
            }
        }
        return agesLess5;
    }

    public static List getListOfNames(List<Map<String, Object>> listOfMaps) {
        List<String> namesMore4 = new ArrayList<>();
        for (Map map : listOfMaps) {
            if ((int) map.get("candies") > 4) {
                namesMore4.add(map.get("name").toString());
            }
        }
        return namesMore4;
    }
}
