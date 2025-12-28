import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CountLines {
    /** Task:
    // Write a function called countLines() that takes a filename as string as a parameter
// and returns the number of lines the file contains.
// It should return zero if it can't open the file
// and should not raise any error.
     */
    public static void main(String[] args) {

        System.out.println(countLines("testfile.txt"));
    }

    public static int countLines(String filename) {
        try {
            List<String> fileContent = Files.readAllLines(Paths.get(filename));
            int size = fileContent.size();
            return size;
        } catch (IOException e) {
            return 0;
        }
    }


}
