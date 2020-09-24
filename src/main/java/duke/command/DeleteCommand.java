package duke.command;

import duke.Ui;
import duke.task.Task;

import java.util.ArrayList;

public class DeleteCommand extends Command {
    public DeleteCommand(String description, ArrayList<String> tasks) {
        super(description, tasks);
    }

    public void removeTask() {
        Ui ui = new Ui();
        Task task = new Task(description);

        int taskDeleted = task.traceTaskDeleted();
        ui.printTaskRemoved(tasks, taskDeleted);
        tasks.remove(taskDeleted);
        ui.printSum(tasks);
    }
}
