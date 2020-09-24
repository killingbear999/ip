package duke.task;

/** This class is to handle command types such as deadline, event, todo, done and delete */
public class Task {
    public static final int WHITESPACE_MANAGEMENT = 1;
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
    
    /** It is to return the int number of the position/ranking of the task done in the list */
    public int traceTaskDone() {
        taskTracers = description.split(" ");
        taskFinished = Integer.parseInt(taskTracers[1]) - WHITESPACE_MANAGEMENT;
        return taskFinished;
    }
    
    /** It is to identify the int number of the position/ranking of the task that is deleted in the list */
    public int traceTaskDeleted() {
        taskTracers = description.split(" ");
        taskDeleted = Integer.parseInt(taskTracers[1]) - WHITESPACE_MANAGEMENT;
        return taskDeleted;
    }
    
    public String traceTask() {
        String[] taskTracers = description.split(" ");
        return taskTracers[1];
    }
}
