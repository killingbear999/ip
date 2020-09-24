package duke;

import java.io.IOException;
import java.util.ArrayList;

/** This class is to deal with interactions with the user */
public class Ui {
    public Ui() {
    }

    /** It is to show welcome messages to greet the user */
    public void showWelcomeMessages() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

    /** It is to show goodbye message before exiting Duke */
    public void showGoodByeMessage() {
        System.out.println("Bye. Hope to see you again soon!");
    }
    
    /** It is to show the error messages that file does not exit */
    public void showFileNotExistMessages() {
        System.out.println("File does not exist yet");
        System.out.println("Please proceed to enter data");
    }

    /** It is to show the error message that the file is not writeable for some reasons */
    public void showFileNotWriteableMessage(IOException e) {
        System.out.println("Something went wrong: " + e.getMessage());
    }

    /** It is to show error messages that input command is in incorrect format */
    public void printErrorMessage(boolean isEmptyTodo, boolean isEmptyDeadline, boolean isEmptyEvent,
            boolean isCorrectInput) {
        if (isEmptyTodo) {
            System.out.println("OOPS!!! The description of a todo cannot be empty.");
        } else if (isEmptyDeadline) {
            System.out.println("OOPS!!! The description of a deadline cannot be empty.");
        } else if (isEmptyEvent) {
            System.out.println("OOPS!!! The description of an event cannot be empty.");
        } else if (isCorrectInput) {
            System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }

    /** It is to print the list to show all tasks that are currently in the list */
    public void printList(ArrayList<String> tasks) {
        if (tasks.size() == 0) {
            System.out.println("The list is empty.");
        } else if (tasks.size() == 1) {
            System.out.println("Here is the task in your list:");
            System.out.println("1." + tasks.get(0));
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 1; i <= tasks.size(); i++) {
                System.out.println(i + "." + tasks.get(i - 1));
            }
        }
    }
    
    /** It is to print all tasks in the matching list for the command type find */
    public void printMatchingList(ArrayList<String> tasks) {
        if (tasks.size() == 0) {
            System.out.println("The list is empty.");
        } else if (tasks.size() == 1) {
            System.out.println("Here is the matching task in your list:");
            System.out.println("1." + tasks.get(0));
        } else {
            System.out.println("Here are the matching tasks in your list:");
            for (int i = 1; i <= tasks.size(); i++) {
                System.out.println(i + "." + tasks.get(i - 1));
            }
        }
    }

    /** It is to echo command after user has input a new command */
    public void echoCommand(ArrayList<String> tasks) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + tasks.get(tasks.size()-1));
        if (tasks.size() <= 1) {
            System.out.println("Now you have " + tasks.size() + " task in the list.");
        } else {
            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        }
    }

    /** It is to print the task that is finished if command "done" is used */
    public void printTaskDone(ArrayList<String> tasks, int taskFinished) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + tasks.get(taskFinished));
    }

    /** It is to print the task that is deleted if command "delete" is used */
    public void printTaskRemoved(ArrayList<String> tasks, int taskDeleted) {
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + tasks.get(taskDeleted));
    }

    /** It is to print the total number of tasks that are currently in the list */
    public void printSum(ArrayList<String> tasks) {
        if (tasks.size() <= 1) {
            System.out.println("Now you have " + tasks.size() + " task in the list.");
        } else {
            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        }
    }
    
    /** It is to print the error message if the find is empty */
    public void printEmptyFindCommand() {
        System.out.println("OOPS!!! The description of a find cannot be empty.");
    }
    
    /** It is to print the message if no matching result is found */
    public void printEmptyMatchingList() {
        System.out.println("No matching result is found.");
    }

    /** It is to print the message if the date is not found in the list */
    public void printDateNotExistsMessage() {
        System.out.println("Task is not found. Please try another date");
    }

    /** It is to print the task on the specific date */
    public void printTaskOnTheDate(String taskOnTheDate) {
        System.out.println(taskOnTheDate);
    }
    
    /** It is to print the error message if the task is not found for done/delete command type */
    public void printTaskNotFoundMessage() {
        System.out.println("Task is not found. Please re-enter a new task number.");
    }
}
