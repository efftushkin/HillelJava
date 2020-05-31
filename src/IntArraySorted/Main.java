package IntArraySorted;

public class Main {
    public static void main(String[] args) {
        IntArraySorted intArraySorted = new IntArraySorted();
        IntArraySorted newArraySorted = new IntArraySorted();

        System.out.println("Array: " + intArraySorted);
        System.out.println("Length: " + intArraySorted.size());

        intArraySorted.add(1);
        intArraySorted.add(4);
        intArraySorted.add(-51);
        intArraySorted.add(14);
        intArraySorted.add(-68);

        System.out.println("Array: " + intArraySorted);
        System.out.println("Length: " + intArraySorted.size());
        System.out.println("Get by index 2: " + intArraySorted.get(2));
        System.out.println("Contains 8: " + intArraySorted.contains(8));
        System.out.println("Contains -51: " + intArraySorted.contains(-51));
        System.out.println("Index of 8: " + intArraySorted.indexOf(8));
        System.out.println("Index of -51: " + intArraySorted.indexOf(-51));

        newArraySorted.add(-11);
        newArraySorted.add(62);

        System.out.println("New array: " + newArraySorted);

        intArraySorted.addAll(newArraySorted);
        System.out.println("Array after adding new array: " + intArraySorted);
        for (int i = 0; i < intArraySorted.size(); i++) {
            int value = intArraySorted.get(i);
            System.out.println("Index of " + value + ": " + intArraySorted.indexOf(value));
        }

        intArraySorted.add(415);
        intArraySorted.add(0);
        intArraySorted.add(0);
        intArraySorted.add(-415);
        System.out.println("Array: " + intArraySorted);
        intArraySorted.remove(0);
        System.out.println("Array, removed 0: " + intArraySorted);

        System.out.println("Array is equal to new array: " + intArraySorted.equals(newArraySorted));

        intArraySorted.retainAll(newArraySorted);
        System.out.println("Array after retainAll(new array): " + intArraySorted);

        intArraySorted.clear();
        newArraySorted.clear();
        System.out.println("Clear array: " + intArraySorted);
        System.out.println("Clear new array: " + newArraySorted);

        intArraySorted.add(128);
        intArraySorted.add(256);
        intArraySorted.add(512);
        newArraySorted.addAll(intArraySorted);

        System.out.println("Array: " + intArraySorted);
        System.out.println("New array: " + newArraySorted);

        System.out.println("Array is equal to new array: " + intArraySorted.equals(newArraySorted));
    }
}
