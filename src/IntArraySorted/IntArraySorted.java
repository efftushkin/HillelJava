package IntArraySorted;

public class IntArraySorted {
    private static final int DEFAULT_CAPACITY = 10;
    private int[] array;
    private int size;

    public IntArraySorted() {
        this(DEFAULT_CAPACITY);
        size = 0;
    }

    public IntArraySorted(int size) {
        if (size < DEFAULT_CAPACITY) {
            size = DEFAULT_CAPACITY;
        }

        array = new int[size];
        this.size = size;
    }

    private void increaseSize(int addLength) {
        if (addLength < array.length) {
            addLength = array.length;
        }
        int[] newArray = new int[array.length + addLength];

        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }

    private void removeByIndex(int index) {
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size--;
    }

    private int findIndexForInsertion(int value) {
        if (size == 0) {
            return 0;
        }

        if (array[size - 1] <= value) {
            return size;
        }

        if (array[0] >= value) {
            return 0;
        }

        int minI = 0;
        int maxI = size - 1;
        int i = size / 2 - 1;

        while (true) {
            if (array[i] == value) {
                return i;
            }
            if (array[i] < value) {
                if (array[i + 1] >= value) {
                    return i + 1;
                } else {
                    minI = i;
                    i = minI + (maxI - minI) / 2;
                }
            } else {
                if (array[i - 1] <= value) {
                    return i;
                } else {
                    maxI = i;
                    i = minI + (maxI - minI) / 2;
                }
            }
        }
    }

    private int findIndexOfValue(int value) {
        if (size == 0) {
            return -1;
        }

        if (array[size - 1] < value || array[0] > value) {
            return -1;
        }

        int minI = 0;
        int maxI = size - 1;
        int i = size / 2 - 1;

        while (true) {
            if (array[i] == value) {
                return i;
            }
            if (array[i] < value) {
                minI = i;

                if (maxI - minI == 1) {
                    i = maxI;
                    minI = i;
                } else {
                    i = minI + (maxI - minI) / 2;
                }
            } else {
                maxI = i;

                if (maxI - minI == 1) {
                    i = minI;
                    maxI = i;
                } else {
                    i = maxI - (maxI - minI) / 2;
                }
            }
            if (minI == maxI && array[minI] != value) {
                return -1;
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int[] toArray() {
        int[] newArray = new int[size];

        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    public void remove(int value) {
        int i = 0;
        while (i < size) {
            if (array[i] == value) {
                removeByIndex(i);
            } else {
                i++;
            }
        }
    }

    public void retainAll(IntArraySorted intArraySorted) {
        if (intArraySorted == null) {
            return;
        }

        if (intArraySorted.size() == 0) {
            return;
        }

        int i = 0;
        while (i < size) {
            if (!intArraySorted.contains(this.array[i])) {
                removeByIndex(i);
            } else {
                i++;
            }
        }
    }

    public boolean removeAll(IntArraySorted intArraySorted) {
        if (intArraySorted == null) {
            return false;
        }

        if (intArraySorted.size() == 0) {
            return false;
        }

        boolean isRemoved = false;

        int i = 0;
        while (i < size) {
            if (intArraySorted.contains(this.array[i])) {
                removeByIndex(i);
                isRemoved = true;
            }

            i++;
        }

        return isRemoved;
    }

    public boolean containsAll(IntArraySorted intArraySorted) {
        if (intArraySorted == null) {
            return false;
        }

        if (intArraySorted.size() == 0) {
            return false;
        }

        for (int i = 0; i < intArraySorted.size(); i++) {
            if (!contains(intArraySorted.get(i))) {
                return false;
            }
        }

        return true;
    }

    public void add(int value) {
        if (array.length == size) {
            increaseSize(size);
        }

        int index = findIndexForInsertion(value);

        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = value;
        size++;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index is out of bounds");
        }

        return array[index];
    }

    public boolean contains(int value) {
        return this.indexOf(value) >= 0;
    }

    public int indexOf(int value) {
        return findIndexOfValue(value);
    }

    public void addAll(IntArraySorted intArraySorted) {
        if (intArraySorted == null) {
            return;
        }

        int addLength = intArraySorted.size();
        if (addLength == 0) {
            return;
        }

        if (size + addLength > array.length) {
            increaseSize(addLength);
        }

        for (int i = 0; i < addLength; i++) {
            add(intArraySorted.get(i));
        }
    }

    public boolean equals(IntArraySorted intArraySorted) {
        if (intArraySorted == null) {
            return false;
        }
        if (intArraySorted == this) {
            return true;
        }
        if (intArraySorted.size() != size) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (this.array[i] != intArraySorted.get(i)) {
                return false;
            }
        }

        return true;
    }

    public void clear() {
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        String delimiter = "";

        for (int i = 0; i < size; i++) {
            result.append(delimiter).append(array[i]);
            delimiter = "; ";
        }

        result.append("]");
        return result.toString();
    }
}
