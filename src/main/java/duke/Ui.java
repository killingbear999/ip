package duke;

import java.io.IOException;
import java.util.ArrayList;

public class Ui {
    public Ui() {
    }

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

    public void showGoodByeMessage() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public void showFileNotExistMessages() {
        System.out.println("File does not exist yet");
        System.out.println("Please proceed to enter data");
    }

    public void showFileNotWriteableMessage(IOException e) {
        System.out.println("Something went wrong: " + e.getMessage());
    }

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

    public void echoCommand(ArrayList<String> tasks) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + tasks.get(tasks.size()-1));
        if (tasks.size() <= 1) {
            System.out.println("Now you have " + tasks.size() + " task in the list.");
        } else {
            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        }
    }

    public void printTaskDone(ArrayList<String> tasks, int taskFinished) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + tasks.get(taskFinished));
    }

    public void printTaskRemoved(ArrayList<String> tasks, int taskDeleted) {
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + tasks.get(taskDeleted));
    }

    public void printSum(ArrayList<String> tasks) {
        if (tasks.size() <= 1) {
            System.out.println("Now you have " + tasks.size() + " task in the list.");
        } else {
            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        }
    }
    
    public void printEmptyFindCommand() {
        System.out.println("OOPS!!! The description of a find cannot be empty.");
    }
    
    public void printEmptyMatchingList() {
        System.out.println("No matching result is found.");
    }

    public void printDateNotExistsMessage() {
        System.out.println("Task is not found. Please try another date");
    }

    public void printTaskOnTheDate(String taskOnTheDate) {
        System.out.println(taskOnTheDate);
    }
    
    public void printTaskNotFoundMessage() {
        System.out.println("Task is not found. Please re-enter a new task number.");
    }
}
