package duke;

import duke.exception.DeadlineException;
import duke.exception.EventException;
import duke.exception.TodoException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.List;
import duke.task.Todo;
import java.util.ArrayList;

public class Task {
	protected String description;
	protected boolean isDone;
	protected boolean isCorrectInput;
	protected boolean isEmptyTodo;
	protected boolean isEmptyDeadline;
	protected boolean isEmptyEvent;
	private static int taskFinished = 0;
	private static String taskDone;
	protected String deadlineKeyword = "deadline";
	protected String actionKeyword = "todo";
	protected String eventKeyword = "event";

	public static ArrayList<String> tasks = new ArrayList<>();

	public Task(String description) {
		this.description = description;
		this.isDone = false;
		this.isCorrectInput = true;
		this.isEmptyTodo = false;
		this.isEmptyDeadline = false;
		this.isEmptyEvent = false;
	}

	public void storeCommand() {
		if (isDeadline()) {
			try {
				dealWithDeadline();
			} catch (DeadlineException e) {
				printErrorMessage();
			}
		} else if (isAction()) {
			try {
				dealWithTodo();
			} catch (TodoException e) {
				printErrorMessage();
			}
		} else if (isEvent()) {
			try {
				dealWithEvent();
			} catch (EventException e) {
				printErrorMessage();
			}
		} else {
			printErrorMessage();
			isCorrectInput = false;
		}
	}

	public void dealWithEvent() throws EventException {
		isEmptyEvent = checkStatus(description);
		if (isEmptyEvent) {
			throw new EventException();
		}
		storeEvent();
	}

	public void dealWithDeadline() throws DeadlineException {
		isEmptyDeadline = checkStatus(description);
		if (isEmptyDeadline) {
			throw new DeadlineException();
		}
		storeDeadline();
	}

	public void dealWithTodo() throws TodoException {
		isEmptyTodo = checkStatus(description);
		if (isEmptyTodo) {
			throw new TodoException();
		}
		storeTodo();
	}

	public void echoCommand() {
		if (isCorrectInput && !isEmptyTodo && !isEmptyDeadline && !isEmptyEvent) {
			echoCommandMain();
			sumTasks();
		}
	}

	public void printList() {
		printListHeading();
		printListMain();
	}

	public void markAsDone() {
		traceTaskDone();
		finishTask(taskDone, taskFinished);
		printTaskDone();
	}

	public void storeEvent() {
		Event e = new Event(description);
		String eventTitle = e.storeObject();
		tasks.add(eventTitle);
	}

	public boolean checkStatus(String description) {
		if (isAction() && description.length() < 5) {
			return true;
		} else if (isDeadline() && (description.length() < 9 || !description.contains("/by"))) {
			return true;
		} else if (isEvent() && (description.length() < 6 || !description.contains("/at"))) {
			return true;
		}
		return false;
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

	public boolean isDeadline() {
		return description.startsWith(deadlineKeyword);
	}

	public boolean isAction() {
		return description.startsWith(actionKeyword);
	}

	public boolean isEvent() {
		return description.startsWith(eventKeyword);
	}

	public void printErrorMessage() {
		if (isEmptyTodo) {
			System.out.println("OOPS!!! The description of a todo cannot be empty.");
		} else if (isEmptyDeadline) {
			System.out.println("OOPS!!! The description of a deadline cannot be empty.");
		} else if (isEmptyEvent) {
			System.out.println("OOPS!!! The description of an event cannot be empty.");
		} else if (isCorrectInput) {
			System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
		}
	}

	public void printListMain() {
		for (int i = 1; i <= tasks.size(); i++) {
			System.out.println(i + "." + tasks.get(i - 1));
		}
	}

	public void printListHeading() {
		if (tasks.size() <= 1) {
			System.out.println("Here are the task in your list:");
		} else {
			System.out.println("Here are the tasks in your list:");
		}
	}

	public void echoCommandMain() {
		System.out.println("Got it. I've added this task:");
		System.out.println("  " + tasks.get(tasks.size()-1));
	}

	public void sumTasks() {
		if (tasks.size() <= 1) {
			System.out.println("Now you have " + tasks.size() + " task in the list.");
		} else {
			System.out.println("Now you have " + tasks.size() + " tasks in the list.");
		}
	}

	public String getStatusIcon() {
		return (isDone ? "\u2713" : "\u2718");
	}

	public void traceTaskDone() {
		List l = new List(description);
		taskDone = l.traceTaskDone(tasks);
		taskFinished = l.returnTaskFinished();
		isDone = true;
	}

	public void finishTask(String taskDone, int taskFinished) {
		if (tasks.get(taskFinished).contains("[T]")) {
			tasks.set(taskFinished, "[T][" + getStatusIcon() + "] " + taskDone);
		} else if (tasks.get(taskFinished).contains("[D]")) {
			tasks.set(taskFinished, "[D][" + getStatusIcon() + "] " + taskDone);
		} else if (tasks.get(taskFinished).contains("[E]")) {
			tasks.set(taskFinished, "[E][" + getStatusIcon() + "] " + taskDone);
		}
	}

	public void printTaskDone() {
		System.out.println("Nice! I've marked this task as done:");
		System.out.println("  " + tasks.get(taskFinished));
	}

	public void deleteTask() {
		List l = new List(description);
		int taskDeleted = l.traceTaskDeleted();
		System.out.println("Noted. I've removed this task:");
		System.out.println("  " + tasks.get(taskDeleted));
		tasks.remove(taskDeleted);
		sumTasks();
	}
}
