import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        start();

        String exitKeyword = "bye";
        String[] list = new String[100];
        String listDisplay = "list";
        int commandCount = 0;

        Scanner userInput = new Scanner(System.in);

        while (true) {
            String userCommand = userInput.nextLine();
            if (userCommand.equals(exitKeyword)) {
                exit();
                break;
            } else if (userCommand.equals(listDisplay)) {
                printList(list, commandCount);
            } else {
                echo(userCommand);
                store(list, userCommand, commandCount);
                commandCount = commandCount + 1;
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

    public static void echo(String userCommand) {
        System.out.println("added: " + userCommand);
    }

    public static void store(String[] list, String userCommand, int commandCount) {
        list[commandCount] = userCommand;
    }

    public static void printList(String[] list, int commandCount) {
        for (int i = 1; i <= commandCount; i++) {
            System.out.println(i + ". " + list[i-1]);
        }
    }
}
