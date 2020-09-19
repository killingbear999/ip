package duke;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        startChat();

        String exitKeyword = "bye";
        String listDisplayKeyword = "list";
        String statusKeyword = "done";
        String deleteKeyword = "delete";
        String filePath = "/Users/zihaowang/Desktop/CS2113T/ip/duke.txt";
        ArrayList<String> tasks = new ArrayList<>();

        Scanner userInput = new Scanner(System.in);

        try {
            readFileContents(filePath, tasks);
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist yet");
            System.out.println("Please proceed to enter data");
        }

        updateTasks(tasks);

        while (true) {
            String userCommand = userInput.nextLine();
            if (userCommand.equals(exitKeyword)) {
                exitChat();
                break;
            } else {
                executeCommand(listDisplayKeyword, statusKeyword, deleteKeyword, userCommand);
            }
        }

        tasks = retrieveTasks();

        try {
            writeToFile(filePath, tasks);
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    public static void readFileContents(String filePath, ArrayList<String> tasks) throws FileNotFoundException {
        File f = new File(filePath);
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            tasks.add(s.nextLine());
        }
    }

    public static void writeToFile(String filePath, ArrayList<String> tasks) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        for (int i = 0; i < tasks.size(); i++) {
            fw.write(tasks.get(i) + "\n");
        }
        fw.close();
    }

    public static void executeCommand(String listDisplayKeyword, String statusKeyword, String deleteKeyword,
                                      String userCommand) {
        DataManager command = new DataManager(userCommand);
        if (userCommand.equals(listDisplayKeyword)) {
            command.printList();
        } else if (userCommand.startsWith(statusKeyword)) {
            command.markAsDone();
        } else if (userCommand.startsWith(deleteKeyword)) {
            command.deleteTask();
        } else {
            command.storeCommand();
            command.echoCommand();
        }
    }

    public static void updateTasks(ArrayList<String> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            DataManager taskInitiation = new DataManager(tasks.get(i));
            taskInitiation.initiateTasks();
        }
    }

    public static ArrayList<String> retrieveTasks() {
        DataManager objects = new DataManager();
        return objects.returnTasks();
    }

    public static void startChat() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        greetUser();
    }

    public static void greetUser() {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

    public static void exitChat() {
        System.out.println("Bye. Hope to see you again soon!");
    }
}
