package LinkedList;

import java.math.BigDecimal;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        System.out.println("Collection contains 8: " + linkedList.contains(8));
        System.out.println(linkedList.toString());
        System.out.println("Collection is empty: " + linkedList.isEmpty());

        linkedList.add("First");
        linkedList.add(2);
        linkedList.add(3.3);
        linkedList.add("Thursday");
        linkedList.add(new BigDecimal("5.55555"));

        System.out.println(linkedList);
        System.out.println("Collection is empty: " + linkedList.isEmpty());

        System.out.println("Remove null: " + linkedList.remove(null));
        System.out.println("Remove Second: " + linkedList.remove("Second"));
        System.out.println("Remove 3.3: " + linkedList.remove(3.3));

        System.out.println(linkedList);
        System.out.println("Size of collection: " + linkedList.size());

        linkedList.add("Wednesday");
        linkedList.add("Wednesday");
        linkedList.add("Wednesday");
        linkedList.add("Wednesday");
        linkedList.add("Wednesday");
        System.out.println(linkedList);
        System.out.println("Size of collection: " + linkedList.size());

        System.out.println("Remove Wednesday: " + linkedList.remove("Wednesday"));
        System.out.println(linkedList);

        System.out.println("Collection contains 8: " + linkedList.contains(8));
        System.out.println("Collection contains BigDecimal 5.55555: " + linkedList.contains(new BigDecimal("5.55555")));

        linkedList.clear();
        System.out.println("Clear: " + linkedList);
        System.out.println("Size of collection: " + linkedList.size());

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        LinkedList newLinkedList = new LinkedList();
        newLinkedList.add(3);
        newLinkedList.add(2);

        linkedList.retainAll(newLinkedList);
        System.out.println("Retain: 3, 2 of 1, 2, 3, 4, 5: " + linkedList);
        System.out.println("Size of collection: " + linkedList.size());

        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(1);
        System.out.println("Added 4, 5, 1: " + linkedList);

        linkedList.removeAll(newLinkedList);
        System.out.println("Removed 3, 2: " + linkedList);

        System.out.println("Contains 2 and 3: " + linkedList.containsAll(newLinkedList));
        linkedList.add(3);
        System.out.println("Added 3: " + linkedList);
        System.out.println("Contains 2 and 3: " + linkedList.containsAll(newLinkedList));
        linkedList.add(2);
        System.out.println("Added 2: " + linkedList);
        System.out.println("Contains 2 and 3: " + linkedList.containsAll(newLinkedList));

        Object[] array = new Object[] {1, 9, 15};
        Object[] newArray = linkedList.toArray(array);
        System.out.println(Arrays.toString(newArray));
        array = new Object[] {1, 9, 15, 22, 18};
        newArray = linkedList.toArray(array);
        System.out.println(Arrays.toString(newArray));
        array = new Object[] {1, 9, 15, 22, 18, -1, '*'};
        newArray = linkedList.toArray(array);
        System.out.println(Arrays.toString(newArray));

        System.out.println("For each:");
        for (Object element : linkedList) {
            System.out.println(element);
        }
        linkedList.remove(1);
        System.out.println("For each (removed 1):");
        for (Object element : linkedList) {
            System.out.println(element);
        }
        linkedList.remove(2);
        System.out.println("For each (removed 2):");
        for (Object element : linkedList) {
            System.out.println(element);
        }

        System.out.println("Remove each:");
        for (Object element : linkedList) {
            linkedList.remove(element);
            System.out.println("Removed " + element);
        }
        System.out.println(linkedList);

        System.out.println("For each (empty list):");
        for (Object element : linkedList) {
            System.out.println(element);
        }
    }
}
