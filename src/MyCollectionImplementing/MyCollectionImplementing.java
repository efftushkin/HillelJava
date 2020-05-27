package MyCollectionImplementing;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MyCollectionImplementing implements Collection {
    private static final int DEFAULT_CAPACITY = 10;
    Object[] collection;
    int size;
    int maxIndex;

    public MyCollectionImplementing() {
        collection = new Object[DEFAULT_CAPACITY];
        size = 0;
        maxIndex = -1;
    }

    private void increaseCapacity() {
        Object[] newCollection = new Object[collection.length * 2];

        for (int i = 0; i < collection.length; i++) {
            newCollection[i] = collection[i];
        }

        collection = newCollection;
    }

    private void refreshMaxIndex() {
        int newMaxIndex = -1;

        for (int i = 0; i <= maxIndex; i++) {
            if (collection[i] != null) {
                newMaxIndex = i;
            }
        }

        maxIndex = newMaxIndex;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object object) {
        if (object == null) {
            return false;
        }
        for (int i = 0; i <= maxIndex; i++) {
            if (collection[i] == null) {
                continue;
            }
            if (collection[i].equals(object)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size];

        if (size == 0) {
            return newArray;
        }
        int i = 0;
        for (Object element : collection) {
            if (element != null) {
                newArray[i] = element;
                i++;
            }
        }
        return newArray;
    }

    @Override
    public Object[] toArray(Object[] a) {
        if (a.length <= size) {
            return toArray();
        }

        Object[] newArray = new Object[a.length];

        int i = 0;
        for (Object element : collection) {
            if (element != null) {
                newArray[i] = element;
                i++;
            }
        }

        return newArray;
    }

    @Override
    public boolean add(Object object) {
        if (object == null) {
            return false;
        }

        if (size == collection.length) {
            increaseCapacity();
            collection[size] = object;
            maxIndex = size;
        } else {
            for (int i = 0; i < collection.length; i++) {
                if (collection[i] == null) {
                    collection[i] = object;

                    if (i > maxIndex) {
                        maxIndex = i;
                    }

                    break;
                }
            }
        }

        size++;
        return true;
    }

    @Override
    public boolean remove(Object object) {
        if (object == null) {
            return false;
        }

        boolean isRemoved = false;

        for (int i = 0; i <= maxIndex; i++) {
            if (collection[i] == null) {
                continue;
            }
            if (collection[i].equals(object)) {
                collection[i] = null;
                size--;

                isRemoved = true;
            }
        }

        if (isRemoved) {
            refreshMaxIndex();
        }

        return isRemoved;
    }

    @Override
    public boolean containsAll(Collection collection) {
        if (collection == null) {
            return false;
        }
        if (collection.size() == 0) {
            return false;
        }

        Object[] newArray = collection.toArray();

        for (Object element : newArray) {
            if (!contains(element)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection collection) {
        if (collection == null) {
            return false;
        }
        if (collection.size() == 0) {
            return false;
        }

        Object[] newArray = collection.toArray();

        for (Object element : newArray) {
            add(element);
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection collection) {
        if (collection == null) {
            return false;
        }

        boolean isRemoved = false;

        for (int i = 0; i <= maxIndex; i++) {
            if (this.collection == null) {
                continue;
            }
            if (collection.contains(this.collection[i])) {
                this.collection[i] = null;
                size--;

                isRemoved = true;
            }
        }

        if (isRemoved) {
            refreshMaxIndex();
        }

        return isRemoved;
    }

    @Override
    public boolean retainAll(Collection collection) {
        if (collection == null) {
            return false;
        }

        boolean isRemoved = false;

        for (int i = 0; i <= maxIndex; i++) {
            if (this.collection[i] == null) {
                continue;
            }
            if (!collection.contains(this.collection[i])) {
                this.collection[i] = null;
                size--;

                isRemoved = true;
            }
        }

        if (isRemoved) {
            refreshMaxIndex();
        }

        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i <= maxIndex; i++) {
            collection[i] = null;
        }

        size = 0;
        maxIndex = -1;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        String delimiter = "";

        for (int i = 0; i <= maxIndex; i++) {
            if (collection[i] == null) {
                continue;
            }

            result.append(delimiter).append(collection[i].toString());
            delimiter = "; ";
        }

        result.append("]");
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyCollectionImplementing that = (MyCollectionImplementing) o;

        if (size != that.size) return false;
        if (maxIndex != that.maxIndex) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(collection, that.collection);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(collection);
        result = 31 * result + size;
        result = 31 * result + maxIndex;
        return result;
    }
}
