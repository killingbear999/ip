public class Task {
	protected String description;
	protected boolean isDone;
	public static final int MAX_STRING_SIZE = 100;
	private static final String[] list = new String[MAX_STRING_SIZE];
	private static int commandCount = 0;
	private static int taskFinished = 0;
	protected String deadlineKeyword = "deadline";
	protected String actionKeyword = "todo";
	protected String eventKeyword = "event";

	public Task(String description) {
		this.description = description;
		this.isDone = false;
	}

	public String getStatusIcon() {
		return (isDone ? "\u2713" : "\u2718");
	}

	public void storeCommand() {
		if (isDeadline()) {
			storeDeadline();
		} else if (isAction()) {
			storeTodo();
		} else if (isEvent()) {
			storeEvent();
		}
	}

	public void echoCommand() {
		echoCommandMain();
		echoCommandEnding();
	}

	public void printList() {
		printListHeading();
		printListMain();
	}

	public void markAsDone() {
		List l = new List(description, commandCount);
		String taskDone = l.traceTask(description, list);
		taskFinished = l.returnTaskFinished();
		finishTask(taskDone, taskFinished);
		printTaskDone();
	}

	public void storeEvent() {
		Event e = new Event(description, commandCount);
		list[commandCount] = e.storeObject(description, commandCount);
		commandCount = commandCount + 1;
	}

	public void storeTodo() {
		Todo t = new Todo(description, commandCount);
		list[commandCount] = t.storeObject(description, commandCount);
		commandCount = commandCount + 1;
	}

	public void storeDeadline() {
		Deadline d = new Deadline(description, commandCount);
		list[commandCount] = d.storeObject(description, commandCount);
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

	public void printListMain() {
		for (int i = 1; i <= commandCount; i++) {
			System.out.println(i + "." + list[i - 1]);
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
		System.out.println("  " + list[commandCount-1]);
	}

	public void echoCommandEnding() {
		if (commandCount<=1) {
			System.out.println("Now you have " + commandCount + " task in the list.");
		} else {
			System.out.println("Now you have " + commandCount + " tasks in the list.");
		}
	}

	public void finishTask(String taskDone, int taskFinished) {
		isDone = true;
		if (list[taskFinished].contains("[T]")) {
			list[taskFinished] = "[T][" + getStatusIcon() + "] " + taskDone;
		} else if (list[taskFinished].contains("[D]")) {
			list[taskFinished] = "[D][" + getStatusIcon() + "] " + taskDone;
		} else if (list[taskFinished].contains("[E]")) {
			list[taskFinished] = "[E][" + getStatusIcon() + "] " + taskDone;
		}
	}

	public void printTaskDone() {
		System.out.println("Nice! I've marked this task as done:");
		System.out.println("  " + list[taskFinished]);
	}
}
