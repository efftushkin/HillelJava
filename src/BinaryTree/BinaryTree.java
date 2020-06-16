package BinaryTree;

import LinkedListImplementsList.MyLinkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class BinaryTree implements Set {
    Node root = null;
    int size = 0;

    private Node getMostPrevious(Node root) {
        if (root == null || root.previous == null) {
            return root;
        } else {
            return getMostPrevious(root.previous);
        }
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
        for (Object data : this) {
            if (data.equals(o)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private Node node = getMostPrevious(root);

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public Object next() {
                Object currentData = node.data;

                if (node.next == null) {
                    node = node.root;
                } else {
                    node = getMostPrevious(node.next);
                }

                return currentData;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];

        int i = 0;

        for (Object data : this) {
            array[i] = data;
            i++;
        }

        return array;
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        if (a.length < size) {
            return toArray();
        }

        int i = 0;

        for (Object data : this) {
            a[i] = data;
            i++;
        }

        for (; i < a.length; i++) {
            a[i] = null;
        }

        return a;
    }

    private class Node {
        Object data;
        Node previous;
        Node next;
        Node root;

        public Node(Object data, Node root, Node previous, Node next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
            this.root = root;
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
    }
}
