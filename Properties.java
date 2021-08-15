package numbers;

public class Properties {

    public static String printInlineProperties(long num) {
        return String.format("%,d", num) + " is " + (Number.isEven(num) ? "even " : "")
                + (!Number.isEven(num) ? "odd " : "")
                + (Number.isDuck(num) ? "duck " : "")
                + (Number.isBuzz(num) ? "buzz " : "")
                + (Number.isPalindrome(num) ? "palindromic " : "")
                + (Number.isGapful(num) ? "gapful " : "")
                + (Number.isSpy(num) ? "spy " : "")
                + (Number.isSquare(num) ? "square " : "")
                + (Number.isSunny(num) ? "sunny " : "")
                + (Number.isJumping(num) ? "jumping " : "")
                + (Number.isHappy(num) ? "happy " : "")
                + (Number.isSad(num) ? "sad" : "");
    }

    public static void processProperties(long num) {
        System.out.println();
        Number n = new Number(num);
        System.out.printf("Properties of %,d%n" +
                        "\t\teven: %b%n" +
                        "\t\todd: %b%n" +
                        "\t\tbuzz: %b%n" +
                        "\t\tpalindromic: %b%n" +
                        "\t\tduck: %b%n" +
                        "\t\tgapful: %b%n" +
                        "\t\tspy: %b%n" +
                        "\t\tsquare : %b%n" +
                        "\t\tsunny : %b%n" +
                        "\t\tjumping : %b%n" +
                        "\t\thappy : %b%n" +
                        "\t\tsad: %b%n"
                , num, n.even, n.odd, n.buzz, n.palindrome,
                n.duck, n.gapful, n.spy, n.square, n.sunny, n.jumping, n.happy, n.sad);
    }

    public static void processProperties(long num, long num2) {

        for (long i = 0; i < num2; i++) {
            System.out.println(printInlineProperties(num + i));
        }
    }

    public static void processProperties(long num1, long num2, String[] prop) {
        //Building including and excluding properties
        StringBuilder includeProps = new StringBuilder();
        StringBuilder excludeProps = new StringBuilder();
        for (String s : prop) {

            //excluding props builder
            if (s.startsWith("-")) {
                excludeProps.append(s).append(" ");

                //including props builder
            } else {
                includeProps.append(s).append(" ");
            }
        }

        //Making String builders into an array of String for better calculations
        String[] includeArr = String.valueOf(includeProps).split(" ");
        String[] excludeArr = String.valueOf(excludeProps).replaceAll("-", "").split(" ");

        for (long i = num1, count = 0; count < num2; i++) {
            boolean flag1 = false;
            boolean flag2 = false;

            //checking array of including props
            for (String value : includeArr) {

                //if array is empty then flag is true == no props to include
                //The flag is true ONLY WHEN the number props String contains including prop from the input
                if (includeArr[0].length() == 0) {
                    flag1 = true;
                    break;
                } else if (Properties.printInlineProperties(i).contains(value)) {
                    flag1 = true;
                } else {
                    flag1 = false;
                    break;
                }
            }

            // Same with the array of excluding props
            // The flag is true ONLY WHEN the number props String DOESN'T contain excluding prop from the input
            for (String s : excludeArr) {
                if (excludeArr[0].length() == 0) {
                    flag2 = true;
                    break;
                } else if (!Properties.printInlineProperties(i).contains(s)) {
                    flag2 = true;
                } else {
                    flag2 = false;
                    break;
                }
            }

            //if both flag are true - all prop conditions are met -> output the number
            if (flag1 && flag2) {
                System.out.println(Properties.printInlineProperties(i));
                count++;
            }
        }
    }
}
