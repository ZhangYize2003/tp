package seedu.duke;

public class ExpensiveLeh {

    private Parser parser = new Parser();

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public void run() {
        try {
            Command command = parser.readCommand();
        } catch (ExpensiveLehException e) {
            // TODO: Replace with method from UI class
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new ExpensiveLeh().run();
    }
}
