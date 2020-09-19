package duke.task;

import java.util.ArrayList;

public class Task {
    protected String description;
    public static int taskFinished;
    public static int taskDeleted;

    public Task(String description) {
        this.description = description;
    }

    public String storeObject() {
        return null;
    }

    public String traceTaskDone(ArrayList<String> tasks) {
        String[] taskTracers = description.split(" ");
        taskFinished = Integer.parseInt(taskTracers[1]) - 1;
        String taskDone = tasks.get(taskFinished);
        int taskPosition = taskDone.indexOf(" ", 1) + 1;
        int taskLength = taskDone.length();
        taskDone = taskDone.substring(taskPosition, taskLength);
        return taskDone;
    }

    public int returnTaskFinished() {
        return taskFinished;
    }

    public int traceTaskDeleted() {
        String[] taskTracers = description.split(" ");
        taskDeleted = Integer.parseInt(taskTracers[1]) - 1;
        return taskDeleted;
    }
}
