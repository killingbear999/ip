public class List {
    protected String description;
    protected int commandCount;
    public static int taskFinished;

    public List(String description, int commandCount) {
        this.description = description;
        this.commandCount = commandCount;
    }

    public String storeObject(String description, int commandCount) {
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