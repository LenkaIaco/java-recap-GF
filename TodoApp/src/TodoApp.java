import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingFormatArgumentException;

public class TodoApp {

    public void run() {
        String usageInstructions = "$ todo\n" +
                "\n" +
                "Command Line Todo application\n" +
                "=============================\n" +
                "\n" +
                "Command line arguments:\n" +
                "    -l   Lists all the tasks\n" +
                "    -a   Adds a new task\n" +
                "    -r   Removes a task\n" +
                "    -c   Completes a task";
        System.out.println(usageInstructions);
    }

public void executeCommand(String[] args) throws IOException{

        if (args == null) { run(); return;}

        String arg0 = args[0];

        switch(arg0){
            case "-l": listTasks("todoList.txt");
            break;
            case "-a": addNewTask("\\Documents\\JavaProjects\\java_recap_gf\\TodoApp\\src\\todoList.txt", args[1]);
            break;
            case "-r": removeTask(args[1], "/todoList.txt", "\\Documents\\JavaProjects\\java_recap_gf\\TodoApp\\src\\todoList.txt");
            break;
            default: throw new UnsupportedOperationException("Unsupported argument");
        }
}

    public List<String> listTasks(String filepath) {
        List<String> contentList = new ArrayList<>();
        InputStream inputStream = TodoApp.class.getResourceAsStream(filepath);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        try (br) {
            contentList = br.lines().toList();
        } catch (IOException ioe) {
            System.err.println("Reading from file failed");
        }

        if (contentList.size() == 0){
            System.out.println("No todos for today! :)");
        } else {
            for (String s : contentList) {
                System.out.println(s);
            }
        }

        return contentList; //returning String(instead of void) makes testing easier
    }



public String addNewTask(String filePathOS, String newTask) throws IOException{
        String targetPath  = System.getProperty("user.home")+filePathOS;
        if (newTask == null || newTask.isEmpty() || newTask.isBlank()){
            throw new MissingFormatArgumentException("Unable to add: no task provided");
        }
        try {
            Files.writeString(Path.of(targetPath), newTask, StandardOpenOption.APPEND);
        } catch (IOException e){throw new IOException("Writing to the suggested file not successful");}

        return targetPath;
    }


    public String removeTask (String argument, String filePath, String filePathOS) throws IOException {
        if (argument ==null||argument.length()==0){
            throw new MissingFormatArgumentException("Unable to remove: no index provided");
        }
        argument = argument.trim();
        int num = 0;
        try {
             num = Integer.valueOf(argument);
        } catch (NumberFormatException ne){
           throw new NumberFormatException("Unable to remove: index is not a number");
        }

        InputStream intputStream = TodoApp.class.getResourceAsStream(filePath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(intputStream));

        List<String> fileLines = new ArrayList<>();

        try(bufferedReader){
            List <String> l = bufferedReader.lines().toList();
            fileLines.addAll(l);
        } catch (IOException e){
            throw new IOException("Reading from file not successful.");
        }

        if (fileLines.size()<num || fileLines.size()==0){
            throw new IndexOutOfBoundsException("Unable to remove: index is out of bound");
        }

        String lineFound = fileLines.get(num-1);

        fileLines.remove(num-1);

//        filePathOS = System.getProperty("user.home")+filePathOS;
// for files out of this the running directory (=no SecurityException) ok to use System.getProperty + Path
        File file = new File("todoList.txt");

        try {
            Files.write(file.toPath(), fileLines, StandardOpenOption.CREATE);
        } catch (IOException e){throw new IOException("Modifying file not successful.");}

        return lineFound;
    }



}
