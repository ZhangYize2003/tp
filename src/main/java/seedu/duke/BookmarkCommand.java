package seedu.duke;

import storage.Bookmark;
import java.io.IOException;

public class BookmarkCommand extends Command {
    private final int index;

    public BookmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(Managers manager, UI ui) throws ExpensiveLehException {
        ExpenseManager expenseManager = manager.getExpenseManager();
        Bookmark bookmark = manager.getBookmark();

        try {
            Expense expense = expenseManager.getExpense(index);
            bookmark.addBookmark(expense);
            bookmark.save();

            ui.showMessage("Successfully bookmarked: " + expense.getCategory()
                    + " " + expense.getDescription()
                    + " $" + String.format("%.2f", expense.getAmount())
                    + " " + expense.getFormattedDate());
        } catch (IndexOutOfBoundsException e) {
            throw new ExpensiveLehException("Please provide a valid expense index to bookmark!");
        } catch (IOException e) {
            ui.showError("Error saving bookmark: " + e.getMessage());
        }
    }
}
