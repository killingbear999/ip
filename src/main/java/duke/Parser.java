package duke;

/** This class is to deal with making senseof the user command */
public class Parser {
    private String userCommand;

    public Parser(String userCommand) {
        this.userCommand = userCommand;
    }

    /** It is to execute command such as "list", "done", "delete" and store the input command */
    public void executeCommand() {
        TaskList command = new TaskList(userCommand);
        if (userCommand.equals("list")) {
            command.printList();
        } else if (userCommand.startsWith("done")) {
            command.markAsDone();
        } else if (userCommand.startsWith("delete")) {
            command.deleteTask();
        } else if (userCommand.startsWith("find")) {
            command.findTask();
        } else if (userCommand.startsWith("date")) {
            command.findDate();
        } else {
            command.storeCommand();
        }
    }

    /** It is to exit the chatbot after the command "bye" is input */
    public boolean shouldExit() {
        boolean isExit = false;
        if (userCommand.equals("bye")) {
            isExit = true;
        }
        return isExit;
    }
}
