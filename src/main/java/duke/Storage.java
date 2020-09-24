package duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/** This class is to read data from the local disk and write new data to the local disk */
public class Storage {
    Ui ui = new Ui();
    ArrayList<String> tasks = new ArrayList<>();
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /** It is to load the data from the local disk */
    public void load() {
        try {
            readFileContents();
        } catch (FileNotFoundException e) {
            ui.showFileNotExistMessages();
        }
    }

    /** It is to read the data from the local disk if the file exists */
    public void readFileContents() throws FileNotFoundException {
        File f = new File(filePath);
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            tasks.add(s.nextLine());
        }
    }

    /** It is to initialise the arraylist with the data from the local disk */
    public void updateTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            TaskList taskInitiation = new TaskList(tasks.get(i));
            taskInitiation.initiateTasks();
        }
    }
    
    /** It is to retrieve data from the list and ready to be written to the local disk */
    public static ArrayList<String> retrieveTasks() {
        TaskList objects = new TaskList();
        return objects.returnTasks();
    }
    
    /** It is to write new data to the local disk */
    public void updateFile() {
        try {
            writeToFile();
        } catch (IOException e) {
            ui.showFileNotWriteableMessage(e);
        }
    }

    /** It is to write new data to the local disk if the file is writeable */
    public void writeToFile() throws IOException {
        tasks = retrieveTasks();
        FileWriter fw = new FileWriter(filePath);
        for (int i = 0; i < tasks.size(); i++) {
            fw.write(tasks.get(i) + "\n");
        }
        fw.close();
    }
}
