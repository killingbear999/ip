package duke.task;

/** This class is to extract the main body of a specific todo */
public class Todo extends Task {
    
    public static final int WHITESPACE_MANAGEMENT = 1;
    
    public Todo(String description) {
        super(description);
    }

    /** It is to return the main body of the todo before it is written to the list
     *
     * @param todoPosition The starting position of the main content of todo
     * @param taskName The main content of todo
     * @return The string containing the task and its status
     */
    @Override
    public String storeObject() {
        int toDoPosition = description.indexOf(" ", 1) + WHITESPACE_MANAGEMENT;
        String taskName = description.substring(toDoPosition);
        String stringReturn = "[T][" + "\u2718" + "] " + taskName;
        return stringReturn;
    }
}
