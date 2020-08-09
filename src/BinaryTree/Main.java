package BinaryTree;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree newBinaryTree = new BinaryTree();

        System.out.println("Collection contains 8: " + binaryTree.contains(8));
        System.out.println(binaryTree.toString());
        System.out.println("Collection is empty: " + binaryTree.isEmpty());

        binaryTree.add("First");
        binaryTree.add(2);
        binaryTree.add(3.3);
        binaryTree.add("Thursday");
        binaryTree.add(new BigDecimal("5.55555"));

        System.out.println(binaryTree);
        System.out.println("Collection is empty: " + binaryTree.isEmpty());

        System.out.println("Remove null: " + binaryTree.remove(null));
        System.out.println("Remove Second: " + binaryTree.remove("Second"));
        System.out.println("Remove 3.3: " + binaryTree.remove(3.3));

        System.out.println(binaryTree);
        System.out.println("Size of collection: " + binaryTree.size());

        System.out.println("Added Wednesday: " + binaryTree.add("Wednesday"));
        System.out.println("Added Wednesday: " + binaryTree.add("Wednesday"));
        System.out.println("Added Wednesday: " + binaryTree.add("Wednesday"));
        System.out.println(binaryTree);
        System.out.println("Size of collection: " + binaryTree.size());

        System.out.println("Remove Wednesday: " + binaryTree.remove("Wednesday"));
        System.out.println(binaryTree);

        System.out.println("Collection contains 8: " + binaryTree.contains(8));
        System.out.println("Collection contains BigDecimal 5.55555: " + binaryTree.contains(new BigDecimal("5.55555")));

        binaryTree.clear();
        System.out.println("Clear: " + binaryTree);
        System.out.println("Size of collection: " + binaryTree.size());

        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(5);

        System.out.println("List: " + binaryTree);

        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(5);

        newBinaryTree.add(3);
        newBinaryTree.add(2);

        binaryTree.retainAll(newBinaryTree);
        System.out.println("Retain: 3, 2 of 1, 2, 3, 4, 5: " + binaryTree);
        System.out.println("Size of collection: " + binaryTree.size());

        binaryTree.add(4);
        binaryTree.add(5);
        binaryTree.add(1);
        System.out.println("Added 4, 5, 1: " + binaryTree);

        binaryTree.removeAll(newBinaryTree);
        System.out.println("Removed 3, 2: " + binaryTree);

        System.out.println("Contains 2 and 3: " + binaryTree.containsAll(newBinaryTree));
        binaryTree.add(3);
        System.out.println("Added 3: " + binaryTree);
        System.out.println("Contains 2 and 3: " + binaryTree.containsAll(newBinaryTree));
        binaryTree.add(2);
        System.out.println("Added 2: " + binaryTree);
        System.out.println("Contains 2 and 3: " + binaryTree.containsAll(newBinaryTree));

        Object[] array = new Object[]{1, 9, 15};
        Object[] newArray = binaryTree.toArray(array);
        System.out.println(Arrays.toString(newArray));
        array = new Object[]{1, 9, 15, 22, 18};
        newArray = binaryTree.toArray(array);
        System.out.println(Arrays.toString(newArray));
        array = new Object[]{1, 9, 15, 22, 18, -1, '*'};
        newArray = binaryTree.toArray(array);
        System.out.println(Arrays.toString(newArray));

        System.out.println("For each:");
        for (Object element : binaryTree) {
            System.out.println(element);
        }
        binaryTree.remove(1);
        System.out.println("For each (removed 1):");
        for (Object element : binaryTree) {
            System.out.println(element);
        }
        binaryTree.remove(2);
        System.out.println("For each (removed 2):");
        for (Object element : binaryTree) {
            System.out.println(element);
        }

        binaryTree.add(4);
        System.out.println("Added 4:");
        for (Object element : binaryTree) {
            System.out.println(element);
        }

        System.out.println("Remove each:");
        for (Object element : binaryTree) {
            binaryTree.remove(element);
            System.out.println("Removed " + element);
        }
        System.out.println(binaryTree);

        System.out.println("For each (empty list), begin:");
        for (Object element : binaryTree) {
            System.out.println(element);
        }
        System.out.println("For each (empty list), end");

        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(5);
        System.out.println("List: " + binaryTree);

        Iterator iterator = binaryTree.iterator();
        System.out.println("Forward iteration:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(binaryTree);

        binaryTree.clear();
        System.out.println("Empty set: " + binaryTree);

        binaryTree.add(-2);
        binaryTree.add(-8);
        binaryTree.add(0.0000000002);
        binaryTree.add(0.0000000004);
        binaryTree.add("Zeta");
        binaryTree.add(0.0000000003);
        binaryTree.add(0.0000000001);
        binaryTree.add("Alpha");
        binaryTree.add("zeta");
        binaryTree.add("beta");
        System.out.println("Set: " + binaryTree);
    }
}
