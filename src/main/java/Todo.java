public class Todo extends List {

    public Todo(String description, int commandCount) {
        super(description, commandCount);
    }

    @Override
    public String storeObject(String description, int commandCount) {
        String object = description.substring(description.indexOf(" ", 1) + 1);
        return "[T][" + "\u2718" + "] " + object;
    }

    public int returnCommandCount() {
        return commandCount;
    }
}
