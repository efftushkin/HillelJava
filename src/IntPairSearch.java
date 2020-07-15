import java.util.Random;

public class IntPairSearch {
    public static void main(String[] args) {
        int SEARCH_VALUE = 99_998;

        int ARRAY_SIZE = 100_000;
        int[] array = new int[ARRAY_SIZE];
        Random random = new Random();

        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt(50_000);
        }

        int found = 0;

        for (int i = 0; i < ARRAY_SIZE - 1; i++) {
            for (int j = i + 1; j < ARRAY_SIZE; j++) {
                if (array[i] + array[j] == SEARCH_VALUE) {
                    System.out.println("a[" + i + "] + a[" + j + "] = " + array[i] + " + " + array[j] + " = " + SEARCH_VALUE);

                    found++;
                }
            }
        }

        System.out.println("Found " + found + " matches");
    }
}
