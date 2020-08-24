import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        start();

        String exitKeyword = "bye";
        String listDisplayKeyword = "list";
        String statusKeyword = "done";

        Scanner userInput = new Scanner(System.in);

        while (true) {
            String userCommand = userInput.nextLine();
            if (userCommand.equals(exitKeyword)) {
                exit();
                break;
            } else {
                Task t = new Task(userCommand);
                if (userCommand.equals(listDisplayKeyword)) {
                    t.printList();
                } else if (userCommand.startsWith(statusKeyword)) {
                    t.markAsDone();
                } else {
                    t.echo();
                    t.store();
                }
            }
        }
    }

    public static void start() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        greet();
    }

    public static void greet() {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

    public static void exit() {
        System.out.println("Bye. Hope to see you again soon!");
    }
}
