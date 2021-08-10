package numbers;

public class Main {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Welcome.printGreetings();
        Welcome.printInstructions();
        while (true) {
            Input.inputProps();
            if (Input.getInput()[0].equals("0")) {
                System.out.println("\nGoodbye!");
                break;
            } else if (Exception.handleException()) {
                Request.submitRequest(Input.getInput());
            }
        }
    }
}