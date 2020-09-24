package duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** This class is to extract the main body of a specific deadline */
public class Deadline extends Task {

    public Deadline(String description) {
        super(description);
    }
    
    /** It is to return the main body of the deadline before it is written to the list */
    @Override
    public String storeObject() {
        int firstBlankSpacePosition = description.indexOf(" ", 1) + 1;
        int endingPosition = description.indexOf("/") - 1;
        int deadlinePosition = description.indexOf("by") + 3;
        String taskName = description.substring(firstBlankSpacePosition, endingPosition);
        String deadline = description.substring(deadlinePosition);
        if (deadline.contains("-")) {
            LocalDate d = LocalDate.parse(deadline);
            deadline = d.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        }
        String stringReturn =  "[D][" + "\u2718" + "] " + taskName + " (by: " + deadline + ")";
        return stringReturn;
    }
}
