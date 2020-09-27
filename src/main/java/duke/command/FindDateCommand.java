package duke.command;

import duke.Ui;
import duke.exception.DateException;

import java.util.ArrayList;

/** This class is to deal with the command type date */
public class FindDateCommand extends Command {
    public static final int WHITESPACE_MANAGEMENT = 1;
    private String date;

    public FindDateCommand(String description, ArrayList<String> tasks) {
        super(description, tasks);
    }

    /** It is to find the task on the specific date
     *
     * @param dataPosition The starting position of the main content from the command entered by the user
     * @param date The specific date that the user would like to search for
     */
    public void findTask() {
        Ui ui = new Ui();
        int datePosition = description.indexOf(" ", 1) + WHITESPACE_MANAGEMENT;
        date = description.substring(datePosition);
        try {
            locateTask();
        } catch (DateException e) {
            ui.printDateNotExistsMessage();
        }
    }

    /** It is to find the task on the specific date if the format for the command type date is correct
     *
     * @param hasTask True if there are tasks on the date
     * @param taskOnTheDate The main content of the task on the date
     * @param currentTask The current task on the list while searching through the list
     * @throws DateException If no task found on the date or date entered is in incorrect format
     */
    public void locateTask() throws DateException {
        Ui ui = new Ui();
        boolean hasTask = false;
        String taskOnTheDate = null;

        for (String currentTask : tasks) {
            if (currentTask.contains(date)) {
                taskOnTheDate = currentTask;
                hasTask = true;
                break;
            }
        }

        if (!hasTask) {
            throw new DateException();
        } else {
            ui.printTaskOnTheDate(taskOnTheDate);
        }
    }
}
