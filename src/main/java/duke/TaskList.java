package duke;

import duke.command.AddCommand;
import duke.command.DeleteCommand;
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

	/** It is to initialise arraylist with existing data from the local disk */
	public void initiateTasks() {
		tasks.add(description);
	}

	/** It is to store new task to the list */
	public void storeCommand() {
		AddCommand task = new AddCommand(description, tasks);
		task.addCommand();
		task.echoCommand();
	}

	/** It is to print the tasks currently in the list */
	public void printList() {
		Ui ui = new Ui();
		ui.printList(tasks);
	}

	/** It is to mark a chosen task as done */
	public void markAsDone() {
		FinishCommand task = new FinishCommand(description, tasks);
		task.markAsFinished();
	}

	/** It is to delete a specific task from the list */
	public void deleteTask() {
		DeleteCommand task = new DeleteCommand(description, tasks);
		task.removeTask();
	}

	/** It is to return all tasks in the list and ready them to be written into local disk */
	public ArrayList<String> returnTasks() {
		return tasks;
	}
}
