import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class WriteMultipleLines {
    /** Task:
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
     */
    public static void main(String[] args) {

        writeLines("myfile.txt", "new line", 3);
        // invalid folder for Error testing: path = "nonexistentFolder/myfile.txt"

    }

    public static void writeLines(String path, String linesContent, int numberOfLines) {
        List<String> listOfLines = new ArrayList<>();
        for (int j = 0; j < numberOfLines; j++) {
            listOfLines.add(linesContent);
        }
        try {
            Files.write(Paths.get(path), listOfLines);
        } catch (IOException e) {
            System.err.println("Unable to write file: " + path);
        }

//        another option:
//        try {
//            for (int k = 0; k < numberOfLines; k++) {
//                Files.writeString(Path.of(path), linesContent, StandardOpenOption.APPEND);
//            }
//        } catch (IOException e) {
//            System.err.println("Unable to write file: " + path);
//        }

    }
}