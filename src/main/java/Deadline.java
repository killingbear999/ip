public class Deadline extends List {

    public Deadline(String description, int commandCount) {
        super(description, commandCount);
    }

    @Override
    public String storeObject(String description, int commandCount) {
        String object = description.substring(description.indexOf(" ", 1) + 1,
                description.indexOf("/") - 1);
        String deadline = description.substring(description.indexOf("by") + 3);
        return "[D][" + "\u2718" + "] " + object + " (by: " + deadline + ")";
    }
}
