import java.util.Scanner;

public class IntAnalyser {
    public static void main(String[] args) {
        System.out.println("IntAnalyser: Welcome!");

        Scanner scanner = new Scanner(System.in);

        int inp = 0;
        boolean isPrime = true;

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

        if (inp % 2 != 0) {
            System.out.println("The number " + inp + " is odd (nechotnoye)");
        } else {
            System.out.println("The number " + inp + " is even (chotnoye)");
        }

        for (int i = 1; i <= inp; i++) {
            if (inp % i == 0 && i > 1 && i < inp) {
                System.out.println("The number " + i + " is multiplier of " + inp);

                if (isPrime) {
                    isPrime = false;
                }
            }
        }
        if (isPrime){
            System.out.println("The number " + inp + " is prime");
        } else {
            System.out.println("The number " + inp + " is composite");
        }

        scanner.close();
        System.exit(0);
    }
}