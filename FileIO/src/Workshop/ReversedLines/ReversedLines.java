package src.Workshop.ReversedLines;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReversedLines {
    public static void main(String[] args) {
        // Create a method called `decryptReversed` that takes a filename string
        // as a parameter and decrypts the file's content.
        // If the file can't be opened it should print this message: "File not found"
        // The (decrypted) result should be saved in the "output.txt" file (don't change the path).
        // Change the path of the reversed-lines.txt source file to the path
        // where you saved it on your computer.
        // You can find the source file in a link next to this exercise.

        decryptReversed("src/Workshop/ReversedLines/reversed-lines.txt");
    }
    public static void decryptReversed(String filepath) {
        Path p = Paths.get(filepath);

        List<String> l;
        try{
            l = Files.readAllLines(p);
        } catch (IOException e){
            System.err.println("File not found");
            return;
        }

        List<String> l2 = new ArrayList<>();
        Path p2 = Path.of("src/Workshop/ReversedLines/output.txt");
        for(String s: l){
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            l2.add(sb.toString());
            // alternative to sb.reverse(), see method below:
//             l2.add( reverseString(s) );

        }

        try{
            Files.write(p2, l2);
        } catch (IOException e){
            System.err.println("Writing to output file not successful");
        }
    }


    public static String reverseString (String s) {
        char[] chArr = new char[s.length()];
        for (int i=0; i<s.length();i++){
            chArr[i] = s.charAt(s.length()-1-i);
        }

        return new String(chArr);
    }
}