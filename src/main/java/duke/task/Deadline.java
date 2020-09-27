package duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** This class is to extract the main body of a specific deadline */
public class Deadline extends Task {
    
    public static final int WHITESPACE_MANAGEMENT = 1;
    public static final int WHITESPACE_WORDS_MANAGEMENT = 3;
    
    public Deadline(String description) {
        super(description);
    }
    
    /** It is to return the main body of the deadline before it is written to the list
     *
     * @param firstBlankSpacePosition The starting position of the first blank space
     * @param endingPosition The starting position of the character '/'
     * @param deadlinePosition The starting position of the deadline
     * @param taskName The main content of the task
     * @param deadline The main content of the deadline
     * @return The string containing the task and deadline and its status
     */
    @Override
    public String storeObject() {
        int firstBlankSpacePosition = description.indexOf(" ", 1) + WHITESPACE_MANAGEMENT;
        int endingPosition = description.indexOf("/") - WHITESPACE_MANAGEMENT;
        int deadlinePosition = description.indexOf("by") + WHITESPACE_WORDS_MANAGEMENT;
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
