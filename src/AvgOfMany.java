import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class AvgOfMany {
    public static void main(String[] args) {
        System.out.println("AvgOfMany: Welcome!");

        Scanner scanner = new Scanner(System.in);

        BigDecimal num1 = null;
        BigDecimal num2;
        int counter = 0;

        do {
            System.out.println("Please input the first number");
            if (scanner.hasNextBigDecimal()) {
                num1 = scanner.nextBigDecimal();
                System.out.println("Your input " + num1.toPlainString() + " as the first number");
                counter++;
            } else {
                System.out.println("Incorrect entry, exception " + scanner.next() + ". Please enter numbers. Try again");
            }
        }
        while (num1 == null);

        do {
            System.out.println("Please input the next number (to stop input not number)");
            if (scanner.hasNextBigDecimal()) {
                num2 = scanner.nextBigDecimal();
                System.out.println("Your input " + num2.toPlainString() + " as the next number");
                num1 = num1.add(num2);
                counter++;
            } else {
                break;
            }
        }
        while (true);

        System.out.println("Result: " + num1.divide(BigDecimal.valueOf(counter), 8, RoundingMode.HALF_UP).toPlainString());

        scanner.close();
        System.exit(0);
    }
}