package MyCollection;

import java.math.BigDecimal;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyCollection myCollection = new MyCollection();

        System.out.println("myCollection contains 8: " + myCollection.contains(8));
        System.out.println(myCollection.toString());
        System.out.println("myCollection is empty: " + myCollection.isEmpty());

        myCollection.add("First");
        myCollection.add(2);
        myCollection.add(3.3);
        myCollection.add("Thursday");
        myCollection.add(new BigDecimal("5.55555"));

        System.out.println(myCollection.toString());
        System.out.println("myCollection is empty: " + myCollection.isEmpty());

        System.out.println("Remove null: " + myCollection.remove(null));
        System.out.println("Remove Second: " + myCollection.remove("Second"));
        System.out.println("Remove 3.3: " + myCollection.remove(3.3));

        System.out.println(myCollection.toString());
        System.out.println("Size of myCollection: " + myCollection.size());

        myCollection.add("Wednesday");
        myCollection.add("Wednesday");
        myCollection.add("Wednesday");
        myCollection.add("Wednesday");
        myCollection.add("Wednesday");
        System.out.println(myCollection.toString());
        System.out.println("Size of myCollection: " + myCollection.size());

        System.out.println("Remove Wednesday: " + myCollection.remove("Wednesday"));
        System.out.println(myCollection.toString());

        System.out.println("myCollection contains 8: " + myCollection.contains(8));
        System.out.println("myCollection contains BigDecimal 5.55555: " + myCollection.contains(new BigDecimal("5.55555")));

        myCollection.clear();
        System.out.println("Clear: " + myCollection.toString());
        System.out.println("Size of myCollection: " + myCollection.size());

        myCollection.add(1);
        myCollection.add(2);
        myCollection.add(3);
        myCollection.add(4);
        myCollection.add(5);

        MyCollection newCollection = new MyCollection();
        newCollection.add(3);
        newCollection.add(2);

        myCollection.retainAll(newCollection);
        System.out.println("Retain: 3, 2 of 1, 2, 3, 4, 5: " + myCollection.toString());
        System.out.println("Size of myCollection: " + myCollection.size());

        myCollection.add(4);
        myCollection.add(5);
        myCollection.add(1);
        System.out.println("Added 4, 5, 1: " + myCollection.toString());

        myCollection.removeAll(newCollection);
        System.out.println("Removed 3, 2: " + myCollection.toString());

        System.out.println("Contains 2 and 3: " + myCollection.containsAll(newCollection));
        myCollection.add(3);
        System.out.println("Added 3: " + myCollection.toString());
        System.out.println("Contains 2 and 3: " + myCollection.containsAll(newCollection));
        myCollection.add(2);
        System.out.println("Added 2: " + myCollection.toString());
        System.out.println("Contains 2 and 3: " + myCollection.containsAll(newCollection));
    }
}
