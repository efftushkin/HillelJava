package LinkedList;

import java.util.Collection;
import java.util.Iterator;

public class LinkedList implements Collection {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public void push(Object object) {
        head = new Node(object, head);
        size++;

        if (tail == null) {
            tail = head;
        }
    }

    private void removeFromList(Node node) {
        if (head == node) {
            head = node.getNext();
            size--;
            return;
        }

        Node previousNode = head;

        while (previousNode.getNext() != node) {
            previousNode = previousNode.getNext();
        }

        previousNode.setNext(node.getNext());

        if (tail == node) {
            tail = previousNode;
        }

        size--;
    }

    public Object pop() {
        if (head == null) {
            return null;
        }

        size--;

        Object object = head.getData();
        head = head.getNext();

        if (head == null) {
            tail = null;
        }

        return object;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        String delimiter = "";

        Node currentNode = head;

        while (currentNode != null) {
            result.append(delimiter).append(currentNode);
            delimiter = "; ";

            currentNode = currentNode.getNext();
        }

        result.append("]");
        return result.toString();
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
            if (currentNode.getData().equals(o)) {
                return true;
            }

            currentNode = currentNode.getNext();
        }

        return false;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
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
            arrayObject[i] = currentNode.getData();

            i++;
            currentNode = currentNode.getNext();
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
        tail = new Node(o);
        oldTail.setNext(tail);

        size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        boolean isRemoved = false;

        Node currentNode = head;

        while (currentNode != null) {
            if (currentNode.getData().equals(o)) {
                Node removeNode = currentNode;

                currentNode = currentNode.getNext();

                removeFromList(removeNode);

                isRemoved = true;
            } else {
                currentNode = currentNode.getNext();
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
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean retainAll(Collection c) {
        if (c == null) {
            return false;
        }

        boolean isRemoved = false;

        Node currentNode = head;

        while (currentNode != null) {
            if (!c.contains(currentNode.getData())) {
                Node removeNode = currentNode;

                currentNode = currentNode.getNext();

                removeFromList(removeNode);

                isRemoved = true;
            } else {
                currentNode = currentNode.getNext();
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
            if (c.contains(currentNode.getData())) {
                Node removeNode = currentNode;

                currentNode = currentNode.getNext();

                removeFromList(removeNode);

                isRemoved = true;
            } else {
                currentNode = currentNode.getNext();
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
        if (a.length <= size) {
            return toArray();
        }

        int i = 0;
        Node currentNode = head;

        while (currentNode != null) {
            a[i] = currentNode.getData();

            i++;
            currentNode = currentNode.getNext();
        }

        for (; i < a.length; i++) {
            a[i] = null;
        }

        return a;
    }

    private class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this(data, null);
        }

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Object getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public void setNext(Node next) {
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
                return "Empty";
            }

            return data.toString();
        }
    }

    private class LinkedListIterator implements Iterator {
        private Node node = head;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public Object next() {
            node = node.getNext();
            return node.getData();
        }
    }
}
