package duke;

import java.util.Scanner;

/**
 * The Duke program is a desktop chatbot, opitimisd for use via a Command Line Interface.
 *
 * @author Wang Zihao
 * @version v0.2
 * @since 2020-09-28
 */
public class Duke {
    /** It is the main function that will run the chatbot Duke from greeting to goodbye */
    public static void main(String[] args) {
        String filePath = "../duke.txt";
        boolean isExit;

        Ui ui = new Ui();
        Storage storage = new Storage(filePath);

        ui.showWelcomeMessages();
        storage.load();
        storage.updateTasks();

        Scanner userInput = new Scanner(System.in);

        while (true) {
            String userCommand = userInput.nextLine();
            Parser parser = new Parser(userCommand);
            isExit = parser.shouldExit();
            if (isExit) {
                ui.showGoodByeMessage();
                break;
            } else {
                parser.executeCommand();
                storage.updateFile();
            }
        }
    }
}
