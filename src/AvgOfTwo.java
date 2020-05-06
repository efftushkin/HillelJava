import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class AvgOfTwo {
    public static void main(String[] args) {
        System.out.println("AvgOfTwo: Welcome!");

        Scanner scanner = new Scanner(System.in);

        BigDecimal num1 = null;
        BigDecimal num2 = null;

        do {
            System.out.println("Please input the first number");
            if (scanner.hasNextBigDecimal()) {
                num1 = scanner.nextBigDecimal();
                System.out.println("Your input " + num1.toPlainString() + " as the first number");
            } else {
                System.out.println("Incorrect entry, exception " + scanner.next() + ". Please enter numbers. Try again");
            }
        }
        while (num1 == null);

        do {
            System.out.println("Please input the second number");
            if (scanner.hasNextBigDecimal()) {
                num2 = scanner.nextBigDecimal();
                System.out.println("Your input " + num2.toPlainString() + " as the second number");
            } else {
                System.out.println("Incorrect entry, exception " + scanner.next() + ". Please enter numbers. Try again");
            }
        }
        while (num2 == null);

        System.out.println("Result: " + num1.add(num2).divide(new BigDecimal("2"), 8, RoundingMode.HALF_UP).toPlainString());

        scanner.close();
        System.exit(0);
    }
}