package numbers;

public class Properties {

    public static String printInlineProperties(long num) {
        return num + " is " + (Number.isEven(num) ? "even " : "")
                + (!Number.isEven(num) ? "odd " : "")
                + (Number.isDuck(num) ? "duck " : "")
                + (Number.isBuzz(num) ? "buzz " : "")
                + (Number.isPalindrome(num) ? "palindromic " : "")
                + (Number.isGapful(num) ? "gapful " : "")
                + (Number.isSpy(num) ? "spy " : "")
                + (Number.isSquare(num) ? "square " : "")
                + (Number.isSunny(num) ? "sunny" : "")
                + (Number.isJumping(num) ? "jumping" : "");
    }

    public static void processProperties(long num) {
        Number n = new Number(num);
        System.out.printf("Properties of %d%n" +
                        "\t\teven: %b%n" +
                        "\t\todd: %b%n" +
                        "\t\tbuzz: %b%n" +
                        "\t\tpalindromic: %b%n" +
                        "\t\tduck: %b%n" +
                        "\t\tgapful: %b%n" +
                        "\t\tspy: %b%n" +
                        "\t\tsquare : %b%n" +
                        "\t\tsunny : %b%n" +
                        "\t\tjumping: %b%n"
                , num, n.even, n.odd, n.buzz, n.palindrome,
                n.duck, n.gapful, n.spy, n.square, n.sunny, n.jumping);
    }

    public static void processProperties(long num, long num2) {

        for (long i = 0; i < num2; i++) {
            System.out.println(printInlineProperties(num + i));
        }
    }

    public static void processProperties(long num1, long num2, String prop) {

        for (long i = num1, count = 0; count < num2; i++) {
            if (printInlineProperties(i).contains(prop.toLowerCase())) {
                System.out.println(printInlineProperties(i));
                count++;
            }
        }
    }

    public static void processProperties(long num1, long num2, String prop, String prop2) {

        for (long i = num1, count = 0; count < num2; i++) {
            if (printInlineProperties(i).contains(prop.toLowerCase()) &&
                    printInlineProperties(i).contains(prop2.toLowerCase())) {
                System.out.println(printInlineProperties(i));
                count++;
            }
        }
    }
}
