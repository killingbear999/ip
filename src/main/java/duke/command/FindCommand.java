package duke.command;

import duke.Ui;
import duke.exception.FindException;
import duke.task.Task;
import java.util.ArrayList;

/** This class is to deal with the command type find */
public class FindCommand extends Command {
    public FindCommand(String description, ArrayList<String> tasks) {
        super(description, tasks);
    }
    
    /** It is to locate the task specified by the user */
    public void locateTask() {
        Ui ui = new Ui();
        try {
            findTask();
        } catch (FindException e) {
            ui.printEmptyFindCommand();
        }
    }
    
    /** It is to trace the specific task if the format for the command type find is correct */
    public void findTask() throws FindException {
        if (description.length() <= 4) {
            throw new FindException();
        }
        Ui ui = new Ui();
        Task task = new Task(description);
        String object = task.traceTask();
        ArrayList<String> TasksFound = new ArrayList<>();
    
        for (String currentTask : tasks) {
            if (currentTask.contains(object)) {
                TasksFound.add(currentTask);
            }
        }
        
        if (TasksFound.size() != 0) {
            ui.printMatchingList(TasksFound);
        } else {
            ui.printEmptyMatchingList();
        }
    }
}
