package duke.command;

import duke.Ui;
import duke.exception.DateException;

import java.util.ArrayList;

public class FindCommand extends Command {
    private String date;

    public FindCommand(String description, ArrayList<String> tasks) {
        super(description, tasks);
    }

    public void findTask() {
        Ui ui = new Ui();
        int datePosition = description.indexOf(" ", 1) + 1;
        date = description.substring(datePosition);
        try {
            locateTask();
        } catch (DateException e) {
            ui.printDateNotExistsMessage();
        }
    }

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
