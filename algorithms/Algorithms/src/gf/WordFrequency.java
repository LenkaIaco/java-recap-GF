package gf;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class WordFrequency {
    /*
    getWordFrequency() can read and parse a file. The function should take three parameters:

- a path for the input filename as a string
- a frequency as an integer
- a path for the output filename as a string

It collects all the words that appear the frequency amount of times in the input file.
It shall write the selected words into the output file **alphabetically sorted**,
separated by commas and spaces.

If there are no words present with the given frequency
the output file should be empty.

The method/function should print `Error happened during file manipulation
with the following message: <message>` if an error/exception
happens during file manipulations.

[Example file can be found here.](input.txt)

Example method/function call:  getWordFrequency('input.txt', 2, 'output.txt');

The `output.txt` contains this line:   apple, pear, pirate
     */
    public static void main(String[] args) {
WordFrequency wf = new WordFrequency();
String inputP = "C:/Users/lenka/Documents/JavaProjects/java_recap_gf/algorithms/input.txt";
String outputP = "C:/Users/lenka/Documents/JavaProjects/java_recap_gf/algorithms/output.txt";
wf.getWordFrequency(inputP,2, outputP); //apple, pear, pirate
    }

   public void getWordFrequency(String inputPath, int frequency, String outputPath) throws IllegalArgumentException {
       if (inputPath==null||outputPath==null){throw new IllegalArgumentException("input path and output path need to be specified"); }
       if(frequency<1){throw new IllegalArgumentException("frequency needs to be positive");}
       Path pInput = Paths.get(inputPath);
       List<String> inputList = new ArrayList<>();

       try{
          inputList = Files.readAllLines(pInput);
       } catch(IOException e){throw new IllegalArgumentException("Error happened during file manipulation\n" +
               "with the following message: " + e.getMessage());}

       Map<String, Integer> wordsCounts = new HashMap<>();

       for (int i=0;i<inputList.size();i++){
           String[] words = inputList.get(i).split(" ");
           for (int y=0;y<words.length;y++){
               if (words[y].indexOf(':')!=-1){
                   StringBuilder sb = new StringBuilder(words[y]);
                   sb.deleteCharAt(words[y].indexOf(':'));
                   words[y] = sb.toString();
               } else if(words[y].indexOf(',')!=-1){
                   StringBuilder sb = new StringBuilder(words[y]);
                   sb.deleteCharAt(words[y].indexOf(','));
                   words[y]=sb.toString();
               } else if(words[y].indexOf('.')!=-1){
                   StringBuilder sb = new StringBuilder(words[y]);
                   sb.deleteCharAt(words[y].indexOf('.'));
                   words[y]  = sb.toString();
               }
               String lower = words[y].toLowerCase();
               if (wordsCounts.containsKey(lower)){
                   wordsCounts.put(lower,  wordsCounts.get(lower)+1);
               } else {wordsCounts.put(lower, 1);}
           }
       }

       List<String> outputList = new ArrayList<>();

       for (Map.Entry<String,Integer> e: wordsCounts.entrySet()){
           if (e.getValue().equals(frequency)){
               outputList.add(e.getKey());
           }
       }

       outputList.sort(Comparator.naturalOrder());
       String result =outputList.get(0);
       for(int i=1;i<outputList.size();i++){
           result = result + ", " + outputList.get(i);
       }

       Path pOutput = Paths.get(outputPath);

       try{
           Files.writeString(pOutput, result, StandardOpenOption.CREATE);
       } catch(IOException e){
           throw new IllegalArgumentException("Error happened during file manipulation\n" +
                   "with the following message: "+ e.getMessage());
       }
   }
}
