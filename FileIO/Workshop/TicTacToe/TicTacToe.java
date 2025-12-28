package TicTacToe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TicTacToe {
    public static void main(String[] args) {
        /** Task:
        // Write a method `ticTacResult` which takes a filename as a parameter,
        // and returns "X", "O" or "Draw" based on the input file's content
        // The file contains a finished Tic-Tac-Toe match
        // See the examples in draw.txt, win-x.txt, win-o.txt
        */
        System.out.println(ticTacResult("TicTacToe/win-o.txt"));
        // Should print "O"

        System.out.println(ticTacResult("TicTacToe/win-x.txt"));
        // Should print "X"

        System.out.println(ticTacResult("TicTacToe/draw.txt"));
//        // Should print "Draw"
    }

    public static String ticTacResult(String path) {
        Path sourcePath = Path.of(path);
        try {

            List<String> sourceFile = Files.readAllLines(sourcePath);
            for (int i = 0; i < sourceFile.size(); i++) {
                if ((sourceFile.get(i).substring(0, 1).equals(sourceFile.get(i).substring(1, 2))) &&
                        (sourceFile.get(i).substring(1, 2).equals(sourceFile.get(i).substring(2, 3)))) {
                    return sourceFile.get(i).substring(1, 2);
                } else if (sourceFile.get(0).substring(i, i + 1).equals(sourceFile.get(1).substring(i, i + 1)) &&
                        sourceFile.get(0).substring(i, i + 1).equals(sourceFile.get(2).substring(i, i + 1))) {
                    return sourceFile.get(0).substring(i, i + 1);
                } else {
                    for (int k = -1; k <= 1; k += 2) {
                        if (sourceFile.get(0).substring(1 - k, 1 - k + 1).equals(sourceFile.get(1).substring(1, 2)) &&
                                sourceFile.get(1).substring(1, 2).equals(sourceFile.get(2).substring(1 + k, 1 + k + 1))) {
                            return sourceFile.get(1).substring(1, 2);
                        }
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Source file not found");
            return "";
        }
        return "Draw";
    }

}
