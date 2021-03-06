package duke.command;

import duke.Ui;
import duke.exception.DeadlineException;
import duke.exception.EventException;
import duke.exception.TodoException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Todo;

import java.util.ArrayList;

/**
 * This class is to add new tasks into the list, with the command type event, todo and deadline,
 * and echo the task
 */
public class AddCommand extends Command {
    
    public static final int EMPTY_TODO = 5;
    public static final int EMPTY_DEADLINE = 9;
    public static final int EMPTY_EVENT = 6;
    
    public AddCommand(String description, ArrayList<String> tasks) {
        super(description, tasks);
    }
    
    /**
     * It is to identify command type and determine whether they are deadline or todo or event, then
     * process them separately, and check whether the format of the input command is correct or not
     */
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

    /** It is to check whether the command is "deadline" or not */
    public boolean isDeadline() {
        return description.startsWith("deadline");
    }

    /** It is to check whether the command is "todo" or not */
    public boolean isTodo() {
        return description.startsWith("todo");
    }

    /** It is to check whether the command is "event" or not */
    public boolean isEvent() {
        return description.startsWith("event");
    }
    
    /** It is to check whether the command is valid or not */
    public boolean isValidCommand(String description) {
        if (isTodo() && description.length() < EMPTY_TODO) {
            return true;
        } else if (isDeadline() && (description.length() < EMPTY_DEADLINE || !description.contains("/by"))) {
            return true;
        } else if (isEvent() && (description.length() < EMPTY_EVENT || !description.contains("/at"))) {
            return true;
        }
        return false;
    }

    /** It is to process the command if it is event type
     *
     * @throws EventException If event is not entered in the correct format
     */
    public void dealWithEvent() throws EventException {
        isEmptyEvent = isValidCommand(description);
        if (isEmptyEvent) {
            throw new EventException();
        }
        storeEvent();
    }

    /** It is to process the command if it is deadline type
     *
     * @throws DeadlineException If deadline is not entered in the correct format
     */
    public void dealWithDeadline() throws DeadlineException {
        isEmptyDeadline = isValidCommand(description);
        if (isEmptyDeadline) {
            throw new DeadlineException();
        }
        storeDeadline();
    }

    /** It is to process the command if it is todo type
     *
     * @throws TodoException If todo is not entered in the correct format
     */
    public void dealWithTodo() throws TodoException {
        isEmptyTodo = isValidCommand(description);
        if (isEmptyTodo) {
            throw new TodoException();
        }
        storeTodo();
    }

    /** It is to store an event if the format is correct
     *
     * @param eventTitle The main content of the new event
     */
    public void storeEvent() {
        Event e = new Event(description);
        String eventTitle = e.storeObject();
        tasks.add(eventTitle);
    }

    /** It is to store a todo if the format is correct
     *
     * @param todoTitle The main content of the new todo
     */
    public void storeTodo() {
        Todo t = new Todo(description);
        String todoTitle = t.storeObject();
        tasks.add(todoTitle);
    }

    /** It is to store a deadline if the format is correct
     *
     * @param deadlineTitle The main content of the new deadline
     */
    public void storeDeadline() {
        Deadline d = new Deadline(description);
        String deadlineTitle = d.storeObject();
        tasks.add(deadlineTitle);
    }

    /** It is to echo the task once it is stored in the list */
    public void echoCommand() {
        Ui ui = new Ui();
        if (isCorrectInput && !isEmptyTodo && !isEmptyDeadline && !isEmptyEvent) {
            ui.echoCommand(tasks);
        }
    }
}
