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

    public String traceTask(String description, String[] list) {
        String[] taskTracer = description.split(" ");
        taskFinished = Integer.parseInt(taskTracer[1]) - 1;
        int taskPosition = list[taskFinished].indexOf(" ", 1) + 1;
        int taskLength = list[taskFinished].length();
        String taskDone = list[taskFinished].substring(taskPosition, taskLength);
        return taskDone;
    }

    public int returnTaskFinished() {
        return taskFinished;
    }
}
