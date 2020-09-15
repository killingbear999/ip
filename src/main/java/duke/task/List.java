package duke.task;

import java.util.ArrayList;

public class List {
    protected String description;
    public static int taskFinished;

    public List(String description) {
        this.description = description;
    }

    public String storeObject(String description) {
        return null;
    }

    public String traceTask(String description, ArrayList<String> tasks) {
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
}
