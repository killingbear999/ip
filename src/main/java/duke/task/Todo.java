package duke.task;

/** This class is to extract the main body of a specific todo */
public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    /** It is to return the main body of the todo before it is written to the list */
    @Override
    public String storeObject() {
        int toDoPosition = description.indexOf(" ", 1) + 1;
        String taskName = description.substring(toDoPosition);
        String stringReturn = "[T][" + "\u2718" + "] " + taskName;
        return stringReturn;
    }
}
