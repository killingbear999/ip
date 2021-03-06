package duke.command;

import duke.Ui;
import duke.exception.DoneException;
import duke.task.Task;

import java.util.ArrayList;

/** This class is to handle the commmand type done */
public class FinishCommand extends Command {
    public static final int WHITESPACE_MANAGEMENT = 1;
    private static int taskFinished = 0;
    private static String taskDone;

    public FinishCommand(String description, ArrayList<String> tasks) {
        super(description, tasks);
    }

    /** It is to process the command if the command type is "done" */
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

    /** It is get the status of done (i.e. tick) and not done (i.e. cross) */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }
    
    /** It is to trace the main body of the task that is marked as done by the user
     *
     * @param taskFinished The sequence of the task, which is marked as done, in the list
     * @param isDone True if the task is marked as done
     * @throws DoneException If done is entered in incorrect format
     */
    public void traceTaskDone() throws DoneException {
        if (description.length() <= 4) {
            throw new DoneException();
        }
        Task task = new Task(description);
        taskFinished = task.traceTaskDone();
        isDone = true;
    }
    
    /** It is to extract the main body of the task done if the format for command type done is correct
     *
     * @param taskFinished The sequence of the task, which is marked as done, in the list
     * @param taskDone The main content of the task that is marked as done
     * @param taskPosition The starting position of the main body of the task
     * @param taskLength The length of the task
     * @throws DoneException If the task to be marked as done does not exist
     */
    public void checkValidTask() throws DoneException {
        if (taskFinished >= tasks.size()) {
            throw new DoneException();
        }
        taskDone = tasks.get(taskFinished);
        int taskPosition = taskDone.indexOf(" ", 1) + WHITESPACE_MANAGEMENT;
        int taskLength = taskDone.length();
        taskDone = taskDone.substring(taskPosition, taskLength);
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
