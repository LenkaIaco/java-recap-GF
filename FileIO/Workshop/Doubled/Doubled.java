import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Doubled {

    public static void main(String[] args) {
        /** Task:
        // Create a method called `decryptDoubled` that takes a filename string
        // as a parameter and decrypts the file's content.
        // If the file can't be opened it should print this message: "File not found"
        // The (decrypted) result should be saved in the "output.txt" file (don't change the path).
        // Change the path of the duplicated-chars.txt source file to the path
        // where you saved it on your computer.
        // You can find the source file in a link next to this exercise.
        */

//        path is relative to the Project parent folder, not to the current java file!
        decryptDoubled("Doubled/duplicated-chars.txt");
    }

    public static void decryptDoubled(String path) {
        try {
            Path sourcePath = Paths.get(path);
            List<String> sourceLines = Files.readAllLines(sourcePath);
            String decodedLine = "";
//            Files.createFile(Paths.get("Doubled/output.txt"));
            for (int i = 0; i < sourceLines.size(); i++) {
//            String[] linesToWords= sourceLines.get(i).split("  ");
                    char[] sourceChars = sourceLines.get(i).toCharArray();
                    for (int k = 0; k < sourceChars.length; k += 2) {
                        decodedLine = decodedLine.concat(Character.toString(sourceChars[k]));
                    } decodedLine = decodedLine.concat(System.lineSeparator());
            } try {
                Files.writeString(Paths.get("Doubled/output.txt"), decodedLine, StandardOpenOption.APPEND);
            } catch (IOException e) {
                System.err.println("error while creating output file");}
        } catch (IOException e) {
            System.err.println("File not found");
        }

    }
}