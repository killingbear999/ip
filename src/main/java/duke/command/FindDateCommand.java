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

    /** It is to find the task on the specific date */
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

    /** It is to find the task on the specific date if the format for the command type date is correct */
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
