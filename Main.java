package numbers;

public class Main {

    public static void main(String[] args) {
        run();
    }

    //Building the program
    private static void run() {
        Welcome.printGreetings();  //printing welcome and instructions
        Welcome.printInstructions();
        while (true) {
            Input.inputProps();  //getting input
            if (Input.getInput()[0].equals("0")) {  //if user enter "0" - exit the program
                System.out.println("\nGoodbye!");
                break;
            } else if (Exception.handleException()) {  //checking if input doesn't follow instructions
                Request.submitRequest(Input.getInput());  //if follows then process request
            }
        }
    }
}