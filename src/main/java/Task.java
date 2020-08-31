public class Task {
	protected String description;
	protected boolean isDone;
	private static final String[] list = new String[100];
	private static int commandCount = 0;
	String deadlineKeyword = "deadline";
	String actionKeyword = "todo";
	String eventKeyword = "event";

	public Task(String description) {
		this.description = description;
		this.isDone = false;
	}

	public String getStatusIcon() {
		return (isDone ? "\u2713" : "\u2718");
	}

	public void storeCommand() {
		String object;
		String deadline;
		if (description.startsWith(deadlineKeyword)) {
			object = description.substring(description.indexOf(" ", 1) + 1,
					description.indexOf("/") - 1);
			deadline = description.substring(description.indexOf("by") + 3);
			list[commandCount] = "[D][" + getStatusIcon() + "] " + object + " (by: " + deadline + ")";
			commandCount = commandCount + 1;
		} else if(description.startsWith(actionKeyword)) {
			object = description.substring(description.indexOf(" ", 1) + 1);
			list[commandCount] = "[T][" + getStatusIcon() + "] " + object;
			commandCount = commandCount + 1;
		} else if(description.startsWith(eventKeyword)) {
			object = description.substring(description.indexOf(" ", 1) + 1,
					description.indexOf("/") - 1);
			deadline = description.substring(description.indexOf("at") + 3);
			list[commandCount] = "[E][" + getStatusIcon() + "] " + object + " (at: " + deadline + ")";
			commandCount = commandCount + 1;
		}
	}

	public void printList() {
		if (commandCount<=1) {
			System.out.println("Here are the task in your list:");
		} else {
			System.out.println("Here are the tasks in your list:");
		}
		for (int i = 1; i <= commandCount; i++) {
			System.out.println(i + "." + list[i - 1]);
		}
	}

	public void echoCommand() {
		System.out.println("Got it. I've added this task:");
		System.out.println("  " + list[commandCount-1]);
		if (commandCount<=1) {
			System.out.println("Now you have " + commandCount + " task in the list.");
		} else {
			System.out.println("Now you have " + commandCount + " tasks in the list.");
		}
	}

	public void markAsDone() {
		String[] taskTracer = description.split(" ");
		int taskFinished = Integer.parseInt(taskTracer[1]) - 1;
		isDone = true;
		String taskDone = list[taskFinished].substring(list[taskFinished].indexOf(" ", 1) + 1,
				list[taskFinished].length());
		if (list[taskFinished].contains("[T]")) {
			list[taskFinished] = "[T][" + getStatusIcon() + "] " + taskDone;
		} else if (list[taskFinished].contains("[D]")) {
			list[taskFinished] = "[D][" + getStatusIcon() + "] " + taskDone;
		} else if (list[taskFinished].contains("[E]")) {
			list[taskFinished] = "[E][" + getStatusIcon() + "] " + taskDone;
		}
		System.out.println("Nice! I've marked this task as done:");
		System.out.println("  " + list[taskFinished]);
	}
}
