package numbers;

import java.util.Arrays;

public class Request {

    public static void submitRequest(String[] args) {

        switch (args.length) {
            case 1:
                Properties.processProperties(Long.parseLong(args[0]));
                break;
            case 2:
                Properties.processProperties(Long.parseLong(args[0]),
                        Long.parseLong(args[1]));
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                Properties.processProperties(Long.parseLong(args[0]),
                        Long.parseLong(args[1]), Arrays.copyOfRange(args, 2, args.length));
                break;
            default:
                System.out.println("Number of properties can't be more than 12");
                break;
        }
    }
}
