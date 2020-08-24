public class Task {
	protected String description;
	protected boolean isDone;
	private static String[] list = new String[100];
	private static int commandCount = 0;

	public Task(String description) {
		this.description = description;
		this.isDone = false;
	}

	public String getStatusIcon() {
		return (isDone ? "\u2713" : "\u2718");
	}

	public void store() {
		list[commandCount] = "[" + getStatusIcon() + "] " + description;
		commandCount = commandCount + 1;
	}

	public void printList() {
		System.out.println("Here are the tasks in your list:");
		for (int i = 1; i <= commandCount; i++) {
			System.out.println(i + "." + list[i-1]);
		}
	}

	public void echo() {
		System.out.println("added: " + description);
	}

	public void markAsDone() {
		String[] taskTracer = description.split(" ");
		int taskFinished = Integer.parseInt(taskTracer[1]) - 1;
		isDone = true;
		String taskDone = list[taskFinished].substring(list[taskFinished].indexOf("]") + 2,
				list[taskFinished].length());
		list[taskFinished] = "[" + getStatusIcon() + "] " + taskDone;
		System.out.println("Nice! I've marked this task as done:");
		System.out.println("  " + list[taskFinished]);
	}
}
