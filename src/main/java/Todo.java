public class Todo extends List {

    public Todo(String description, int commandCount) {
        super(description, commandCount);
    }

    @Override
    public String storeObject(String description, int commandCount) {
        int toDoPosition = description.indexOf(" ", 1) + 1;
        String taskName = description.substring(toDoPosition);
        String stringReturn =  "[T][" + "\u2718" + "] " + taskName;
        return stringReturn;
    }
}
