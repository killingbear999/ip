import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        startChat();

        String exitKeyword = "bye";
        String listDisplayKeyword = "list";
        String statusKeyword = "done";

        Scanner userInput = new Scanner(System.in);

        while (true) {
            String userCommand = userInput.nextLine();
            if (userCommand.equals(exitKeyword)) {
                exitChat();
                break;
            } else {
                executeCommand(listDisplayKeyword, statusKeyword, userCommand);
            }
        }
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
