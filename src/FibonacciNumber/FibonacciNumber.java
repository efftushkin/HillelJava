package FibonacciNumber;

import java.math.BigInteger;

public abstract class FibonacciNumber {
    /**
     * Returns the value of number at the specified position of Fibonacci Sequence
     * F(0) = 0, F(1) = 1, F(2) = 1, F(3) = 2, F(4) = 3...
     * @param n position of number (starts from 0)
     * @return the value of number at the specified position of Fibonacci Sequence
     */
    public static BigInteger get(int n) {
        if (n < 0) {
            return BigInteger.valueOf(0);
        }

        if (n <= 1) {
            return BigInteger.valueOf(n);
        }

        BigInteger previous = new BigInteger("0");
        BigInteger current = new BigInteger("1");
        BigInteger tmp;

        for (int i = 2; i <= n; i++) {
            tmp = BigInteger.valueOf(0);
            tmp = tmp.add(current);

            current = current.add(previous);
            previous = BigInteger.valueOf(0);
            previous = previous.add(tmp);
        }

        return current;
    }
}
