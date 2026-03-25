package seedu.duke;

import loans.LoanManager;
import storage.Bookmark;

public class Managers {
    private final ExpenseManager expenseManager;
    private final LoanManager loanManager;
    private final Bookmark bookmark;

    public Managers(ExpenseManager em, LoanManager lm, Bookmark bookmark) {
        this.expenseManager = em;
        this.loanManager = lm;
        this.bookmark = bookmark;
    }

    public ExpenseManager getExpenseManager() {
        return expenseManager;
    }

    public LoanManager getLoanManager() {
        return loanManager;
    }

    public Bookmark getBookmark() {
        return bookmark;
    }
}
