package duke.task;

public class Event extends Task {

    public Event(String description) {
        super(description);
    }

    /** It is to return the main body of the event before it is written to the list */
    @Override
    public String storeObject() {
        int firstBlankSpacePosition = description.indexOf(" ", 1) + 1;
        int endingPosition = description.indexOf("/") - 1;
        int timingPosition = description.indexOf("at") + 3;
        String taskName = description.substring(firstBlankSpacePosition, endingPosition);
        String eventTime = description.substring(timingPosition);
        String stringReturn =  "[E][" + "\u2718" + "] " + taskName + " (at: " + eventTime + ")";
        return stringReturn;
    }
}
