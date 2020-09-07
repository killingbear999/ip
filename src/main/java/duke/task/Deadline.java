package duke.task;

public class Deadline extends List {

    public Deadline(String description) {
        super(description);
    }

    @Override
    public String storeObject(String description) {
        int firstBlankSpacePosition = description.indexOf(" ", 1) + 1;
        int endingPosition = description.indexOf("/") - 1;
        int deadlinePosition = description.indexOf("by") + 3;
        String taskName = description.substring(firstBlankSpacePosition, endingPosition);
        String deadline = description.substring(deadlinePosition);
        String stringReturn =  "[D][" + "\u2718" + "] " + taskName + " (by: " + deadline + ")";
        return stringReturn;
    }
}
