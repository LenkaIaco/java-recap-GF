package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        linePrinted("inputs/practice/my-file.txt");
        linePrinted("invalid");
        linePrintedByClassPath("my-file.txt");
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

    public static void linePrintedByClassPath (String filename){
        InputStream sourceIS = PrintEachLine.class.getResourceAsStream(filename);
        List<String> l;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(sourceIS))){
            l = br.lines().toList();
        } catch (IOException e){
            System.err.println("Reading source file not successful");
            return;
        }
        for (String s: l){
            System.out.println(s);
        }
    }
}