package seedu.duke;

import loans.LoanManager;

import java.time.LocalDate;

public class EditCommand extends Command {
    private int index;
    private String category;
    private String name;
    private Double value;
    private LocalDate date;
    private String type;

    public EditCommand(int index, String category, String name, Double value, LocalDate date, String type) {
        this.index = index;
        this.category = category;
        this.name = name;
        this.value = value;
        this.date = date;
        this.type = type;
    }

    @Override
    public void execute(Managers managers, UI ui) throws ExpensiveLehException {

        if ("loan".equals(type)) {
            LoanManager loanManager = managers.getLoanManager();
            loanManager.editLoan(index, name, value, date);
            ui.showMessage("Loan at index " + (index + 1) + " updated successfully!");
        } else {
            // Check if category is valid, warn if it will be converted to Others
            if (category != null) {
                String normalizedCategory = category.toLowerCase();
                if (!normalizedCategory.equals("food") && !normalizedCategory.equals("transport")
                        && !normalizedCategory.equals("groceries") && !normalizedCategory.equals("others")) {
                    ui.showMessage("Warning: Category '" + category + "' is not recognized. "
                            + "It has been converted to 'Others'.");
                }
            }

            ExpenseManager expenseManager = managers.getExpenseManager();

            // Get current expense to determine final category
            Expense currentExpense = expenseManager.getExpense(index);
            String finalCategory = category != null ? category : currentExpense.getCategory();

            expenseManager.editExpense(index, category, name, value, date);

            // Calculate budget impact after editing
            double categoryBudget = expenseManager.getCategoryBudget(finalCategory);
            double remainingCategoryBudget = expenseManager.getRemainingBudgetForCategory(finalCategory);
            double remainingGlobalBudget = expenseManager.getRemainingBudget();
            String message = "Expense at index " + (index + 1) + " updated successfully!";

            if (categoryBudget > 0 && remainingCategoryBudget < 0) {
                message += "\nWarning: You have overspent the " + finalCategory
                        + " budget by $" + String.format("%.2f", Math.abs(remainingCategoryBudget));
            }
            if (remainingGlobalBudget < 0) {
                message += "\nWarning: You have overspent the global budget by $"
                        + String.format("%.2f", Math.abs(remainingGlobalBudget));
            }
            ui.showMessage(message);
        }
    }
}
