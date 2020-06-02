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
        return null;
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
}
