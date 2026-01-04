package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.file.*;
import java.util.List;

public class CopyFile {
    // Write a `copy` function that copies the contents of a file into another file.
    // The function should take two filenames (strings) as parameters:
    //  - path and name of the source file
    //  - path and name of the target file
    // It should return a boolean that shows whether the copy was successful or not.
    public static void main(String[] args){
        System.out.println(copy("inputs/practice/sourceFile.txt", "outputs/practice/targetFile.txt"));

        System.out.println(copyByClasspath("my-file.txt", "targetFile.txt"));

    }

    public static boolean copy(String file1pathname, String file2pathname){
        Path p1 = Paths.get(file1pathname);
        Path p2 = Paths.get(file2pathname);
        try{
            Files.copy(p1,p2, StandardCopyOption.COPY_ATTRIBUTES);  //if target file already exist, the COPY_ATTRIBUTES throws FileAlreadyExists(sub of IOEx.)
        } catch(IOException e){
            System.err.println("target file already exists");
            return false;
        }
        return true;
    }

    public static boolean copyByClasspath (String sourceFile, String targetFile){
        InputStream sourceIS = CopyFile.class.getResourceAsStream("sourceFile.txt");

        Path targetPath = Paths.get(System.getProperty("user.home"),targetFile);
        try{
        Files.copy(sourceIS,targetPath);//without specifying, the method behaves as if StandardCopyOption.COPY_ATTRIBUTES
        } catch (IOException e){
            System.err.println("Writing not successful");
            return false;
        }
        return true;
    }
}