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

        System.out.println(match(girls, boys));


    }
    public static List match(List boys, List girls){
        List matchedList = new ArrayList<>();

        if (girls.size()== boys.size()) {
            for (int i = 0; i < boys.size(); i++) {
                matchedList.add(new String(girls.get(i).toString() + "-" + boys.get(i).toString()));
            }
        }
        else if (girls.size()> boys.size()){
            int sizeDifference = girls.size()- boys.size();
            for (int n= 0; n < boys.size() ; n++) {
                matchedList.add(new String(girls.get(n).toString()+"-"+boys.get(n).toString()));
            }
            for (int j = sizeDifference; j > 0; j--) {
                matchedList.add(new String (girls.get(girls.size()-j).toString()));
            }} else {
            int sizeDifference = boys.size()- girls.size();
            for (int n = 0; n < girls.size() ; n++) {
                matchedList.add(new String(girls.get(n).toString()+"-"+boys.get(n).toString()));
            }
            for (int j = sizeDifference; j > 0; j--) {
                matchedList.add(new String(boys.get(boys.size()-j).toString()));
            }
        }
  return matchedList;
    }
}
