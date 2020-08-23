import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        start();

        String userCommand;
        String exitKeyword = "bye";
        boolean checkExitKeyword = false;
        Scanner userInput = new Scanner(System.in);
        userCommand = userInput.nextLine();

        do {
            if (userCommand.equals(exitKeyword) == true) {
                exit();
                checkExitKeyword = true;
                break;
            } else {
                response(userCommand);
                userCommand = userInput.nextLine();
            }
        } while (checkExitKeyword == false);
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

    public static void response(String userCommand) {
        System.out.println(userCommand);
    }
}
