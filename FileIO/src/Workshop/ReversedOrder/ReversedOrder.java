package Workshop.ReversedOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ReversedOrder {
    public static void main(String[] args) {
        // Create a method called `decryptReversed2` that takes a filename string
        // as a parameter and decrypts the file's content.
        // If the file can't be opened it should print this message: "File not found"
        // The (decrypted) result should be saved in the "output.txt" file (don't change the path).
        // Change the path of the reversed-order.txt source file to the path
        // where you saved it on your computer.
        // You can find the source file in a link next to this exercise.
        decryptReversed2("inputs/workshop/reversed-order.txt");
        decryptReversed2ByClasspath("reversed-order.txt");
    }

    public static void decryptReversed2(String fileAndPath) {
        Path p1 = Path.of(fileAndPath);
        List<String> l1;
        try {
            l1 = Files.readAllLines(p1);
        } catch (IOException e) {
            System.err.println("Source file not found");
            return;
        }

        List<String> l2 = reverseLineOrder(l1);

/* alternatively:
     for (int i = sourceLines.size()-1; i >= 0; i--) {
        Files.writeString(targetPath, sourceLines.get(i), StandardOpenOption.APPEND);
        Files.writeString(targetPath,System.lineSeparator(), StandardOpenOption.APPEND);
        }
*/
        Path p2 = Paths.get("outputs/workshop/reversed-order-output.txt");
        try {
            Files.write(p2, l2);
        } catch (IOException e) {
            System.err.println("Writing into output file not successful");
        }
    }

    public static void decryptReversed2ByClasspath(String filename){
        InputStream sourceIS = ReversedOrder.class.getResourceAsStream(filename);
        List<String> inputList;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(sourceIS))){
            inputList = br.lines().toList();
        } catch (IOException e){
            System.err.println("Reading source file not successful");
            return;
        }

        List<String> result = reverseLineOrder(inputList);
        Path targetPath = Paths.get(System.getProperty("user.home"),"reversed-order-output.txt");
        try{
            Files.write(targetPath, result);
        }catch(IOException e){
            System.err.println("Writing to target file not successful");
        }
    }


    public static List<String> reverseLineOrder(List<String> l){

        List<String> result = new ArrayList<>();

        for (int i=l.size()-1; i>=0; i--){
            result.add(l.get(i));
        }

        return result;
    }
}

