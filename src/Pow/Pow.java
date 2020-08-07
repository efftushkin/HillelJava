package Pow;

public final class Pow {
    private Pow() {
    }

    public static double pow(double number, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (number == 0) {
            return 0;
        }

        if (exponent < 0) {
            number = 1 / number;
            exponent = -exponent;
        }

        double result = 1;
        double rest = 1;
        double lastResult = number;

        while (exponent > 1) {
            if (exponent % 2 == 1) {
                rest *= lastResult;

                exponent -= 1;
            }

            if (exponent / 2 > 0) {
                result = lastResult * lastResult;

                lastResult = result;
                exponent /= 2;
            }
        }

        return result * rest;
    }
}
