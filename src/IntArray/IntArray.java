package IntArray;

public class IntArray {
    private int[] array;

    public IntArray() {
        this(0);
    }

    public IntArray(int size) {
        if (size < 0) {
            size = 0;
        }

        array = new int[size];
    }

    private void increaseSize(int addNum) {
        int[] newArray = new int[array.length + addNum];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }

    private void swap(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public int getLength() {
        return array.length;
    }

    public void add(int value) {
        increaseSize(1);

        array[array.length - 1] = value;
    }

    public int get(int index) {
        if (index < 0 || index >= array.length) {
            System.out.println("Index is out of bounds");
        }

        return array[index];
    }

    public boolean contains(int value) {
        return this.indexOf(value) >= 0;
    }

    public int indexOf(int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }

        return -1;
    }

    public void addAll(IntArray add) {
        if (add == null) {
            return;
        }

        int addLength = add.getLength();
        if (addLength == 0) {
            return;
        }

        int currLength = array.length;

        increaseSize(addLength);

        for (int i = 0; i < addLength; i++) {
            array[currLength + i] = add.get(i);
        }
    }

    public boolean equals(IntArray intArray) {
        if (intArray == null) {
            return false;
        }
        if (intArray == this) {
            return true;
        }
        if (intArray.getLength() != this.array.length) {
            return false;
        }

        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] != intArray.get(i)) {
                return false;
            }
        }

        return true;
    }

    public void reverse() {
        if (array.length == 0) {
            return;
        }

        for (int i = 0; i < array.length / 2; i++) {
            swap(i, array.length - i - 1);
        }
    }

    public void sort() {
/*      insertSort
        int tmp;
        int j;

        for (int i = 0; i < arra.length; i++) {
            tmp = arra[i];

            for (j = i - 1; j >= 0 && arra[j] > tmp; j--) {
                arra[j + 1] = arra[j];
            }

            arra[j + 1] = tmp;
        }
*/
        //bubble
        if (array.length <= 1) {
            return;
        }

        int tmp;

        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    swap(j, j - 1);
                }
            }
        }
    }

    public void clear() {
        array = new int[0];
    }

    public void print() {
        System.out.print("[");

        String delimiter = "";

        for (int element : array) {
            System.out.print(delimiter + element);
            delimiter = "; ";
        }
        System.out.println("]");
    }
}
