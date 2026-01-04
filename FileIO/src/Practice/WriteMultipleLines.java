package Practice;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class WriteMultipleLines {
    // Create a function `writeLines` that takes 3 parameters: a path, a word and a number.
    //   The function should write multiple lines into a file.
    // - The path parameter should be a string that describes the location (path & name)
    //    of the file you wish to write.
    // - The word parameter should also be a string that will be written to the file as individual lines.
    // - The number parameter should describe how many times the function should write the word in the file.
    // Example:
    // If the word is "apple" and the number is 5, it should write 5 lines
    // into the file and each of the should be "apple".
    // The function should not raise any errors, but print the "Unable to write file: <path>"
    // error message instead.
    public static void main(String[] args) {


        Path p1 = Paths.get("outputs/practice/my-file.txt");
        Path p2 = Paths.get("invalidPath.txt");
        writeLines(p1, "apple", 3);
        writeLines(p2, "apple", 3);
        writeLinesByClassPath(Path.of("my-file.txt"),"apple",3);
    }

    public static void writeLines(Path p, String word, int number){
        List<String> l = new ArrayList<>();

        for (int i=0; i<number; i++){
            l.add(word);
        }
        try {
            Files.write(p, l, StandardOpenOption.WRITE);
        } catch (IOException e){
            System.out.println("Unable to write file: "+ p);
        }
    }

    public static void writeLinesByClassPath (Path p, String word, int number){

        List<String> l = new ArrayList<>();
        for (int i = 0; i<number;i++){
            l.add(word);
        }

        String s = p.toString();
        Path target = Path.of(System.getProperty("user.home"), s);

        try{
            Files.write(target, l);
        }catch (IOException e){
            System.err.println("Writing to target file not successful");
        }

        System.out.println("writing successful");
    }

}