package duke.command;

import java.util.ArrayList;

public class Command {
    protected boolean isDone;
    protected boolean isCorrectInput;
    protected boolean isEmptyTodo;
    protected boolean isEmptyDeadline;
    protected boolean isEmptyEvent;
    protected String description;
    public static ArrayList<String> tasks = new ArrayList<>();

    public Command(String description, ArrayList<String> tasks) {
        this.description = description;
        this.tasks = tasks;
        this.isCorrectInput = true;
        this.isEmptyTodo = false;
        this.isEmptyDeadline = false;
        this.isEmptyEvent = false;
        this.isDone = false;
    }
}
