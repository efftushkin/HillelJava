package LinkedListImplementsList;

import java.util.*;

public class MyLinkedList implements List {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public void push(Object object) {
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

    private void insertBefore(Node node, Object data) {
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
            return null;
        }

        Node node = head;

        for (int i = 1; i <= index; i++) {
            node = node.next;
        }

        return node;
    }

    public Object pop() {
        if (head == null) {
            return null;
        }

        size--;

        Object object = head.data;
        head = head.next;

        if (head == null) {
            tail = null;
        } else {
            head.previous = null;
        }

        return object;
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
    public Iterator iterator() {
        return new Iterator() {
            private Node node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public Object next() {
                Object currentData = node.data;
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
    public boolean add(Object o) {
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
        boolean isRemoved = false;

        Node currentNode = head;

        while (currentNode != null) {
            if (currentNode.data.equals(o)) {
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
    public boolean addAll(Collection c) {
        if (c == null) {
            return false;
        }
        if (c.size() == 0) {
            return false;
        }

        Object[] newArray = c.toArray();

        for (Object element : newArray) {
            add(element);
        }

        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        if (c == null) {
            return false;
        }
        if (c.size() == 0) {
            return false;
        }

        if (index >= size() || index < 0) {
            return addAll(c);
        }

        Node node = getNode(index);

        Object[] newArray = c.toArray();

        for (Object element : newArray) {
            insertBefore(node, element);
        }

        return true;
    }

    @Override
    public void sort(Comparator c) {
//      insertSort
        Object tmp;
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
    public Object get(int index) {
        Node node = getNode(index);

        if (node == null) {
            return null;
        }

        return node.data;
    }

    @Override
    public void add(int index, Object element) {
        if (index >= size) {
            add(element);
            return;
        }
        if (index < 0) {
            push(element);
            return;
        }

        Node node = getNode(index);

        insertBefore(node, element);
    }

    @Override
    public Object remove(int index) {
        Node node = getNode(index);

        if (node == null) {
            return null;
        }

        removeFromList(node);

        return node.data;
    }

    @Override
    public int indexOf(Object o) {
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
    public ListIterator listIterator() {
        return new LinkedListIterator();
    }

    @Override
    public ListIterator listIterator(int index) {
        return new LinkedListIterator(index);
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            return null;
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (toIndex >= size) {
            toIndex = size - 1;
        }

        List list = new MyLinkedList();

        for (int i = fromIndex; i <= toIndex; i++) {
            list.add(get(i));
        }
        return list;
    }

    @Override
    public Object set(int index, Object element) {
        Node node = getNode(index);

        if (node == null) {
            return null;
        }

        Object oldData = node.data;
        node.data = element;
        return oldData;
    }

    @Override
    public boolean retainAll(Collection c) {
        if (c == null) {
            return false;
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
            return false;
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
    public boolean containsAll(Collection c) {
        if (c == null) {
            return false;
        }
        if (c.size() == 0) {
            return false;
        }

        Object[] newArray = c.toArray();

        for (Object element : newArray) {
            if (!contains(element)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        if (a.length < size) {
            return toArray();
        }

        int i = 0;
        Node currentNode = head;

        while (currentNode != null) {
            a[i] = currentNode.data;

            i++;
            currentNode = currentNode.next;
        }

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
        private Object data;
        private Node previous;
        private Node next;

        public Node(Object data) {
            this(data, null, null);
        }

        public Node(Object data, Node previous, Node next) {
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

    private class LinkedListIterator implements ListIterator {
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
        public Object next() {
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
        public Object previous() {
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
            return index;
        }

        @Override
        public void remove() {
            Node currentNode = node;
            node = node.next;
            removeFromList(currentNode);
        }

        @Override
        public void set(Object o) {
            returned.data = o;
        }

        @Override
        public void add(Object o) {
            insertBefore(node, o);
            index++;
        }
    }
}
