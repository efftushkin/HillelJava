package LinkedListImplementsList;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        MyLinkedList newMyLinkedList = new MyLinkedList();

        System.out.println("Collection contains 8: " + myLinkedList.contains(8));
        System.out.println(myLinkedList.toString());
        System.out.println("Collection is empty: " + myLinkedList.isEmpty());

        myLinkedList.add("First");
        myLinkedList.add(2);
        myLinkedList.add(3.3);
        myLinkedList.add("Thursday");
        myLinkedList.add(new BigDecimal("5.55555"));

        System.out.println(myLinkedList);
        System.out.println("Collection is empty: " + myLinkedList.isEmpty());

        System.out.println("Remove null: " + myLinkedList.remove(null));
        System.out.println("Remove Second: " + myLinkedList.remove("Second"));
        System.out.println("Remove 3.3: " + myLinkedList.remove(3.3));

        System.out.println(myLinkedList);
        System.out.println("Size of collection: " + myLinkedList.size());

        myLinkedList.add("Wednesday");
        myLinkedList.add("Wednesday");
        myLinkedList.add("Wednesday");
        myLinkedList.add("Wednesday");
        myLinkedList.add("Wednesday");
        System.out.println(myLinkedList);
        System.out.println("Size of collection: " + myLinkedList.size());

        System.out.println("Remove Wednesday: " + myLinkedList.remove("Wednesday"));
        System.out.println(myLinkedList);

        System.out.println("Collection contains 8: " + myLinkedList.contains(8));
        System.out.println("Collection contains BigDecimal 5.55555: " + myLinkedList.contains(new BigDecimal("5.55555")));

        myLinkedList.clear();
        System.out.println("Clear: " + myLinkedList);
        System.out.println("Size of collection: " + myLinkedList.size());

        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);

        System.out.println("List: " + myLinkedList);
        myLinkedList.push(33);
        System.out.println("List (pushed 33): " + myLinkedList);
        while (myLinkedList.size() != 0) {
            System.out.println("pop: " + myLinkedList.pop());
        }
        System.out.println("Result after pop all: " + myLinkedList);

        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);

        newMyLinkedList.add(3);
        newMyLinkedList.add(2);

        myLinkedList.retainAll(newMyLinkedList);
        System.out.println("Retain: 3, 2 of 1, 2, 3, 4, 5: " + myLinkedList);
        System.out.println("Size of collection: " + myLinkedList.size());

        myLinkedList.add(4);
        myLinkedList.add(5);
        myLinkedList.add(1);
        System.out.println("Added 4, 5, 1: " + myLinkedList);

        myLinkedList.removeAll(newMyLinkedList);
        System.out.println("Removed 3, 2: " + myLinkedList);

        System.out.println("Contains 2 and 3: " + myLinkedList.containsAll(newMyLinkedList));
        myLinkedList.add(3);
        System.out.println("Added 3: " + myLinkedList);
        System.out.println("Contains 2 and 3: " + myLinkedList.containsAll(newMyLinkedList));
        myLinkedList.add(2);
        System.out.println("Added 2: " + myLinkedList);
        System.out.println("Contains 2 and 3: " + myLinkedList.containsAll(newMyLinkedList));

        Object[] array = new Object[]{1, 9, 15};
        Object[] newArray = myLinkedList.toArray(array);
        System.out.println(Arrays.toString(newArray));
        array = new Object[]{1, 9, 15, 22, 18};
        newArray = myLinkedList.toArray(array);
        System.out.println(Arrays.toString(newArray));
        array = new Object[]{1, 9, 15, 22, 18, -1, '*'};
        newArray = myLinkedList.toArray(array);
        System.out.println(Arrays.toString(newArray));

        System.out.println("For each:");
        for (Object element : myLinkedList) {
            System.out.println(element);
        }
        myLinkedList.remove(1);
        System.out.println("For each (removed 1):");
        for (Object element : myLinkedList) {
            System.out.println(element);
        }
        myLinkedList.remove(2);
        System.out.println("For each (removed 2):");
        for (Object element : myLinkedList) {
            System.out.println(element);
        }

        myLinkedList.add(4);
        System.out.println("Added 4:");
        for (Object element : myLinkedList) {
            System.out.println(element);
        }

        System.out.println("Remove each:");
        for (Object element : myLinkedList) {
            myLinkedList.remove(element);
            System.out.println("Removed " + element);
        }
        System.out.println(myLinkedList);

        System.out.println("For each (empty list), begin:");
        for (Object element : myLinkedList) {
            System.out.println(element);
        }
        System.out.println("For each (empty list), end");


        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        System.out.println("List: " + myLinkedList);

        List subList = myLinkedList.subList(2, 4);
        System.out.println("Sublist (2, 4): " + subList);

        ListIterator iterator = myLinkedList.listIterator();
        System.out.println("Forward iteration:");
        while (iterator.hasNext()) {
            System.out.println("[" + iterator.nextIndex() + "] " + iterator.next());
        }

        System.out.println("Backward iteration:");
        iterator = myLinkedList.listIterator(myLinkedList.size() - 1);
        while (iterator.hasPrevious()) {
            System.out.println("[" + iterator.previousIndex() + "] " + iterator.previous());
        }

        System.out.println("Backward iteration, adding 2.2 before third element:");
        boolean isAdded = false;
        iterator = myLinkedList.listIterator(myLinkedList.size() - 1);
        while (iterator.hasPrevious()) {
            if (iterator.previousIndex() == 2 && !isAdded) {
                iterator.add(2.2);
                isAdded = true;
                System.out.println("Added 2.2");
            }

            System.out.println("[" + iterator.previousIndex() + "] " + iterator.previous());
        }

        iterator = myLinkedList.listIterator();
        System.out.println("Forward iteration:");
        while (iterator.hasNext()) {
            int nextIndex = iterator.nextIndex();

            if (nextIndex == 2) {
                iterator.set(2.5);
                System.out.println("[" + nextIndex + "] -> 2.5");
            }

            System.out.println("[" + nextIndex + "] " + iterator.next());
        }
        System.out.println(myLinkedList);

        iterator = myLinkedList.listIterator();
        System.out.println("Removing all while forward iteration:");
        while (iterator.hasNext()) {
            System.out.println("Current index: " + iterator.nextIndex());
            iterator.remove();
        }
        System.out.println(myLinkedList);

        myLinkedList.add(-2);
        myLinkedList.add(-8);
        myLinkedList.add(0.0000000004);
        myLinkedList.add("Zeta");
        myLinkedList.add(0.0000000003);
        myLinkedList.add(0.0000000002);
        myLinkedList.add(0.0000000001);
        myLinkedList.add("Alpha");
        myLinkedList.add("zeta");
        myLinkedList.add("beta");
        System.out.println("List: " + myLinkedList);
        myLinkedList.sort(new MyLinkedListComparator());
        System.out.println("List: " + myLinkedList);
    }
}
