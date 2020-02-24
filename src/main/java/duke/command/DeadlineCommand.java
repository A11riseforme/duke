package duke.command;

import duke.exception.DukeException;
import duke.task.Deadline;
import duke.task.TaskList;
import duke.ui.Ui;
import duke.util.Storage;

public class DeadlineCommand implements Command {
    private String taskDescription;
    private String byDate;

    public DeadlineCommand(String taskDescription, String byDate) {
        this.taskDescription = taskDescription;
        this.byDate = byDate;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        Deadline deadlineTask = new Deadline(taskDescription, byDate);
        taskList.add(deadlineTask);
        ui.showAddTaskSuccessfulPrompt(taskList, deadlineTask);
    }
}