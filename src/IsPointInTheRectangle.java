import java.util.Scanner;
import java.util.Arrays;

public class IsPointInTheRectangle {
    public static void main(String[] args) {
        System.out.println("IsPointInTheRectangle: Welcome!");

        Scanner scanner = new Scanner(System.in);
        int[] p1 = {0, 0};
        int[] p2 = {0, 0};
        int[] p3 = {0, 0};

        GetPointCoordinatesFromInput(scanner, p1, "top left corner of rectangle");
        GetPointCoordinatesFromInput(scanner, p2, "bottom right corner of rectangle");

        while (p2[0] <= p1[0] || p1[1] <= p2[1]) {
            System.out.println("Please input valid coordinates of the bottom right corner of rectangle (top left is " + Arrays.toString(p1) + ")");
            GetPointCoordinatesFromInput(scanner, p2, "bottom right corner of rectangle");
        }

        GetPointCoordinatesFromInput(scanner, p3, "point");

        if (p1[0] <= p3[0] && p3[0] <= p2[0] && p2[1] <= p3[1] && p3[1] <= p1[1]) {
            System.out.println("The point " + Arrays.toString(p3) + " is in the rectangle");
        } else {
            System.out.println("The point " + Arrays.toString(p3) + " is not in the rectangle");
        }

        scanner.close();
        System.exit(0);
    }

    public static void GetPointCoordinatesFromInput(Scanner scanner, int[] arr, String pointName) {
        System.out.println("Please input coordinates of the " + pointName);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = GetIntFromInput(scanner, "coordinate № " + (i + 1));
        }
    }

    public static int GetIntFromInput(Scanner scanner, String numberName) {
        int inp = 0;
        boolean gotIntInput = false;

        do {
            System.out.println("Please input the " + numberName);

            if (scanner.hasNextInt()) {
                inp = scanner.nextInt();
                System.out.println("Your input " + inp + " as the " + numberName);
                gotIntInput = true;
            } else {
                System.out.println("Incorrect entry, exception " + scanner.next() + ". Please enter integer numbers. Try again");
            }
        }
        while (!gotIntInput);

        return inp;
    }
}