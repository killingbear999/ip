package duke;

public class Parser {
    private String userCommand;

    public Parser(String userCommand) {
        this.userCommand = userCommand;
    }

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
        } else {
            command.storeCommand();
        }
    }

    public boolean shouldExit() {
        boolean isExit = false;
        if (userCommand.equals("bye")) {
            isExit = true;
        }
        return isExit;
    }
}
