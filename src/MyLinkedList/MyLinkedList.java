package MyLinkedList;

import java.util.*;

//This list does not permit null elements
public class MyLinkedList<E> implements List<E> {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public void push(E object) {
        if (object == null) {
            throw new NullPointerException();
        }

        Node oldHead = head;
        head = new Node(object, null, head);

        if (oldHead != null) {
            oldHead.previous = head;
        }

        size++;

        if (tail == null) {
            tail = head;
        }
    }

    private void insertBefore(Node node, E data) {
        Node newNode = new Node(data, node.previous, node);
        node.previous = newNode;

        if (newNode.previous != null) {
            newNode.previous.next = newNode;
        }

        size++;

        if (newNode.previous == null) {
            head = newNode;
        }
    }

    private void removeFromList(Node node) {
        if (node.previous != null) {
            node.previous.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.previous = node.previous;
        } else {
            tail = node.previous;
        }

        size--;
    }

    private Node getNode(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node node = head;

        for (int i = 1; i <= index; i++) {
            node = node.next;
        }

        return node;
    }

    public E pop() {
        if (head == null) {
            return null;
        }

        size--;

        E data = head.data;
        head = head.next;

        if (head == null) {
            tail = null;
        } else {
            head.previous = null;
        }

        return data;
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
    public boolean contains(Object o) {
        Node currentNode = head;

        while (currentNode != null) {
            if (currentNode.data.equals(o)) {
                return true;
            }

            currentNode = currentNode.next;
        }

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public E next() {
                E currentData = node.data;
                node = node.next;
                return currentData;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] arrayObject = new Object[size];

        if (size == 0) {
            return arrayObject;
        }

        int i = 0;
        Node currentNode = head;

        while (currentNode != null) {
            arrayObject[i] = currentNode.data;

            i++;
            currentNode = currentNode.next;
        }

        return arrayObject;
    }

    @Override
    public boolean add(E o) {
        if (o == null) {
            throw new NullPointerException();
        }

        if (head == null) {
            head = new Node(o);
            tail = head;
            size = 1;
            return true;
        }

        Node oldTail = tail;
        tail = new Node(o, tail, null);
        oldTail.next = tail;

        size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }

        Node currentNode = head;

        while (currentNode != null) {
            if (currentNode.data.equals(o)) {
                Node removeNode = currentNode;

                currentNode = currentNode.next;

                removeFromList(removeNode);

                return true;
            } else {
                currentNode = currentNode.next;
            }
        }

        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c == null) {
            throw new NullPointerException();
        }
        if (c.size() == 0) {
            return false;
        }

        for (E element : c) {
            add(element);
        }

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (c == null) {
            throw new NullPointerException();
        }
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (c.size() == 0) {
            return false;
        }


        Node node = getNode(index);

        for (E element : c) {
            insertBefore(node, element);
        }

        return true;
    }

    @Override
    public void sort(Comparator<? super E> c) {
        if (c == null) {
            throw new NullPointerException();
        }

        //InsertSort
        E tmp;
        int j;

        for (int i = 0; i < size; i++) {
            tmp = get(i);

            for (j = i - 1; j >= 0 && c.compare(get(j), tmp) > 0; j--) {
                set(j + 1, get(j));
            }

            set(j + 1, tmp);
        }
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        Node node = getNode(index);

        return node.data;
    }

    @Override
    public void add(int index, E element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (element == null) {
            throw new NullPointerException();
        }

        Node node = getNode(index);

        insertBefore(node, element);
    }

    @Override
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node node = getNode(index);

        removeFromList(node);

        return node.data;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }

        int index = 0;

        Node currentNode = head;

        while (currentNode != null) {
            if (currentNode.data.equals(o)) {
                return index;
            }

            currentNode = currentNode.next;
            index++;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }

        int index = size - 1;

        Node currentNode = tail;

        while (currentNode != null) {
            if (currentNode.data.equals(o)) {
                return index;
            }

            currentNode = currentNode.previous;
            index--;
        }

        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new LinkedListIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        return new LinkedListIterator(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException();
        }
        if (fromIndex < 0 || toIndex >= size) {
            throw new IndexOutOfBoundsException();
        }

        List<E> list = new MyLinkedList<E>();

        for (int i = fromIndex; i <= toIndex; i++) {
            list.add(get(i));
        }
        return list;
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (element == null) {
            throw new NullPointerException();
        }

        Node node = getNode(index);

        E oldData = node.data;
        node.data = element;
        return oldData;
    }

    @Override
    public boolean retainAll(Collection c) {
        if (c == null) {
            throw new NullPointerException();
        }

        boolean isRemoved = false;

        Node currentNode = head;

        while (currentNode != null) {
            if (!c.contains(currentNode.data)) {
                Node removeNode = currentNode;

                currentNode = currentNode.next;

                removeFromList(removeNode);

                isRemoved = true;
            } else {
                currentNode = currentNode.next;
            }
        }

        return isRemoved;
    }

    @Override
    public boolean removeAll(Collection c) {
        if (c == null) {
            throw new NullPointerException();
        }

        boolean isRemoved = false;

        Node currentNode = head;

        while (currentNode != null) {
            if (c.contains(currentNode.data)) {
                Node removeNode = currentNode;

                currentNode = currentNode.next;

                removeFromList(removeNode);

                isRemoved = true;
            } else {
                currentNode = currentNode.next;
            }
        }

        return isRemoved;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException();
        }

        if (c.size() == 0) {
            return false;
        }

        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a == null) {
            throw new NullPointerException();
        }

        Object[] arrayObject = new Object[size];

        int i = 0;
        Node currentNode = head;

        while (currentNode != null) {
            arrayObject[i] = currentNode.data;

            i++;
            currentNode = currentNode.next;
        }

        if (a.length < size) {
            return (T[]) Arrays.copyOf(arrayObject, size, a.getClass());
        }

        System.arraycopy(arrayObject, 0, a, 0, size);

        for (; i < a.length; i++) {
            a[i] = null;
        }

        return a;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        String delimiter = "";

        Node currentNode = head;

        while (currentNode != null) {
            result.append(delimiter).append(currentNode);
            delimiter = "; ";

            currentNode = currentNode.next;
        }

        result.append("]");
        return result.toString();
    }

    private class Node {
        private E data;
        private Node previous;
        private Node next;

        public Node(E data) {
            this(data, null, null);
        }

        public Node(E data, Node previous, Node next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (data != null) {
                return data.equals(node.data);
            } else {
                return node.data == null;
            }
        }

        @Override
        public int hashCode() {
            return data != null ? data.hashCode() : 0;
        }

        @Override
        public String toString() {
            if (data == null) {
                return "<Empty>";
            }

            return data.toString();
        }
    }

    private class LinkedListIterator implements ListIterator<E> {
        private Node returned;
        private Node node;
        int index;

        public LinkedListIterator() {
            node = head;
            index = 0;
        }

        public LinkedListIterator(int index) {
            node = getNode(index);
            this.index = index;
        }


        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public E next() {
            returned = node;
            node = node.next;
            index++;
            return returned.data;
        }

        @Override
        public boolean hasPrevious() {
            return node != null;
        }

        @Override
        public E previous() {
            returned = node;
            node = node.previous;
            index--;
            return returned.data;
        }

        @Override
        public int nextIndex() {
            return index;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public void remove() {
            Node currentNode = node;
            node = node.next;
            removeFromList(currentNode);
        }

        @Override
        public void set(E o) {
            returned.data = o;
        }

        @Override
        public void add(E o) {
            insertBefore(node, o);
            index++;
        }
    }
}
