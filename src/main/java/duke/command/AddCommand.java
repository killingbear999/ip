package duke.command;

import duke.Ui;
import duke.exception.DeadlineException;
import duke.exception.EventException;
import duke.exception.TodoException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Todo;

import java.util.ArrayList;

public class AddCommand extends Command {
    public AddCommand(String description, ArrayList<String> tasks) {
        super(description, tasks);
    }

    public void addCommand() {
        Ui ui = new Ui();
        if (isDeadline()) {
            try {
                dealWithDeadline();
            } catch (DeadlineException e) {
                ui.printErrorMessage(isEmptyTodo, isEmptyDeadline, isEmptyEvent, isCorrectInput);
            }
        } else if (isTodo()) {
            try {
                dealWithTodo();
            } catch (TodoException e) {
                ui.printErrorMessage(isEmptyTodo, isEmptyDeadline, isEmptyEvent, isCorrectInput);
            }
        } else if (isEvent()) {
            try {
                dealWithEvent();
            } catch (EventException e) {
                ui.printErrorMessage(isEmptyTodo, isEmptyDeadline, isEmptyEvent, isCorrectInput);
            }
        } else {
            ui.printErrorMessage(isEmptyTodo, isEmptyDeadline, isEmptyEvent, isCorrectInput);
            isCorrectInput = false;
        }
    }

    public boolean isDeadline() {
        return description.startsWith("deadline");
    }

    public boolean isTodo() {
        return description.startsWith("todo");
    }

    public boolean isEvent() {
        return description.startsWith("event");
    }

    public boolean isValidCommand(String description) {
        if (isTodo() && description.length() < 5) {
            return true;
        } else if (isDeadline() && (description.length() < 9 || !description.contains("/by"))) {
            return true;
        } else if (isEvent() && (description.length() < 6 || !description.contains("/at"))) {
            return true;
        }
        return false;
    }

    public void dealWithEvent() throws EventException {
        isEmptyEvent = isValidCommand(description);
        if (isEmptyEvent) {
            throw new EventException();
        }
        storeEvent();
    }

    public void dealWithDeadline() throws DeadlineException {
        isEmptyDeadline = isValidCommand(description);
        if (isEmptyDeadline) {
            throw new DeadlineException();
        }
        storeDeadline();
    }

    public void dealWithTodo() throws TodoException {
        isEmptyTodo = isValidCommand(description);
        if (isEmptyTodo) {
            throw new TodoException();
        }
        storeTodo();
    }

    public void storeEvent() {
        Event e = new Event(description);
        String eventTitle = e.storeObject();
        tasks.add(eventTitle);
    }

    public void storeTodo() {
        Todo t = new Todo(description);
        String todoTitle = t.storeObject();
        tasks.add(todoTitle);
    }

    public void storeDeadline() {
        Deadline d = new Deadline(description);
        String deadlineTitle = d.storeObject();
        tasks.add(deadlineTitle);
    }

    public void echoCommand() {
        Ui ui = new Ui();
        if (isCorrectInput && !isEmptyTodo && !isEmptyDeadline && !isEmptyEvent) {
            ui.echoCommand(tasks);
        }
    }
}
