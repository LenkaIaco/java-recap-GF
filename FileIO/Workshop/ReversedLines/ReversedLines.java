import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.SQLOutput;
import java.util.List;

public class ReversedLines {
    public static void main(String[] args) {
        /**
        // Create a method called `decryptReversed` that takes a filename string
        // as a parameter and decrypts the file's content.
        // If the file can't be opened it should print this message: "File not found"
        // The (decrypted) result should be saved in the "output.txt" file (don't change the path).
        // Change the path of the reversed-lines.txt source file to the path
        // where you saved it on your computer.
        // You can find the source file in a link next to this exercise.
         */
        decryptReversed("ReversedLines/reversed-lines.txt");
    }

    public static void decryptReversed(String path) {
        String decodedLine = "";
        Path sourcePath = Paths.get(path);

        try {
            Files.createFile(Paths.get("ReversedLines/output.txt"));
        } catch (IOException e) {
            System.out.println("output file not created");
        }
        try {
            List<String> sourceLines = Files.readAllLines(sourcePath);

            for (int i = 0; i < sourceLines.size(); i++) {
                char[] sourceChars = sourceLines.get(i).toCharArray();

                for (int k = sourceChars.length - 1; k >= 0; k--) {
                    decodedLine = decodedLine.concat(Character.toString(sourceChars[k]));
                }
                decodedLine = decodedLine.concat(System.lineSeparator());

            }
            Files.writeString(Paths.get("ReversedLines/output.txt"), decodedLine, StandardOpenOption.APPEND);

        } catch (IOException e) {
            System.err.println("File not found");
        }
    }
}