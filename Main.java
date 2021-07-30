package numbers;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Welcome.greetings();
        Welcome.printInstructions();

        while (true) {
            String[] props = Input.inputProps();
            if (props[0].equals("0")) {
                System.out.println("Goodbye!");
                break;
            } else if (!props[0].matches("\\d+")) {
                System.out.println("The first parameter should be a natural number or zero.");

            } else if (props.length > 1 && !props[1].matches("\\d+")) {
                System.out.println("The second parameter should be a natural number.");

            } else if (props.length > 3 && !Arrays.asList(Number.numberProperties).
                    contains(props[2].toUpperCase()) && !Arrays.asList(Number.numberProperties).
                    contains(props[3].toUpperCase())) {
                System.out.printf("The properties [%s][%s] are wrong. \nAvailable properties: [%s]",
                        props[2].toUpperCase(), props[3].toUpperCase(), Arrays.asList(Number.numberProperties));

            } else if (props.length > 2 && !Arrays.asList(Number.numberProperties).
                    contains(props[2].toUpperCase())) {
                System.out.printf("The property [%s] is wrong.\nAvailable properties: [%s]",
                        props[2].toUpperCase(), Arrays.asList(Number.numberProperties));

            } else if (props.length > 3 && !Arrays.asList(Number.numberProperties).
                    contains(props[3].toUpperCase())) {
                System.out.printf("The property [%s] is wrong.\nAvailable properties: [%s]",
                        props[3].toUpperCase(), Arrays.asList(Number.numberProperties));

            } else if (props.length > 3 && (props[2].equals("sunny") && props[3].equals("square")
            || props[2].equals("square") && props[3].equals("sunny"))) {
                System.out.printf("The request contains mutually exclusive properties: [%s, %s]\n" +
                                "There are no numbers with these properties.\n",
                        props[2].toUpperCase(), props[3].toUpperCase());

            } else if (props.length > 3 && (props[2].equals("duck") && props[3].equals("spy")
                    || props[2].equals("spy") && props[3].equals("duck"))) {
                System.out.printf("The request contains mutually exclusive properties: [%s, %s]\n" +
                                "There are no numbers with these properties.\n",
                        props[2].toUpperCase(), props[3].toUpperCase());

            } else if (props.length > 3 && (props[2].equals("even") && props[3].equals("odd")
                    || props[2].equals("odd") && props[3].equals("even"))) {
                System.out.printf("The request contains mutually exclusive properties: [%s, %s]\n" +
                                "There are no numbers with these properties.\n",
                        props[2].toUpperCase(), props[3].toUpperCase());

            } else {
                Request.submitRequest(props);
            }
        }
    }
}