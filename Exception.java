package numbers;

import java.util.Arrays;

public class Exception {

    public static boolean handleException() {
            String[] props = Input.getInput();
            String[][] wrongProps = Number.mutuallyExclusiveProps;
            if (!props[0].matches("\\d+")) {
                System.out.println("\nThe first parameter should be a natural number or zero.");
                return false;

            } else if (props.length > 1 && !props[1].matches("\\d+")) {
                System.out.println("\nThe second parameter should be a natural number.");
                return false;

            } else if (props.length > 2) {
                for (int i = 0; i < wrongProps.length; i++) {
                    int count = 0;
                    for (int j = 0; j < wrongProps[i].length; j++) {
                        if (Arrays.toString(props).toUpperCase().contains(wrongProps[i][j])) {
                            props[j] = wrongProps[i][j];
                            count++;
                        }
                        if (count == 2) {
                            System.out.printf("The request contains mutually exclusive properties: [%s, %s]\n" +
                                    "There are no numbers with these properties.", props[0], props[1]);
                            return false;
                        }
                    }
                }

                StringBuilder str = new StringBuilder();
                for (int i = 2; i < props.length; i++) {
                    if (!Arrays.toString(Number.numberProperties).contains(props[i].toUpperCase())) {
                        str.append(props[i].toUpperCase()).append(", ");
                    }
                }

                String[] invalidProps = str.toString().split(", ");

                if (invalidProps.length == 1 && !Arrays.toString(Number.numberProperties)
                        .contains(invalidProps[0].toUpperCase())) {
                    System.out.printf("The property [" +
                                    str.replace(str.length() - 2, str.length(), "]")
                                            .append(" is wrong\nAvailable properties: %s"),
                            Arrays.toString(Number.numberProperties));
                    return false;
                }

                else if (str.length() > 0) {
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
