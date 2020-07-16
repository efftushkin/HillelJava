import java.util.HashMap;
import java.util.Random;

public class IntPairSearch {
    public static void main(String[] args) {
        int SEARCH_VALUE = -999_998;
        int ARRAY_SIZE = 1_000_000;
        int RANDOM_BOUND = 1000_000;

        int[] array = new int[ARRAY_SIZE];
        Random random = new Random();

        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt(RANDOM_BOUND) - RANDOM_BOUND / 2;
        }

        HashMap<Integer, Integer> cacheMap = new HashMap<>();

        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (i == 0) {
                cacheMap.put(array[i], i);
                continue;
            }

            Integer properIndex = cacheMap.get(SEARCH_VALUE - array[i]);
            if (properIndex != null) {
                System.out.println("a[" + properIndex + "] + a[" + i + "] = " + array[properIndex] + " + " + array[i] + " = " + SEARCH_VALUE);
                return;
            }

            cacheMap.put(array[i], i);
        }

        System.out.println("Nothing found");
    }
}
