package gf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MostCommonCharacters {
    /*
Write a function named `getTwoMostCommonCharacters` that takes a filename as a parameter, and returns the 2 most common characters and their occurrences in the file's content.
Return: `Map<Character, Integer>`

If the file does not exist throw an exception with the following message: "File does not exist!"

*Note*: If there is more than one character with the same occurrence,
you can return any one of those. For example, if 'a', 'b', and 'c' each occur 8-times,
you can return any two combination of them, i.e. (a,b), (a,c), or (b,c).

[Example file can be found here](./countchar.txt)

### Output
  'e': 6,
  'l': 4
*/
    public static void main(String[] args) throws IOException {
        MostCommonCharacters mc = new MostCommonCharacters();
        String path  = "C:/Users/lenka/Documents/JavaProjects/java_recap_gf/algorithms/Algorithms/countchar2.txt";
        System.out.println(mc.getTwoMostCommonCharactersOnClassPath("countchar.txt"));
        System.out.println(mc.getTwoMostCommonCharactersOutOfClassPath(path));
    }

    public Map<Character, Integer> getTwoMostCommonCharactersOnClassPath(String filename){
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
    List<String> lines = br.lines().toList();
        return this.textToCharCount(lines);
    }

    public Map<Character,Integer> getTwoMostCommonCharactersOutOfClassPath(String pathToFile) throws IOException{
        Path p = Path.of(pathToFile);
       List l = new ArrayList();
        try{
            l = Files.readAllLines(p);
        }catch (IOException e){
            throw new IOException("File does not exist!");
        }

        return this.textToCharCount(l);
    }


    public Map<Character, Integer> textToCharCount (List<String> lines){
        Map<Character,Integer> charFrequency = new HashMap<>();

        for (int i=0;i<lines.size();i++){
            char [] arr = lines.get(i).toCharArray();
            for (int y=0;y<arr.length;y++){
                Integer count = charFrequency.get(arr[y]);
                if (count == null){
                    charFrequency.put(arr[y], 1);
                } else{
                    charFrequency.put(arr[y],++count);
                }
            }
        }

        List<Integer> counts = new ArrayList<>(charFrequency.values());

        counts.sort(Comparator.reverseOrder());

        Map<Character,Integer> result = new HashMap<>();

        for (int i=0;i<2;i++){
            boolean flag = false;
            for (Map.Entry<Character, Integer> e : charFrequency.entrySet()){
                if (e.getValue().equals(counts.get(i))){
                    result.put(e.getKey(),e.getValue());
                    break;
                }
            }
        }
        return result;
    }
}
