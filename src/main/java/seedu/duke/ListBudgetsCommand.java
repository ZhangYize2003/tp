package seedu.duke;

import java.util.HashMap;

public class ListBudgetsCommand extends Command {
    @Override
    public void execute(Managers managers, UI ui) throws ExpensiveLehException {
        ExpenseManager expenseManager = managers.getExpenseManager();
        HashMap<String, Double> categoryBudgets = expenseManager.getCategoryBudgets();
        StringBuilder result = new StringBuilder();
        result.append("\n \nGlobal Budget Set: ").append(expenseManager.getBudget()).append("\n");
        result.append("Global Budget Remaining: ").append(expenseManager.getRemainingBudget()).append("\n");

        if (categoryBudgets.isEmpty()) {
            ui.showMessage(result + "No category budgets set yet. " +
                    "Use 'budget c/CATEGORY a/AMOUNT' to set a category budget.");
            return;
        }


        result.append(String.format("\n%-15s %-15s %-15s%n", "Category", "Budget", "Remaining"));
        result.append("--------------------------------------------------\n");

        for (String category : categoryBudgets.keySet()) {
            double budget = categoryBudgets.get(category);
            double remaining = expenseManager.getRemainingBudgetForCategory(category);
            result.append(String.format("%-15s $%-14.2f $%-14.2f%n",
                    capitalize(category), budget, remaining));
        }
        ui.showMessage(result.toString());
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
