import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matchmaking {
    public static void main(String... args) {
        List<String> girls = new ArrayList<>(Arrays.asList("Eve", "Ashley", "Claire", "Kat", "Jane"));
        List<String> boys = new ArrayList<>(Arrays.asList("Joe", "Fred", "Tom", "Todd", "Neef", "Jeff"));

        // Write a method that joins the two lists by matching one girl with one boy into a new list
        // If someone has no pair, he/she should be added to the list on his/her own
        // Expected output: [Eve-Joe, Ashley-Fred, Claire-Tom, Kat-Todd, Jane-Neef, Jeff]

        System.out.println(pairs(girls, boys));

    }
    public static List<String> pairs(List<String> girls, List<String> boys){

        int smallerSize = girls.size() >= boys.size()? boys.size() : girls.size();
        List<String> paired = new ArrayList<>();
        for (int i = 0; i<smallerSize; i++){
            paired.add(girls.get(i).concat("-").concat(boys.get(i)));
        }

        if (girls.size()> boys.size()){
            int diff = girls.size()-boys.size();
            for (int i =0;i<diff;i++){
                paired.add(girls.get(boys.size()+i));
            }
        } else if (boys.size()>girls.size()){
            int diff = boys.size()-girls.size();
            for (int i=0; i<diff;i++){
                paired.add(boys.get(girls.size()+i));
            }
        }

        return paired;
    }
}
