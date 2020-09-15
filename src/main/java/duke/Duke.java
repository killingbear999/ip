package duke;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Duke {
    public static void main(String[] args) {
        startChat();

        String exitKeyword = "bye";
        String listDisplayKeyword = "list";
        String statusKeyword = "done";
        String filePath = "/Users/zihaowang/Desktop/CS2113T/ip/duke.txt";
        String[] tasks = new String[100];
        int commandCount = 0;
        int tasksCount = 0;

        Scanner userInput = new Scanner(System.in);

        try {
            tasksCount = readFileContents(filePath, tasks);
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist yet");
            System.out.println("Please proceed to enter data");
        }

        updateTasks(tasks, tasksCount);

        while (true) {
            String userCommand = userInput.nextLine();
            if (userCommand.equals(exitKeyword)) {
                exitChat();
                break;
            } else {
                executeCommand(listDisplayKeyword, statusKeyword, userCommand);
            }
        }

        tasks = retrieveTasks();
        commandCount = retrieveCommandCount();

        try {
            appendToFile(filePath, tasks, commandCount);
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    public static int readFileContents(String filePath, String[] tasks) throws FileNotFoundException {
        File f = new File(filePath);
        Scanner s = new Scanner(f);
        int count = 0;
        while(s.hasNext()) {
            tasks[count] = s.nextLine();
            count = count + 1;
        }
        return count;
    }

    public static void appendToFile(String filePath, String[] tasks, int commandCount) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        for (int i = 0; i < commandCount; i++) {
            fw.write(tasks[i] + "\n");
        }
        fw.close();
    }

    public static void executeCommand(String listDisplayKeyword, String statusKeyword, String userCommand) {
        Task command = new Task(userCommand);
        if (userCommand.equals(listDisplayKeyword)) {
            command.printList();
        } else if (userCommand.startsWith(statusKeyword)) {
            command.markAsDone();
        } else {
            command.storeCommand();
            command.echoCommand();
        }
    }

    public static void updateTasks(String[] tasks, int tasksCount) {
        for (int i = 0; i < tasksCount; i++) {
            Task taskInitiation = new Task(tasks[i]);
            taskInitiation.initiateTasks();
        }
    }

    public static String[] retrieveTasks() {
        Task objects = new Task();
        return objects.returnTasks();
    }

    public static int retrieveCommandCount() {
        Task count = new Task();
        return count.returnCount();
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
