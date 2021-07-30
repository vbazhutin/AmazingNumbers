package numbers;

public class Number {
    public static final String[] numberProperties =
            {"BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "EVEN", "ODD", "SQUARE", "SUNNY"};
    public boolean buzz;
    public boolean duck;
    public boolean palindrome;
    public boolean gapful;
    public boolean spy;
    public boolean even;
    public boolean odd;
    public boolean square;
    public boolean sunny;

    public Number(long num) {
        buzz = isBuzz(num);
        duck = isDuck(num);
        palindrome = isPalindrome(num);
        gapful = isGapful(num);
        spy = isSpy(num);
        even = isEven(num);
        odd = !isEven(num);
        square = isSquare(num);
        sunny = isSunny(num);
    }

    public static boolean isSpy(long num) {
        long ld;
        long sum = 0;
        long product = 1;
        while (num > 0) {
            ld = num % 10;
            sum = sum + ld;
            product = product * ld;
            num = num / 10;
        }
        return sum == product;
    }

    public static boolean isBuzz(long num) {
        return num % 7 == 0 || num % 10 == 7;
    }

    public static boolean isEven(long num) {
        return num % 2 == 0;
    }

    public static boolean isDuck(long num) {
        return String.valueOf(num).substring(1).contains("0");
    }

    public static boolean isPalindrome(long num) {
        StringBuilder str = new StringBuilder(String.valueOf(num)).reverse();
        return str.toString().equals(String.valueOf(num));
    }

    public static boolean isGapful(long num) {
        String[] str = String.valueOf(num).split("");
        return num % Long.parseLong(str[0] + str[str.length - 1]) == 0 && num >= 100;
    }

    public static boolean isSquare(long x)
    {
        double sq = Math.sqrt(x);
        return ((sq - Math.floor(sq)) == 0);
    }

    public static boolean isSunny (long x) {
        return isSquare(x + 1);
    }
}
