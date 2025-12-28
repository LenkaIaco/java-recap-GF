import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class CopyFile {
    /** Task:
    // Write a `copy` function that copies the contents of a file into another file.
    // The function should take two filenames (strings) as parameters:
    //  - path and name of the source file
    //  - path and name of the target file
    // It should return a boolean that shows whether the copy was successful or not.
     */
    public static void main(String[] args) {
        System.out.println(copy("sourceFile.txt", "targetFile.txt"));
    }

    public static boolean copy(String sourceFile, String targetFile) {
        Path actualSourcePath = Path.of(sourceFile);
        Path actualTargetPath = Path.of(targetFile);
        try {
            Files.copy(actualSourcePath, actualTargetPath, StandardCopyOption.COPY_ATTRIBUTES);
            //    By default, the copy() method fails if the target file already exists or is a symbolic link
        } catch (IOException e) {
            System.err.println("target file already exists");
            return false;
        }
        return true;
    }
}