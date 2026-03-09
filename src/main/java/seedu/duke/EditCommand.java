package seedu.duke;

public class EditCommand extends Command {
    private int index;

    public EditCommand(int index) {
        this.index = index;
    }
}
