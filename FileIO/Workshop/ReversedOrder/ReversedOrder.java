import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ReversedOrder {
    public static void main(String[] args) {
        /** Task:
        // Create a method called `decryptReversed` that takes a filename string
        // as a parameter and decrypts the file's content.
        // If the file can't be opened it should print this message: "File not found"
        // The (decrypted) result should be saved in the "output.txt" file (don't change the path).
        // Change the path of the reversed-order.txt source file to the path
        // where you saved it on your computer.
        // You can find the source file in a link next to this exercise.
        */
     decryptReversed("ReversedOrder/reversed-order.txt");
    }
    public static void decryptReversed (String path){
        Path sourcePath = Paths.get(path);
        Path targetPath = Paths.get("ReversedOrder/output.txt");
        try {
            Files.createFile(targetPath);
        } catch (IOException e) {
            System.err.println("output file not created");
        }
        try {
            List<String> sourceLines = Files.readAllLines(sourcePath);
            for (int i = sourceLines.size()-1; i >= 0; i--) {
                Files.writeString(targetPath, sourceLines.get(i), StandardOpenOption.APPEND);
                Files.writeString(targetPath,System.lineSeparator(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            System.err.println("File not found");
        }
    }
}