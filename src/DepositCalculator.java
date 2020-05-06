import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        System.out.println("DepositCalculator: Welcome!");

        Scanner scanner = new Scanner(System.in);

        BigDecimal depo = null;
        BigDecimal percent = null;
        BigDecimal interest;
        int yearCount = 0;

        do {
            System.out.println("Please input the sum of the deposit (positive number)");
            if (scanner.hasNextBigDecimal()) {
                depo = scanner.nextBigDecimal();

                if (depo.compareTo(BigDecimal.ZERO) <= 0) {
                    System.out.println("Your input " + depo.toPlainString() + " as the sum of the deposit. No interest will be charged on such deposit");
                    depo = null;
                } else {
                    System.out.println("Your input " + depo.toPlainString() + " as the sum of the deposit");
                }
            } else {
                System.out.println("Incorrect entry, exception " + scanner.next() + ". Please enter numbers. Try again");
            }
        }
        while (depo == null);

        do {
            System.out.println("Please input the deposit percentage (positive number)");
            if (scanner.hasNextBigDecimal()) {
                percent = scanner.nextBigDecimal();

                if (percent.compareTo(BigDecimal.ZERO) <= 0) {
                    System.out.println("Your input " + percent.toPlainString() + " as the deposit percentage. Please try again");
                    percent = null;
                } else {
                    System.out.println("Your input " + percent.toPlainString() + " as the deposit percentage");
                }
            } else {
                System.out.println("Incorrect entry, exception " + scanner.next() + ". Please enter numbers. Try again");
            }
        }
        while (percent == null);

        do {
            System.out.println("Please input the count of years (natural number)");
            if (scanner.hasNextInt()) {
                yearCount = scanner.nextInt();

                if (yearCount <= 0) {
                    System.out.println("Your input " + percent.toPlainString() + " as the count of years. Please try again");
                } else {
                    System.out.println("Your input " + percent.toPlainString() + " as the count of years");
                }
            } else {
                System.out.println("Incorrect entry, exception " + scanner.next() + ". Please enter natural numbers. Try again");
            }
        }
        while (yearCount <= 0);

        for (int i = 0; i < yearCount; i++) {
            interest = depo.multiply(percent).divide(BigDecimal.valueOf(100), 8, RoundingMode.HALF_UP);
            depo = depo.add(interest);
            System.out.println("Year " + (i + 1) + ": interest is " + interest.toPlainString() + ", deposit is " + depo.toPlainString());
        }

        scanner.close();
        System.exit(0);
    }
}