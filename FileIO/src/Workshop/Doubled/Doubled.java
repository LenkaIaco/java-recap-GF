package src.Workshop.Doubled;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Doubled {
// Create a method called `decryptDoubled` that takes a filename string
        // as a parameter and decrypts the file's content.
        // If the file can't be opened it should print this message: "File not found"
        // The (decrypted) result should be saved in the "output.txt" file (don't change the path).
        // Change the path of the duplicated-chars.txt source file to the path
        // where you saved it on your computer.
        // You can find the source file in a link next to this exercise.


        //        path is relative to the Project parent folder, not to the current java file!
        public static void main(String[] args) {
            decryptDoubled("src/Workshop/Doubled/duplicated-chars.txt");
            decryptDoubled("invalid/duplicated-chars.txt");
    }

    public static void decryptDoubled(String filename) {

        Path p = Paths.get(filename);
        List<String> l = new ArrayList<>();
        try {
            l = Files.readAllLines(p);
        } catch (IOException e) {
            System.err.println("File not found");
            return;  // if no return here, the file below will be created as if with empty contents
        }

        Path p2 = Paths.get("src/Workshop/Doubled/output.txt");
        List<String> l2 = new ArrayList<>();
        for (String s : l){
            String s1 = "";
            for (int i=0; i<s.length(); i+=2){
                s1 = s1 + s.charAt(i);
            }
            l2.add(s1);
        }

        try {
            Files.write(p2,l2); // equivalent to: Files.write(p2,l2,StandardOpenOption.CREATE)
        } catch(IOException e){
            System.err.println("Writing to output file not successful");
        }

    }


}