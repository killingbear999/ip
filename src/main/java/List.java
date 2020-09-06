public class List {
    protected String description;
    public static int taskFinished;

    public List(String description) {
        this.description = description;
    }

    public String storeObject(String description) {
        return null;
    }

    public String traceTask(String description, String[] lists) {
        String[] taskTracers = description.split(" ");
        taskFinished = Integer.parseInt(taskTracers[1]) - 1;
        int taskPosition = lists[taskFinished].indexOf(" ", 1) + 1;
        int taskLength = lists[taskFinished].length();
        String taskDone = lists[taskFinished].substring(taskPosition, taskLength);
        return taskDone;
    }

    public int returnTaskFinished() {
        return taskFinished;
    }
}
