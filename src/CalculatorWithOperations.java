import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class CalculatorWithOperations {
    public static void main(String[] args) {
        System.out.println("SimpleCalculator: Welcome!");

        Scanner scanner = new Scanner(System.in);

        BigDecimal num1 = null;
        BigDecimal num2 = null;
        BigDecimal result = null;
        char op = '#';
        boolean divByZero = false;

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
            System.out.println("Please input the operator (+, -, /, *)");
            if (scanner.hasNext("[+-/*]")) {
                op = scanner.next().charAt(0);
                System.out.println("Your input " + op + " as the operator");
            } else {
                System.out.println("Incorrect entry, exception " + scanner.next() + ". Please enter symbols +, -, / or *. Try again");
            }
        }
        while (op == '#');

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


        switch (op) {
            case '+':
                result = num1.add(num2);
                break;
            case '-':
                result = num1.subtract(num2);
                break;
            case '*':
                result = num1.multiply(num2);
                break;
            case '/':
                if (!num2.equals(BigDecimal.ZERO)) {
                    result = num1.divide(num2, 8, RoundingMode.HALF_UP);
                } else {
                    divByZero = true;
                }
        }

        if (divByZero) {
            System.out.println("You can't divide by zero");
            return;
        }

        int newScale = result.scale();

        if (newScale > 8) {
            newScale = 8;
        }

        result = result.setScale(newScale, RoundingMode.HALF_UP);

        System.out.println("Result: " + result.toPlainString());

        scanner.close();
        System.exit(0);
    }
}