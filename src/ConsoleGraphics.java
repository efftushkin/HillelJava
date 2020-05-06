import java.util.Scanner;


public class ConsoleGraphics {
    public static void main(String[] args) {
        System.out.println("ConsoleGraphics: Welcome!");

        Scanner scanner = new Scanner(System.in);

        int height = 0;
        int width = 0;
        int shift;
        char symb;

        do {
            System.out.println("Please input the height");
            if (scanner.hasNextInt()) {
                height = scanner.nextInt();

                if (height <= 0) {
                    System.out.println("Your input " + height + " as the height. Please try again");
                } else {
                    System.out.println("Your input " + height + " as the height");
                }
            } else {
                System.out.println("Incorrect entry, exception " + scanner.next() + ". Please enter natural numbers. Try again");
            }
        }
        while (height <= 0);

        do {
            System.out.println("Please input the width");
            if (scanner.hasNextInt()) {
                width = scanner.nextInt();

                if (width <= 0) {
                    System.out.println("Your input " + width + " as the width. Please try again");
                } else {
                    System.out.println("Your input " + width + " as the width");
                }
            } else {
                System.out.println("Incorrect entry, exception " + scanner.next() + ". Please enter natural numbers. Try again");
            }
        }
        while (width <= 0);

        System.out.println("Rectangle:");

        for (int h = 0; h < height; h++){
            for (int w = 0; w < width; w++) {
                if (h == 0 || h == height - 1) {
                    symb = '*';
                } else {
                    if (w == 0 || w == width - 1) {
                        symb = '*';
                    } else {
                        symb = ' ';
                    }
                }

                if (w == width - 1) {
                    System.out.println(symb);
                } else {
                    System.out.print(symb);
                }
            }
        }

        System.out.println("Box:");

        for (int h = 0; h < height; h++){
            for (int w = 0; w < width; w++) {
                if (h == 0 || h == height - 1) {
                    symb = '*';
                } else {
                    if (w == 0 || w == width - 1) {
                        symb = '*';
                    } else {
                        shift = Math.toIntExact(Math.round((double) width / (double) height * (h + 1)));

                        if (w == shift - 1 || w == width - shift) {
                            symb = '*';
                        } else {
                            symb = ' ';
                        }
                    }
                }

                if (w == width - 1) {
                    System.out.println(symb);
                } else {
                    System.out.print(symb);
                }
            }
        }

        System.out.println("Chess Snow:");

        for (int h = 0; h < height; h++){
            for (int w = 0; w < width; w++) {
                if (h % 2 == 0) {
                    if (w % 2 == 0) {
                        symb = '*';
                    } else {
                        symb = ' ';
                    }
                } else {
                    if (w % 2 == 0) {
                        symb = ' ';
                    } else {
                        symb = '*';
                    }
                }

                if (w == width - 1) {
                    System.out.println(symb);
                } else {
                    System.out.print(symb);
                }
            }
        }

        scanner.close();
        System.exit(0);
    }
}