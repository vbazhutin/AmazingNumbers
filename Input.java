package numbers;

import java.util.Scanner;

public class Input {

    private static String[] input;

    public static void inputProps() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter a request:");
        input = in.nextLine().split("\\s");  //making input an array of Strings
    }

    public static String[] getInput() {
        return input;
    }
}