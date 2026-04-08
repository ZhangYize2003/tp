package seedu.duke;

import loans.Loan;
import loans.LoanManager;
import storage.Bookmark;
import java.time.LocalDate;

public class AddCommand extends Command {
    private final Object itemToAdd;
    private final String type; // "expense" or "loan"

    public AddCommand(Object item, String type) {
        this.itemToAdd = item;
        this.type = type;
    }

    @Override
    public void execute(Managers manager, UI ui) throws ExpensiveLehException {
        if (type.equalsIgnoreCase("loan")) {
            addLoan(manager.getLoanManager(), ui);
        } else if (type.equalsIgnoreCase("bookmark")) {
            addBookmark(manager.getExpenseManager(), manager.getBookmark(), ui);
        } else {
            addExpense(manager.getExpenseManager(), ui);
        }
    }

    private void addExpense(ExpenseManager expenses, UI ui) throws ExpensiveLehException {
        Expense expense = (Expense) itemToAdd;
        expenses.addExpense(expense);
        ui.showMessage("Expense added successfully!"
                + "\n================================================"
                + "\nCategory : " + expense.getCategory()
                + "\nName     : " + expense.getDescription()
                + "\nValue    : $" + String.format("%.2f", expense.getAmount())
                + "\nDate     : " + expense.getFormattedDate()
                + "\n================================================"
                + "\nRemaining Budget: $" + String.format("%.2f", expenses.getRemainingBudget()));
    }

    private void addLoan(LoanManager loans, UI ui) throws ExpensiveLehException {
        Loan loan = (Loan) itemToAdd;
        loans.addLoan(loan);
        ui.showMessage("Loan recorded successfully!"
                + "\n================================================"
                + "\nDebtor   : " + loan.getDescription()
                + "\nAmount   : $" + String.format("%.2f", loan.getAmount())
                + "\nDate     : " + loan.getDate().format(java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                + "\n================================================"
                + "\nTotal Owed to You: $" + String.format("%.2f", loans.getTotalAmountLent()));
    }

    public void addBookmark(ExpenseManager expenses, Bookmark bookmark, UI ui) {
        int index = (Integer) itemToAdd;
        Expense expense = bookmark.getBookmark(index);

        LocalDate today = LocalDate.now();
        Expense newExpense;

        if (expense instanceof Food) {
            newExpense = new Food(expense.getDescription(), expense.getAmount(), today);
        } else if (expense instanceof Transport) {
            newExpense = new Transport(expense.getDescription(), expense.getAmount(), today);
        } else if (expense instanceof Groceries) {
            newExpense = new Groceries(expense.getDescription(), expense.getAmount(), today);
        } else {
            newExpense = new Others(expense.getDescription(), expense.getAmount(), today);
        }

        expenses.addExpense(newExpense);
        ui.showMessage("Expense added successfully!"
                + "\n================================================"
                + "\nCategory : " + newExpense.getCategory()
                + "\nName     : " + newExpense.getDescription()
                + "\nValue    : $" + String.format("%.2f", newExpense.getAmount())
                + "\nDate     : " + newExpense.getFormattedDate()
                + "\n================================================"
                + "\nRemaining Budget: $" + String.format("%.2f", expenses.getRemainingBudget()));
    }
}
