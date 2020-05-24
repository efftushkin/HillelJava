package MyCollection;

public class MyCollection {
    private static final int DEFAULT_CAPACITY = 10;
    Object[] collection;
    int size;
    int maxIndex;

    public MyCollection() {
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

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

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

    public Object[] getArray() {
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

    public boolean addAll(MyCollection collection) {
        if (collection == null) {
            return false;
        }
        if (collection.size == 0) {
            return false;
        }

        Object[] newArray = collection.getArray();

        for (Object element : newArray) {
            add(element);
        }

        return true;
    }

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

    public void clear() {
        for (int i = 0; i <= maxIndex; i++) {
            collection[i] = null;
        }

        size = 0;
        maxIndex = -1;
    }

    public boolean retainAll(MyCollection collection) {
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

    public boolean removeAll(MyCollection collection) {
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

    public boolean containsAll(MyCollection collection) {
        if (collection == null) {
            return false;
        }
        if (collection.size == 0) {
            return false;
        }

        Object[] newArray = collection.getArray();

        for (Object element : newArray) {
            if (!contains(element)) {
                return false;
            }
        }

        return true;
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
}
