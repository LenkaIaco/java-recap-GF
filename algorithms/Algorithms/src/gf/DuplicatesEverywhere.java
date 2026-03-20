package gf;

import java.util.*;

public class DuplicatesEverywhere {
//    https://www.codewars.com/kata/5e8dd197c122f6001a8637ca/train/java
    /*
    You are given a table, in which every key is a stringified number, and each corresponding value is an array of characters, e.g.
{
  "1": ["A", "B", "C"],
  "2": ["A", "B", "D", "A"],
}
Create a function that returns a table with the same keys, but each character should appear only once among the value-arrays, e.g.

{
  "1": ["C"],
  "2": ["A", "B", "D"],
}
Rules
Whenever two keys share the same character, they should be compared numerically, and the larger key will keep that character
If duplicate characters are found in the same array, the first occurance should be kept.
     */
    public static void main(String[] args) {
        Map<Integer, List<String>>input = new HashMap<>();
        input.put( 1, new ArrayList<>(Arrays.asList(  "C", "F", "G")));
        input.put( 2, new ArrayList<>(Arrays.asList("A", "B", "C")));
        input.put( 3, new ArrayList<>(Arrays.asList("A", "B", "D")));
        /*
        output: "1": ["F", "G"],  "2": ["C"],   "3": ["A", "B", "D"]
         */
        System.out.println(removeDuplicateIds(input));

        Map<Integer, List<String>>input2 = new HashMap<>();
        input2.put( 1, new ArrayList<>(Arrays.asList( "A")));
        input2.put( 2, new ArrayList<>(Arrays.asList( "A")));
        input2.put( 3, new ArrayList<>(Arrays.asList( "A")));
        /*
        output = "1": [],   "2": [],  "3": ["A"],
         */
        System.out.println(removeDuplicateIds(input2));


        Map<Integer, List<String>>input3 = new HashMap<>();
        input3.put(432, new ArrayList<>(Arrays.asList("A", "A", "B", "D")));
        input3.put(53, new ArrayList<>(Arrays.asList("L", "G", "B", "C")));
        input3.put(236, new ArrayList<>(Arrays.asList("L", "A", "X", "G", "H", "X")));
        input3.put(11, new ArrayList<>(Arrays.asList("P", "R", "S", "D")));
/*        output = "11": ["P", "R", "S"],   "53": ["C"],   "236": ["L", "X", "G", "H"],
        "432": ["A", "B", "D"],
 */
        System.out.println(removeDuplicateIds(input3));

    }



    public static Map<Integer, List<String>> removeDuplicateIds(Map<Integer, List<String>> obj) {

Map<Integer, List<String>> newMap = new HashMap<>();

        List<Integer> keys = obj.keySet().stream().sorted().toList();

        for (int i =0; i<keys.size();i++){ // iterate all lists
            boolean flagPrevious= false;
            Integer key = keys.get(i);
            List<String> currValues = obj.get(key);
            List<String> uniques = new ArrayList<>();
            if (i!=0) {
                Map<Integer, List<String>> previous = new HashMap<>();
            }
                for(int y=0;y<currValues.size();y++){ //iterate one list
                    if (!uniques.contains(currValues.get(y))){
                        uniques.add(currValues.get(y));
                    }
                    if(i>0){
                        for (int z=0;z<i;z++) {
                            int prevKey = keys.get(z);
                            List<String> prevVals = newMap.get(prevKey);
                            if (prevVals.contains(currValues.get(y))){
                                prevVals.remove(currValues.get(y));
                                newMap.put(prevKey, prevVals);                            }

                        }
                    }
                }
                newMap.put(key, uniques);
            }
        return newMap;
        }


    }

