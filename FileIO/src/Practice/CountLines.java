package src.Practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CountLines {
    // Write a function called countLines() that takes a filename as string as a parameter
// and returns the number of lines the file contains.
// It should return zero if it can't open the file
// and should not raise any error.
    public static void main(String[] args) {

        System.out.println(countLines("src/Practice/sourceFile.txt"));
    }

    public static int countLines(String filenameAndPath){
        List<String> l = new ArrayList<>();
        try {
            l = Files.readAllLines(Path.of(filenameAndPath));
        } catch (IOException e){
            System.err.println("Reading file not successful");
            return l.size();
        }
        return l.size();
    }


}