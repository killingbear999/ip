public class Todo extends List {

    public Todo(String description) {
        super(description);
    }

    @Override
    public String storeObject(String description) {
        int toDoPosition = description.indexOf(" ", 1) + 1;
        String taskName = description.substring(toDoPosition);
        String stringReturn = "[T][" + "\u2718" + "] " + taskName;
        return stringReturn;
    }

}
