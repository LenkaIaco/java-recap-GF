package src.Practice;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class PrintEachLine {
    // Write a program that opens a file called "my-file.txt" and prints each
    // line from the file to separate lines on the console.
    // If the program is unable to read the file (for example the file does not exist),
    // it should print the following error message: "Unable to read file: my-file.txt".
    public static void main(String[] args){
        linePrinted("src/Practice/my-file.txt");
        linePrinted("invalid");
    }

    public static void linePrinted(String pathToFile){
        Path p = Paths.get(pathToFile);
        List<String> l = new ArrayList<>();

        try{
            l = Files.readAllLines(p);
        } catch (IOException e){
            System.err.println("Unable to read file: my-file.txt");
        }

        for (String s: l){
            System.out.println(s);
        }
    }
}