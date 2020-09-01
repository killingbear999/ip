public class Event extends List {

    public Event(String description, int commandCount) {
        super(description, commandCount);
    }

    @Override
    public String storeObject(String description, int commandCount) {
        int firstBlankSpacePosition = description.indexOf(" ", 1) + 1;
        int endingPosition = description.indexOf("/") - 1;
        int timingPosition = description.indexOf("at") + 3;
        String taskName = description.substring(firstBlankSpacePosition, endingPosition);
        String eventTime = description.substring(timingPosition);
        String stringReturn =  "[E][" + "\u2718" + "] " + taskName + " (at: " + eventTime + ")";
        return stringReturn;
    }
}
