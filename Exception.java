package numbers;

import java.util.Arrays;

public class Exception {

    public static boolean handleException() {
            String[] props = Input.getInput();
            if (!props[0].matches("\\d+")) {
                System.out.println("\nThe first parameter should be a natural number or zero.");
                return false;

            } else if (props.length > 1 && !props[1].matches("\\d+")) {
                System.out.println("\nThe second parameter should be a natural number.");
                return false;

            } else if (props.length > 2) {
                StringBuilder str = new StringBuilder();
                for (int i = 2; i < props.length; i++) {
                    if (!Arrays.toString(Number.numberProperties).contains(props[i].toUpperCase())) {
                        str.append(props[i].toUpperCase()).append(", ");
                    }
                }

                boolean invalid1 = Arrays.asList(props).contains("sunny") &&
                        Arrays.asList(props).contains("square");
                boolean invalid2 = Arrays.asList(props).contains("duck") &&
                        Arrays.asList(props).contains("spy");
                boolean invalid3 = Arrays.asList(props).contains("even") &&
                        Arrays.asList(props).contains("odd");

                if (invalid1) {
                    System.out.println("The request contains mutually exclusive properties: [SUNNY, SQUARE]" +
                    "\nThere are no numbers with these properties.");
                    return false;
                } else if (invalid2) {
                    System.out.println("The request contains mutually exclusive properties: [DUCK, SPY]" +
                            "\nThere are no numbers with these properties.");
                    return false;
                } else if (invalid3) {
                    System.out.println("The request contains mutually exclusive properties: [EVEN, ODD]" +
                            "\nThere are no numbers with these properties.");
                    return false;
                }

                else if (str.length() > 2) {
                    System.out.printf("The properties [" +
                            str.replace(str.length() - 2, str.length(), "]")
                                    .append(" are wrong\nAvailable properties: %s"),
                            Arrays.toString(Number.numberProperties));
                    return false;
                }
            }
        return true;
    }
}
