package duke.task;

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

    public int traceTaskDone() {
        taskTracers = description.split(" ");
        taskFinished = Integer.parseInt(taskTracers[1]) - 1;
        return taskFinished;
    }

    public int traceTaskDeleted() {
        taskTracers = description.split(" ");
        taskDeleted = Integer.parseInt(taskTracers[1]) - 1;
        return taskDeleted;
    }
    
    public String traceTask() {
        String[] taskTracers = description.split(" ");
        return taskTracers[1];
    }
}
