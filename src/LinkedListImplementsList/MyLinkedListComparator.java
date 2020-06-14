package LinkedListImplementsList;

import java.util.Comparator;

public class MyLinkedListComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Number && o2 instanceof Number) {
            Number n1 = (Number) o1;
            Number n2 = (Number) o2;
            if (n1.doubleValue() < n2.doubleValue()) {
                return -1;
            } else if (n1.doubleValue() > n2.doubleValue()) {
                return 1;
            } else {
                return 0;
            }
        }
        if (o1 instanceof String && o2 instanceof String) {
            return ((String) o1).compareTo((String) o2);
        }

        if (o1 instanceof Number) {
            return -1;
        } else if (o2 instanceof Number) {
            return 1;
        }

        return 0;
    }
}
