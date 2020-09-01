public class Event extends List {

    public Event(String description, int commandCount) {
        super(description, commandCount);
    }

    @Override
    public String storeObject(String description, int commandCount) {
        String object = description.substring(description.indexOf(" ", 1) + 1,
                description.indexOf("/") - 1);
        String deadline = description.substring(description.indexOf("at") + 3);
        return "[E][" + "\u2718" + "] " + object + " (at: " + deadline + ")";
    }
}
