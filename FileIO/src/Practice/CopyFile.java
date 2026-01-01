package src.Practice;

import java.io.IOException;
import java.nio.file.*;

public class CopyFile {
    // Write a `copy` function that copies the contents of a file into another file.
    // The function should take two filenames (strings) as parameters:
    //  - path and name of the source file
    //  - path and name of the target file
    // It should return a boolean that shows whether the copy was successful or not.
    public static void main(String[] args){
        System.out.println(copy("src/Practice/sourceFile.txt", "src/Practice/targetFile.txt"));
    }

    public static boolean copy(String file1pathname, String file2pathname){
        Path p1 = Paths.get(file1pathname);
        Path p2 = Paths.get(file2pathname);
        try{
            Files.copy(p1,p2, StandardCopyOption.REPLACE_EXISTING);  //if target file already exist, the COPY_ATTRIBUTES throws FileAlreadyExists(sub of IOEx.)
        } catch(IOException e){
            System.err.println("target file already exists");
            return false;
        }
        return true;
    }
}