package duke.command;

import duke.Ui;
import duke.exception.FindException;
import duke.task.Task;
import java.util.ArrayList;

public class FindCommand extends Command {
    public FindCommand(String description, ArrayList<String> tasks) {
        super(description, tasks);
    }
    
    public void locateTask() {
        Ui ui = new Ui();
        try {
            findTask();
        } catch (FindException e) {
            ui.printEmptyFindCommand();
        }
    }
    
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
