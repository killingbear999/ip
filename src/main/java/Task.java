public class Task {
	protected String description;
	protected boolean isDone;
	protected boolean isCorrectInput;
	protected boolean isEmptyTodo;
	protected boolean isEmptyDeadline;
	protected boolean isEmptyEvent;
	public static final int MAX_STRING_SIZE = 100;
	public static String[] lists = new String[MAX_STRING_SIZE];
	private static int commandCount = 0;
	private static int taskFinished = 0;
	private static String taskDone;
	protected String deadlineKeyword = "deadline";
	protected String actionKeyword = "todo";
	protected String eventKeyword = "event";

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
			dealWithDeadline();
		} else if (isAction()) {
			dealWithTodo();
		} else if (isEvent()) {
			dealWithEvent();
		} else {
			printErrorMessage();
			isCorrectInput = false;
		}
	}

	public void dealWithEvent() {
		isEmptyEvent = checkStatus(description);
		if (!isEmptyEvent) {
			storeEvent();
		} else {
			printErrorMessage();
		}
	}

	public void dealWithDeadline() {
		isEmptyDeadline = checkStatus(description);
		if (!isEmptyDeadline) {
			storeDeadline();
		} else {
			printErrorMessage();
		}
	}

	public void dealWithTodo() {
		isEmptyTodo = checkStatus(description);
		if (!isEmptyTodo) {
			storeTodo();
		} else {
			printErrorMessage();
		}
	}

	public void echoCommand() {
		if (isCorrectInput && !isEmptyTodo && !isEmptyDeadline && !isEmptyEvent) {
			echoCommandMain();
			echoCommandEnding();
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
		lists[commandCount] = e.storeObject(description);
		commandCount = commandCount + 1;
	}

	public boolean checkStatus(String description) {
		if (isAction() && description.length() < 5) {
			return true;
		} else if (isDeadline() && description.length() < 9) {
			return true;
		} else if (isEvent() && description.length() < 6) {
			return true;
		}
		return false;
	}

	public void storeTodo() {
		Todo t = new Todo(description);
		lists[commandCount] = t.storeObject(description);
		commandCount = commandCount + 1;
	}

	public void storeDeadline() {
		Deadline d = new Deadline(description);
		lists[commandCount] = d.storeObject(description);
		commandCount = commandCount + 1;
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
		for (int i = 1; i <= commandCount; i++) {
			System.out.println(i + "." + lists[i - 1]);
		}
	}

	public void printListHeading() {
		if (commandCount<=1) {
			System.out.println("Here are the task in your list:");
		} else {
			System.out.println("Here are the tasks in your list:");
		}
	}

	public void echoCommandMain() {
		System.out.println("Got it. I've added this task:");
		System.out.println("  " + lists[commandCount-1]);
	}

	public void echoCommandEnding() {
		if (commandCount<=1) {
			System.out.println("Now you have " + commandCount + " task in the list.");
		} else {
			System.out.println("Now you have " + commandCount + " tasks in the list.");
		}
	}

	public String getStatusIcon() {
		return (isDone ? "\u2713" : "\u2718");
	}

	public void traceTaskDone() {
		List l = new List(description);
		taskDone = l.traceTask(description, lists);
		taskFinished = l.returnTaskFinished();
		isDone = true;
	}

	public void finishTask(String taskDone, int taskFinished) {
		if (lists[taskFinished].contains("[T]")) {
			lists[taskFinished] = "[T][" + getStatusIcon() + "] " + taskDone;
		} else if (lists[taskFinished].contains("[D]")) {
			lists[taskFinished] = "[D][" + getStatusIcon() + "] " + taskDone;
		} else if (lists[taskFinished].contains("[E]")) {
			lists[taskFinished] = "[E][" + getStatusIcon() + "] " + taskDone;
		}
	}

	public void printTaskDone() {
		System.out.println("Nice! I've marked this task as done:");
		System.out.println("  " + lists[taskFinished]);
	}
}
