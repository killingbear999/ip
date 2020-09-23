package duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    Ui ui = new Ui();
    ArrayList<String> tasks = new ArrayList<>();
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public void load() {
        try {
            readFileContents();
        } catch (FileNotFoundException e) {
            ui.showFileNotExistMessages();
        }
    }

    public void readFileContents() throws FileNotFoundException {
        File f = new File(filePath);
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            tasks.add(s.nextLine());
        }
    }

    public void updateTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            TaskList taskInitiation = new TaskList(tasks.get(i));
            taskInitiation.initiateTasks();
        }
    }

    public void writeToFile() throws IOException {
        tasks = retrieveTasks();
        FileWriter fw = new FileWriter(filePath);
        for (int i = 0; i < tasks.size(); i++) {
            fw.write(tasks.get(i) + "\n");
        }
        fw.close();
    }

    public static ArrayList<String> retrieveTasks() {
        TaskList objects = new TaskList();
        return objects.returnTasks();
    }

    public void updateFile() {
        try {
            writeToFile();
        } catch (IOException e) {
            ui.showFileNotWriteableMessage(e);
        }
    }
}
