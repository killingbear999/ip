package duke.task;

import java.util.ArrayList;

/** This class is to handle command types such as deadline, event, todo, done and delete */
public class Task {
    protected String description;
    protected String[] taskTracers;
    public static int taskFinished;
    public static int taskDeleted;

    public Task(String description) {
        this.description = description;
    }

    public String storeObject() {
        return null;
    }
    
    /** It is to identify the main body of the task that is marked as done by the user */
    public String traceTaskDone(ArrayList<String> tasks) {
        String[] taskTracers = description.split(" ");
        taskFinished = Integer.parseInt(taskTracers[1]) - 1;
        String taskDone = tasks.get(taskFinished);
        int taskPosition = taskDone.indexOf(" ", 1) + 1;
        int taskLength = taskDone.length();
        taskDone = taskDone.substring(taskPosition, taskLength);
        return taskDone;
    }
    
    /** It is to return the int number of the position/ranking of the task done in the list */
    public int traceTaskDone() {
        taskTracers = description.split(" ");
        taskFinished = Integer.parseInt(taskTracers[1]) - 1;
        return taskFinished;
    }
    
    /** It is to identify the int number of the position/ranking of the task that is deleted in the list */
    public int traceTaskDeleted() {
        taskTracers = description.split(" ");
        taskDeleted = Integer.parseInt(taskTracers[1]) - 1;
        return taskDeleted;
    }
}
