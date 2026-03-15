package seedu.duke;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExpenseManagerTest {

    private ExpenseManager expenseManager;
    private Food foodExpense;
    private Transport transportExpense;

    @BeforeEach
    public void setUp() {
        expenseManager = new ExpenseManager();

        foodExpense = new Food("Chicken Rice", 4.50, LocalDate.of(2026, 3, 15));
        transportExpense = new Transport("MRT", 1.20, LocalDate.of(2026, 3, 14));
    }

    @Test
    public void constructor_default_emptyListAndZeroBudget() {
        assertTrue(expenseManager.isEmpty());
        assertEquals(0.0, expenseManager.getBudget());
    }

    @Test
    public void constructor_withParameters_correctInitialization() {
        ArrayList<Expense> expenses = new ArrayList<>();
        expenses.add(foodExpense);
        double budget = 500.0;

        ExpenseManager testManager = new ExpenseManager(expenses, budget);

        assertEquals(1, testManager.getSize());
        assertEquals(budget, testManager.getBudget());
        assertEquals(foodExpense, testManager.getExpense(0));
    }

    @Test
    public void addExpense_emptyManager_expenseAdded() {
        expenseManager.addExpense(foodExpense);

        assertEquals(1, expenseManager.getSize());
        assertFalse(expenseManager.isEmpty());
        assertEquals(foodExpense, expenseManager.getExpense(0));
    }

    @Test
    public void addExpense_multipleExpenses_allAdded() {
        expenseManager.addExpense(foodExpense);
        expenseManager.addExpense(transportExpense);

        assertEquals(2, expenseManager.getSize());
        assertEquals(foodExpense, expenseManager.getExpense(0));
        assertEquals(transportExpense, expenseManager.getExpense(1));
    }

    @Test
    public void deleteExpense_validIndex_expenseDeleted() throws ExpensiveLehException {
        expenseManager.addExpense(foodExpense);
        expenseManager.addExpense(transportExpense);

        Expense deletedExpense = expenseManager.deleteExpense(0);

        assertEquals(foodExpense, deletedExpense);
        assertEquals(1, expenseManager.getSize());
        assertEquals(transportExpense, expenseManager.getExpense(0));
    }

    @Test
    public void deleteExpense_indexOutOfBounds_throwsException() {
        expenseManager.addExpense(foodExpense);

        Exception exception = assertThrows(ExpensiveLehException.class, () -> {
            expenseManager.deleteExpense(1);
        });

        assertTrue(exception.getMessage().contains("Expense ID 2 doesn't exist."));
    }

    @Test
    public void editExpense_editAllFields_expenseUpdated() throws ExpensiveLehException {
        expenseManager.addExpense(foodExpense);

        expenseManager.editExpense(0, "transport", "Bus", 2.50, LocalDate.of(2026, 3, 20));

        Expense editedExpense = expenseManager.getExpense(0);
        assertTrue(editedExpense instanceof Transport);
        assertEquals("Bus", editedExpense.getDescription());
        assertEquals(2.50, editedExpense.getAmount());
    }

    @Test
    public void editExpense_editOnlyName_otherFieldsUnchanged() throws ExpensiveLehException {
        expenseManager.addExpense(foodExpense);

        expenseManager.editExpense(0, null, "fried rice", null, null);

        Expense editedExpense = expenseManager.getExpense(0);
        assertEquals("fried rice", editedExpense.getDescription());
        assertEquals(4.50, editedExpense.getAmount());
    }

    @Test
    public void editExpense_invalidCategory_defaultsToOthers() throws ExpensiveLehException {
        expenseManager.addExpense(foodExpense);

        expenseManager.editExpense(0, "invalid", null, null, null);

        Expense editedExpense = expenseManager.getExpense(0);
        assertTrue(editedExpense instanceof Others);
    }

    @Test
    public void setBudget_positiveValue_budgetSet() {
        expenseManager.setBudget(1000.0);
        assertEquals(1000.0, expenseManager.getBudget());
    }

    @Test
    public void getRemainingBudget_withExpenses_returnsCorrectValue() {
        expenseManager.setBudget(100.0);
        expenseManager.addExpense(foodExpense);
        expenseManager.addExpense(transportExpense);

        double expectedRemaining = 100.0 - (4.50 + 1.20);
        assertEquals(expectedRemaining, expenseManager.getRemainingBudget(), 0.001);
    }

    @Test
    public void getRemainingBudget_noExpenses_returnsFullBudget() {
        expenseManager.setBudget(1000.0);
        assertEquals(1000.0, expenseManager.getRemainingBudget());
    }

    @Test
    public void getSize_emptyManager_returnsZero() {
        assertEquals(0, expenseManager.getSize());
    }

    @Test
    public void getSize_withExpenses_returnsCorrectCount() {
        expenseManager.addExpense(foodExpense);
        expenseManager.addExpense(transportExpense);

        assertEquals(2, expenseManager.getSize());
    }

    @Test
    public void isEmpty_emptyManager_returnsTrue() {
        assertTrue(expenseManager.isEmpty());
    }

    @Test
    public void isEmpty_withExpenses_returnsFalse() {
        expenseManager.addExpense(foodExpense);
        assertFalse(expenseManager.isEmpty());
    }

    @Test
    public void getExpenses_emptyManager_returnsEmptyList() {
        assertTrue(expenseManager.getExpenses().isEmpty());
    }

    @Test
    public void getExpenses_withExpenses_returnsCorrectList() {
        expenseManager.addExpense(foodExpense);
        expenseManager.addExpense(transportExpense);

        ArrayList<Expense> expenses = expenseManager.getExpenses();
        assertEquals(2, expenses.size());
        assertEquals(foodExpense, expenses.get(0));
        assertEquals(transportExpense, expenses.get(1));
    }
}
