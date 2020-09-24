package duke.command;

import duke.Ui;
import duke.exception.DoneException;
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
        try {
            traceTaskDone();
            checkValidTask();
            finishTask(taskDone, taskFinished);
            ui.printTaskDone(tasks, taskFinished);
        } catch (DoneException e) {
            ui.printTaskNotFoundMessage();
        }
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    public void traceTaskDone() throws DoneException {
        if (description.length() <= 4) {
            throw new DoneException();
        }
        Task task = new Task(description);
        taskFinished = task.traceTaskDone();
        isDone = true;
    }
    
    public void checkValidTask() throws DoneException {
        if (taskFinished >= tasks.size()) {
            throw new DoneException();
        }
        taskDone = tasks.get(taskFinished);
        int taskPosition = taskDone.indexOf(" ", 1) + 1;
        int taskLength = taskDone.length();
        taskDone = taskDone.substring(taskPosition, taskLength);
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
