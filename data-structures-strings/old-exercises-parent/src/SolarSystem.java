import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolarSystem {
    public static void main(String... args) {
        List<String> planetList = Arrays.asList("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Uranus", "Neptune");
/*
         "Saturn" is missing from the planetList above
        Insert it into the correct position (should go between Jupiter and Uranus)
         Create a method called "putSaturn()" which has a list parameter and returns the correct list

         Expected output: [Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus, Neptune]
 */

        System.out.println(putSaturn(planetList));

    }

    public static List putSaturn(List<String> list) {

        List<String> expandableList = new ArrayList<>(list);

        int index = list.indexOf("Jupiter");
        expandableList.add(index + 1, "Saturn");

        return expandableList;
    }
}
