import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println("SumOfDigits: Welcome!");

        int inp = GetNaturalNumberFromInput();

        int sum = GetSumOfDigits(inp);

        System.out.println("The sum of digits of number" + inp + " is " + sum);

        System.exit(0);
    }

    public static int GetSumOfDigits(int num) {
        int sum = num % 10;

        if (num < 10) {
            return sum;
        } else {
            return sum + GetSumOfDigits((num - sum) / 10);
        }
    }

    public static int GetNaturalNumberFromInput() {
        Scanner scanner = new Scanner(System.in);

        int inp = 0;

        do {
            System.out.println("Please input the natural number");
            if (scanner.hasNextInt()) {
                inp = scanner.nextInt();

                if (inp <= 0) {
                    System.out.println("Your input " + inp + " as the natural number. Please try again");
                } else {
                    System.out.println("Your input " + inp + " as the natural number");
                }
            } else {
                System.out.println("Incorrect entry, exception " + scanner.next() + ". Please enter natural numbers. Try again");
            }
        }
        while (inp <= 0);

        scanner.close();

        return inp;
    }
}