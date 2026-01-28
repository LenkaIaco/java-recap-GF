import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Exercise12 {

    public static void main(String[] args) {

        System.out.println(nameOfTheHeaviest("swcharacters.csv"));
        System.out.println(averageHeightMales("swcharacters.csv"));
        System.out.println(averageHeightFemales("swcharacters.csv"));
        System.out.println(groupByGenderAndAge("swcharacters.csv"));
    }

    public static String nameOfTheHeaviest(String resourceInProject){
        List<Creature> creatures = creaturesAsList(resourceInProject);
        Optional<Double> max = creatures.stream().map( c -> c.getWeight()).max(Double::compareTo);
        String result = !max.isPresent() ? "unknown" : creatures.stream().filter(c ->Double.valueOf(c.getWeight()).equals(max.get()))
                .map(c -> c.getName()).findFirst().get();

//      alternatively, first find heaviest creature and then return its name
//        Creature heaviestCreature = creatures.stream()
//        .max(Comparator.comparing(c -> c.getWeight()))
//        .get();
//        return heaviestCreature.getName();
                return result;

    }
/*
    Return a map with the age distribution of the characters by gender (where the gender can be "male",
    "female" and "other").  The age groups are:
                "below 21",
                    "between 21 and 40",
                    "above 40" and
                    "unknown"
    m: Map <String(gender), Map(creatures)>
                            gender-groups:
                            Map<String,Creature>: old young other

    f:   ...                 Map<String,Creature>: old young other
    o:  ...                  Map<String,Creature>: old young other
 */


    public static Map <String, Map<String, Long>> groupByGenderAndAge(String resourceInProject){
        List<Creature> creatures = creaturesAsList(resourceInProject);

        Map <String, Map<String, Long>> grouped = creatures.stream()
                .collect(Collectors.groupingBy(
                        c -> {
                            if (c.getAge()==0.0){return "unknown";}
                            else if (c.getAge()>0&&c.getAge()<21){return "below 21";}
                            else if (c.getAge()>=21&&c.getAge()<=40){return "between 21 and 40";}
                            else {return "above 40";}
                        },

                        Collectors.groupingBy(
                                c-> {
                                    if (c.getGender().equals("male")){return "male";}
                                    else if (c.getGender().equals("female")){return "female";}
                                    else {return "other";}
                                },
                                Collectors.counting())
                ));

        return grouped;
    }

    public static double averageHeightMales(String resourceInProject){
            return averageHeightGender(resourceInProject, "male");
    }

    public static double averageHeightFemales(String resourceInProject){
        return averageHeightGender(resourceInProject, "female");
    }

    public static double averageHeightGender(String resourceInProject, String gender){
        List<Creature> creatures = creaturesAsList(resourceInProject);
        double average = 0.0;
        try {
            average = creatures.stream().filter(c -> c.getGender().equals(gender) && c.getHeight() > 0.0)
                    .map(c -> c.getHeight()).mapToDouble(Double::valueOf).average().getAsDouble();
        } catch (NoSuchElementException e){e.printStackTrace();}

        double roundedTwoDeci = Math.round(average*100) / 100.0;
        return roundedTwoDeci;
    }

    public static List<Creature> creaturesAsList(String resourceInProject){
        InputStream inputStream = Exercise12.class.getResourceAsStream(resourceInProject);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        List<Creature> creatures = new ArrayList<>();

        try(bufferedReader){
            creatures = bufferedReader.lines().skip(1).map(s -> {
                String[] arr = s.split(";");
                return new Creature(
                        arr[0],
                        arr[2].equals("unknown") ? 0.0 : Double.parseDouble(arr[2].replaceAll(",","")),
                        arr[1].equals("unknown") ? 0 : Integer.parseInt(arr[1]),
                        arr[7],
                        arr[6].equals("unknown") ? 0.0 : Double.valueOf(arr[6].replaceAll("BBY", ""))
                );
            }).toList();

        } catch (IOException e) {
            System.err.println("Reading from source file failed."); e.printStackTrace();}

        return creatures;
    }


}
