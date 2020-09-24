package duke;

import duke.command.AddCommand;
import duke.command.DeleteCommand;
import duke.command.FindDateCommand;
import duke.command.FinishCommand;

import java.util.ArrayList;

public class TaskList {
	protected String description;

	public static ArrayList<String> tasks = new ArrayList<>();

	public TaskList(String description) {
		this.description = description;
	}

	public TaskList() {
	}

	public void initiateTasks() {
		tasks.add(description);
	}

	public void storeCommand() {
		AddCommand task = new AddCommand(description, tasks);
		task.addCommand();
		task.echoCommand();
	}

	public void printList() {
		Ui ui = new Ui();
		ui.printList(tasks);
	}

	public void markAsDone() {
		FinishCommand task = new FinishCommand(description, tasks);
		task.markAsFinished();
	}

	public void deleteTask() {
		DeleteCommand task = new DeleteCommand(description, tasks);
		task.removeTask();
	}

	public void findTask() {
		FindDateCommand task = new FindDateCommand(description, tasks);
		task.findTask();
	}

	public ArrayList<String> returnTasks() {
		return tasks;
	}
}
