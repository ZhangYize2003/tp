package seedu.duke;

import loans.LoanManager;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class RankCommand extends Command {
    private final String type;

    // Constructor to catch type from Parser
    public RankCommand(String type) {
        this.type = type;
    }

    public RankCommand() {
        this.type = "expense";
    }

    @Override
    public void execute(Managers managers, UI ui) throws ExpensiveLehException {
        Map<String, Double> unsortedTotals;

        if (type.equals("loan")) {
            LoanManager loanManager = managers.getLoanManager();
            if (loanManager.isEmpty()) {
                ui.showMessage("No loans added yet!");
                return;
            }
            unsortedTotals = loanManager.getPersonTotals();

        } else {
            ExpenseManager expenseManager = managers.getExpenseManager();
            if (expenseManager.isEmpty()) {
                ui.showMessage("No expenses added yet!");
                return;
            }
            unsortedTotals = expenseManager.getCategoryTotals();
        }

        List<Map.Entry<String, Double>> rankedList = new ArrayList<>(unsortedTotals.entrySet());
        rankedList.sort((entry1, entry2)
                -> entry2.getValue().compareTo(entry1.getValue()));;

        ui.showRanking(rankedList, type);
    }
}
