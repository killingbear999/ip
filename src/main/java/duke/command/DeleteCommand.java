package duke.command;

import duke.Ui;
import duke.exception.DeleteException;
import duke.task.Task;

import java.util.ArrayList;

/** This class is to handle the command type delete */
public class DeleteCommand extends Command {
    public DeleteCommand(String description, ArrayList<String> tasks) {
        super(description, tasks);
    }

    /** It is to delete a specific task identified by the user */
    public void removeTask() {
        Ui ui = new Ui();
        try {
            deleteTask();
        } catch (DeleteException e) {
            ui.printTaskNotFoundMessage();
        }
    }
    
    public void deleteTask() throws DeleteException {
        Ui ui = new Ui();
        Task task = new Task(description);
        if (description.length() <= 6) {
            throw new DeleteException();
        }
        int taskDeleted = task.traceTaskDeleted();
        if (taskDeleted >= tasks.size()) {
            throw new DeleteException();
        }
        ui.printTaskRemoved(tasks, taskDeleted);
        tasks.remove(taskDeleted);
        ui.printSum(tasks);
    }
}
