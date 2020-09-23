package duke.command;

import duke.Ui;
import duke.command.Command;
import duke.task.Task;

import java.util.ArrayList;

public class FinishCommand extends Command {
    private static int taskFinished = 0;
    private static String taskDone;

    public FinishCommand(String description, ArrayList<String> tasks) {
        super(description, tasks);
    }

    public void markAsFinished() {
        Ui ui = new Ui();
        traceTaskDone();
        finishTask(taskDone, taskFinished);
        ui.printTaskDone(tasks, taskFinished);
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    public void traceTaskDone() {
        Task task = new Task(description);
        taskDone = task.traceTaskDone(tasks);
        taskFinished = task.returnTaskFinished();
        isDone = true;
    }

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
