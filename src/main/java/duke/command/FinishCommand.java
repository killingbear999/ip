package duke.command;

import duke.Ui;
import duke.task.Task;

import java.util.ArrayList;

public class FinishCommand extends Command {
    private static int taskFinished = 0;
    private static String taskDone;

    public FinishCommand(String description, ArrayList<String> tasks) {
        super(description, tasks);
    }

    /** It is to process the command if the command type is "done" */
    public void markAsFinished() {
        Ui ui = new Ui();
        traceTaskDone();
        finishTask(taskDone, taskFinished);
        ui.printTaskDone(tasks, taskFinished);
    }

    /** It is get the status of done (i.e. tick) and not done (i.e. cross) */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    /** It is to trace the main body of the task that is marked as done by the user */
    public void traceTaskDone() {
        Task task = new Task(description);
        taskDone = task.traceTaskDone(tasks);
        taskFinished = task.returnTaskFinished();
        isDone = true;
    }

    /** It is to update the status of the task that is done to the list */
    public void finishTask(String taskDone, int taskFinished) {
        if (tasks.get(taskFinished).contains("[T]")) {
            tasks.set(taskFinished, "[T][" + getStatusIcon() + "] " + taskDone);
        } else if (tasks.get(taskFinished).contains("[D]")) {
            tasks.set(taskFinished, "[D][" + getStatusIcon() + "] " + taskDone);
        } else if (tasks.get(taskFinished).contains("[E]")) {
            tasks.set(taskFinished, "[E][" + getStatusIcon() + "] " + taskDone);
        }
    }
}
