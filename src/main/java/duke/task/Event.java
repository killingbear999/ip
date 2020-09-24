package duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {

    public Event(String description) {
        super(description);
    }

    @Override
    public String storeObject() {
        int firstBlankSpacePosition = description.indexOf(" ", 1) + 1;
        int endingPosition = description.indexOf("/") - 1;
        int timingPosition = description.indexOf("at") + 3;
        String taskName = description.substring(firstBlankSpacePosition, endingPosition);
        String eventTime = description.substring(timingPosition);
        if (eventTime.contains("-")) {
            LocalDate d = LocalDate.parse(eventTime);
            eventTime = d.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        }
        String stringReturn =  "[E][" + "\u2718" + "] " + taskName + " (at: " + eventTime + ")";
        return stringReturn;
    }
}
