package MyCollectionImplementing;

import java.math.BigDecimal;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyCollectionImplementing myCollectionImplementing = new MyCollectionImplementing();

        System.out.println("myCollection contains 8: " + myCollectionImplementing.contains(8));
        System.out.println(myCollectionImplementing.toString());
        System.out.println("myCollection is empty: " + myCollectionImplementing.isEmpty());

        myCollectionImplementing.add("First");
        myCollectionImplementing.add(2);
        myCollectionImplementing.add(3.3);
        myCollectionImplementing.add("Thursday");
        myCollectionImplementing.add(new BigDecimal("5.55555"));

        System.out.println(myCollectionImplementing.toString());
        System.out.println("myCollection is empty: " + myCollectionImplementing.isEmpty());

        System.out.println("Remove null: " + myCollectionImplementing.remove(null));
        System.out.println("Remove Second: " + myCollectionImplementing.remove("Second"));
        System.out.println("Remove 3.3: " + myCollectionImplementing.remove(3.3));

        System.out.println(myCollectionImplementing.toString());
        System.out.println("Size of myCollection: " + myCollectionImplementing.size());

        myCollectionImplementing.add("Wednesday");
        myCollectionImplementing.add("Wednesday");
        myCollectionImplementing.add("Wednesday");
        myCollectionImplementing.add("Wednesday");
        myCollectionImplementing.add("Wednesday");
        System.out.println(myCollectionImplementing.toString());
        System.out.println("Size of myCollection: " + myCollectionImplementing.size());

        System.out.println("Remove Wednesday: " + myCollectionImplementing.remove("Wednesday"));
        System.out.println(myCollectionImplementing.toString());

        System.out.println("myCollection contains 8: " + myCollectionImplementing.contains(8));
        System.out.println("myCollection contains BigDecimal 5.55555: " + myCollectionImplementing.contains(new BigDecimal("5.55555")));

        myCollectionImplementing.clear();
        System.out.println("Clear: " + myCollectionImplementing.toString());
        System.out.println("Size of myCollection: " + myCollectionImplementing.size());

        myCollectionImplementing.add(1);
        myCollectionImplementing.add(2);
        myCollectionImplementing.add(3);
        myCollectionImplementing.add(4);
        myCollectionImplementing.add(5);

        MyCollectionImplementing newMyCollectionImplementing = new MyCollectionImplementing();
        newMyCollectionImplementing.add(3);
        newMyCollectionImplementing.add(2);

        myCollectionImplementing.retainAll(newMyCollectionImplementing);
        System.out.println("Retain: 3, 2 of 1, 2, 3, 4, 5: " + myCollectionImplementing.toString());
        System.out.println("Size of myCollection: " + myCollectionImplementing.size());

        myCollectionImplementing.add(4);
        myCollectionImplementing.add(5);
        myCollectionImplementing.add(1);
        System.out.println("Added 4, 5, 1: " + myCollectionImplementing.toString());

        myCollectionImplementing.removeAll(newMyCollectionImplementing);
        System.out.println("Removed 3, 2: " + myCollectionImplementing.toString());

        System.out.println("Contains 2 and 3: " + myCollectionImplementing.containsAll(newMyCollectionImplementing));
        myCollectionImplementing.add(3);
        System.out.println("Added 3: " + myCollectionImplementing.toString());
        System.out.println("Contains 2 and 3: " + myCollectionImplementing.containsAll(newMyCollectionImplementing));
        myCollectionImplementing.add(2);
        System.out.println("Added 2: " + myCollectionImplementing.toString());
        System.out.println("Contains 2 and 3: " + myCollectionImplementing.containsAll(newMyCollectionImplementing));

        Object[] array = new Object[] {1, 9, 15};
        Object[] newArray = myCollectionImplementing.toArray(array);
        System.out.println(Arrays.toString(newArray));
        array = new Object[] {1, 9, 15, 22, 18};
        newArray = myCollectionImplementing.toArray(array);
        System.out.println(Arrays.toString(newArray));
        array = new Object[] {1, 9, 15, 22, 18, -1, '*'};
        newArray = myCollectionImplementing.toArray(array);
        System.out.println(Arrays.toString(newArray));

        System.out.println("For each:");
        for (Object element : myCollectionImplementing) {
            System.out.println(element);
        }
        myCollectionImplementing.remove(1);
        System.out.println("For each (removed 1):");
        for (Object element : myCollectionImplementing) {
            System.out.println(element);
        }
        myCollectionImplementing.remove(3);
        System.out.println("For each (removed 3):");
        for (Object element : myCollectionImplementing) {
            System.out.println(element);
        }

        System.out.println("Remove each:");
        for (Object element : myCollectionImplementing) {
            myCollectionImplementing.remove(element);
            System.out.println("Removed " + element);
        }
        System.out.println(myCollectionImplementing);

        System.out.println("For each (empty collection):");
        for (Object element : myCollectionImplementing) {
            System.out.println(element);
        }
    }
}
