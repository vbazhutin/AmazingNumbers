package numbers;

import java.util.Arrays;

public class Exception {

    public static boolean handleException() {
            String[] props = Input.getInput();
            String[][] wrongProps = Number.mutuallyExclusiveProps;

            if (!props[0].matches("\\d+")) {  //The first number must be >= 0
                System.out.println("\nThe first parameter should be a natural number or zero.");
                return false;

            } else if (props.length > 1 && !props[1].matches("\\d+")) { //The second num must be > 0
                System.out.println("\nThe second parameter should be a natural number.");
                return false;

            } else if (props.length > 2) {

                //checking the value of properties in input
                //if found one, make sure it's not mutually exclusive
                for (int j = 0, p = 0; j < wrongProps.length; j++) {
                    String[] invalidProps = new String[2];
                    int count = 0;
                    int invalidCount = 0;
                    //comparing every possible correct prop with the input
                    for (int k = 0; k < wrongProps[j].length; k++) {
                        for (int i = 0; i < props.length; i++) {
                            //if found incorrect -> assign to element of array
                            if (props[i].equalsIgnoreCase(wrongProps[j][k])) {
                                invalidProps[invalidCount] = wrongProps[j][k];
                                if (invalidProps[0].length() != 0) {
                                    invalidCount++;
                                }
                                count++;
                            }
                        }

                        //output mutually exclusive props
                        if (count == 2) {
                            System.out.printf("The request contains mutually exclusive properties: [%s, %s]\n" +
                                    "There are no numbers with these properties.", invalidProps[0], invalidProps[1]);
                            return false;
                        }
                    }
                }

                StringBuilder str = new StringBuilder();
                for (int i = 2; i < props.length; i++) {

                    //looking for invalid props and putting them into a separate StringBuilder var
                    if (!Arrays.toString(Number.allAvailProps).contains(props[i].toUpperCase())) {
                        str.append(props[i].toUpperCase()).append(", ");
                    }
                }

                //if one invalid property found -> output it and return false
                String[] invalidProps = str.toString().split(", ");
                if (invalidProps.length == 1 && !Arrays.toString(Number.allAvailProps)
                        .contains(invalidProps[0].toUpperCase())) {
                    System.out.printf("The property [" +
                                    str.replace(str.length() - 2, str.length(), "]")
                                            .append(" is wrong\nAvailable properties: %s"),
                            Arrays.toString(Number.numberProps));
                    return false;
                }

                //if many invalid properties found -> output them and return false
                else if (str.length() > 0) {
                    System.out.printf("The properties [" +
                                    str.replace(str.length() - 2, str.length(), "]")
                                            .append(" are wrong\nAvailable properties: %s"),
                            Arrays.toString(Number.numberProps));
                    return false;
                }
            }
        return true;
    }
}
