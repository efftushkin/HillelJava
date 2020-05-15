package IntArray;

public class Main {
    public static void main(String[] args) {
        IntArray intArray = new IntArray();
        IntArray newArray = new IntArray();

        System.out.print("Array: ");
        intArray.print();
        System.out.println("Length: " + intArray.getLength());

        intArray.add(1);
        intArray.add(4);
        intArray.add(-51);
        intArray.add(14);
        intArray.add(-68);

        System.out.print("Array: ");
        intArray.print();
        System.out.println("Length: " + intArray.getLength());
        System.out.println("Get by index 2: " + intArray.get(2));
        System.out.println("Contains 8: " + intArray.contains(8));
        System.out.println("Contains -51: " + intArray.contains(-51));
        System.out.println("Index of 8: " + intArray.indexOf(8));
        System.out.println("Index of -51: " + intArray.indexOf(-51));

        intArray.reverse();
        System.out.print("Reversed array: ");
        intArray.print();

        newArray.add(-11);
        newArray.add(62);

        System.out.print("New array: ");
        newArray.print();

        intArray.addAll(newArray);
        System.out.print("Array after adding new array: ");
        intArray.print();

        System.out.println("Array is equal to new array: " + intArray.equals(newArray));

        intArray.sort();
        System.out.print("Sorted array: ");
        intArray.print();

        intArray.clear();
        newArray.clear();
        System.out.print("Clear array: ");
        intArray.print();
        System.out.print("Clear new array: ");
        newArray.print();

        intArray.add(128);
        intArray.add(256);
        intArray.add(512);
        newArray.addAll(intArray);

        System.out.print("Array: ");
        intArray.print();
        System.out.print("New array: ");
        newArray.print();

        System.out.println("Array is equal to new array: " + intArray.equals(newArray));
    }
}
