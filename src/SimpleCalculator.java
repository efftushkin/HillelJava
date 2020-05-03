import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        System.out.println("SimpleCalculator: Welcome!");

        Scanner scanner = new Scanner(System.in);

        BigDecimal num1 = null;
        BigDecimal num2 = null;

        do {
            System.out.println("Please, input the first number");
            if (scanner.hasNextBigDecimal()) {
                num1 = scanner.nextBigDecimal();
                System.out.println("Your input " + num1.toPlainString() + " as the first number");
            } else {
                System.out.println("Incorrect entry, exception " + scanner.nextLine() + ". You must enter numbers. Try again");
            }
        }
        while (num1 == null);

        do {
            System.out.println("Please, input the second number");
            if (scanner.hasNextBigDecimal()) {
                num2 = scanner.nextBigDecimal();
                System.out.println("Your input " + num2.toPlainString() + " as the second number.");
            } else {
                System.out.println("Incorrect entry, exception " + scanner.nextLine() + ". You must enter numbers. Try again.");
            }
        }
        while (num2 == null);

        BigDecimal sum = (num1.add(num2));
        int newScale = sum.scale();

        if (newScale > 8) {
            newScale = 8;
        }

        sum = sum.setScale(newScale, RoundingMode.HALF_UP);

        BigDecimal dif = (num1.subtract(num2));
        newScale = dif.scale();

        if (newScale > 8) {
            newScale = 8;
        }

        dif = dif.setScale(newScale, RoundingMode.HALF_UP);

        BigDecimal mul = (num1.multiply(num2));
        newScale = mul.scale();

        if (newScale > 8) {
            newScale = 8;
        }

        mul = mul.setScale(newScale, RoundingMode.HALF_UP);

        String divOutput;
        if (!num2.equals(BigDecimal.ZERO)) {
            BigDecimal div = num1.divide(num2, 8, RoundingMode.HALF_UP);
            newScale = div.scale();

            if (newScale > 8) {
                newScale = 8;
            }

            div = div.setScale(newScale, RoundingMode.HALF_UP);

            divOutput = div.toPlainString();
        } else {
            divOutput = "You can't divide by zero";
        }

        System.out.println("Results:");
        System.out.println("Sum is: " + sum.toPlainString());
        System.out.println("Difference is: " + dif.toPlainString());
        System.out.println("Multiplication is: " + mul.toPlainString());
        System.out.println("Division is: " + divOutput);

        scanner.close();
        System.exit(0);
    }
}