package MyLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedListTest {
    private MyLinkedList<Integer> myLinkedList;
    private ArrayList<Integer> arrayList;

    @Before
    public void setup() {
        myLinkedList = new MyLinkedList<Integer>();
        arrayList = new ArrayList<>();
    }

    @Test
    public void testStatus() {
        Assert.assertEquals(0, myLinkedList.size());
        Assert.assertTrue(myLinkedList.isEmpty());
        Assert.assertFalse(myLinkedList.contains(8));
        Assert.assertTrue(myLinkedList.add(1));
        Assert.assertEquals(1, myLinkedList.size());
        Assert.assertTrue(myLinkedList.add(1));
        Assert.assertEquals(2, myLinkedList.size());
        Assert.assertFalse(myLinkedList.isEmpty());
        myLinkedList.clear();
        Assert.assertEquals(0, myLinkedList.size());
        Assert.assertTrue(myLinkedList.isEmpty());
    }

    @Test
    public void testAdd() {
        for (int i = 0; i < 512; i++) {
            myLinkedList.add(i);
        }

        for (int i = 0; i < 512; i++) {
            Assert.assertEquals(Integer.valueOf(i), myLinkedList.get(i));
        }
    }

    @Test
    public void testAddIndex() {
        myLinkedList.add(2);
        myLinkedList.add(4);
        myLinkedList.add(6);
        myLinkedList.add(8);
        Assert.assertEquals(Integer.valueOf(4), myLinkedList.get(1));
        myLinkedList.add(1, 3);
        Assert.assertEquals(Integer.valueOf(3), myLinkedList.get(1));
        myLinkedList.add(myLinkedList.size() - 1, 9);
        Assert.assertEquals(Integer.valueOf(9), myLinkedList.get(myLinkedList.size() - 2));
        myLinkedList.add(0, 1);
        Assert.assertEquals(Integer.valueOf(1), myLinkedList.get(0));
    }

    @Test
    public void testAddAllAndGet() {
        Assert.assertFalse(myLinkedList.addAll(arrayList));

        for (int i = 0; i < 512; i++) {
            arrayList.add(i);
        }

        Assert.assertTrue(myLinkedList.addAll(arrayList));

        for (int i = 0; i < 512; i++) {
            Assert.assertEquals(Integer.valueOf(i), myLinkedList.get(i));
        }
    }

    @Test
    public void testAddAllIndex() {
        for (int i = 0; i < 32; i++) {
            myLinkedList.add(i);
        }

        Assert.assertFalse(myLinkedList.addAll(0, arrayList));

        for (int i = 0; i < 32; i++) {
            arrayList.add(i * 10);
        }

        myLinkedList.addAll(16, arrayList);

        for (int i = 0; i < 16; i++) {
            Assert.assertEquals(Integer.valueOf(i), myLinkedList.get(i));
        }
        for (int i = 16; i < 48; i++) {
            Assert.assertEquals(Integer.valueOf((i - 16) * 10), myLinkedList.get(i));
        }
        for (int i = 48; i < 64; i++) {
            Assert.assertEquals(Integer.valueOf(i - 32), myLinkedList.get(i));
            Assert.assertEquals(Integer.valueOf(i - 32), myLinkedList.get(i));
        }
    }

    @Test
    public void testContains() {
        for (int i = 0; i < 512; i++) {
            myLinkedList.add(i);
        }

        for (int i = 0; i < 512; i++) {
            Assert.assertTrue(myLinkedList.contains(i));
        }
    }

    @Test
    public void testContainsAll() {
        for (int i = 0; i < 32; i++) {
            myLinkedList.add(i);
        }

        Assert.assertFalse(myLinkedList.containsAll(arrayList));

        for (int i = 5; i <= 8; i++) {
            arrayList.add(i);
        }

        Assert.assertTrue(myLinkedList.containsAll(arrayList));

        arrayList.add(32);
        Assert.assertFalse(myLinkedList.containsAll(arrayList));
    }

    @Test
    public void testIndexOf() {
        for (int i = 0; i < 32; i++) {
            myLinkedList.add(i);
        }

        for (int i = 0; i < 32; i++) {
            Assert.assertEquals(i, myLinkedList.indexOf(i));
        }

        Assert.assertEquals(-1, myLinkedList.indexOf(32));
    }

    @Test
    public void testIterator() {
        for (int i = 0; i < 32; i++) {
            myLinkedList.add(i);
        }

        int i = 0;
        for (Integer e : myLinkedList) {
            Assert.assertEquals(Integer.valueOf(i), e);
            i++;
        }
    }

    @Test
    public void testLastIndexOf() {
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(4);
        myLinkedList.add(2);
        myLinkedList.add(3);
        Assert.assertEquals(3, myLinkedList.lastIndexOf(2));
        Assert.assertEquals(-1, myLinkedList.lastIndexOf(0));
    }

    @Test
    public void testListIterator() {
        for (int i = 0; i < 4; i++) {
            myLinkedList.add(i);
        }

        int i = 0;

        ListIterator<Integer> listIterator = myLinkedList.listIterator();
        while (listIterator.hasNext()) {
            Assert.assertEquals(Integer.valueOf(i), listIterator.next());
            i++;
        }

        listIterator = myLinkedList.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
            listIterator.set(16);
        }

        for (i = 0; i < 4; i++) {
            Assert.assertEquals(Integer.valueOf(16), myLinkedList.get(i));
        }

        listIterator = myLinkedList.listIterator();
        while (listIterator.hasNext()) {
            listIterator.remove();
        }

        Assert.assertTrue(myLinkedList.isEmpty());
    }

    @Test
    public void testListIteratorIndex() {
        for (int i = 0; i < 4; i++) {
            myLinkedList.add(i);
        }

        ListIterator<Integer> listIterator = myLinkedList.listIterator(3);

        int i = 3;

        while (listIterator.hasPrevious()) {
            Assert.assertEquals(Integer.valueOf(i), listIterator.previous());
            i--;
        }

        listIterator = myLinkedList.listIterator(2);

        Assert.assertEquals(1, listIterator.previousIndex());
        Assert.assertEquals(2, listIterator.nextIndex());

        listIterator.add(7);

        Assert.assertEquals(Integer.valueOf(2), listIterator.previous());
        Assert.assertEquals(Integer.valueOf(7), listIterator.previous());
    }

    @Test
    public void testPop() {
        Assert.assertNull(myLinkedList.pop());

        for (int i = 0; i < 32; i++) {
            myLinkedList.add(i);
        }

        for (int i = 0; i < 32; i++) {
            Assert.assertEquals(Integer.valueOf(i), myLinkedList.pop());
        }

        Assert.assertEquals(0, myLinkedList.size());
        Assert.assertTrue(myLinkedList.isEmpty());
    }

    @Test
    public void testPush() {
        for (int i = 0; i < 32; i++) {
            myLinkedList.push(i);
        }

        for (int i = 0; i < 32; i++) {
            Assert.assertEquals(Integer.valueOf(31 - i), myLinkedList.get(i));
        }
    }

    @Test
    public void testRemove() {
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(4);
        myLinkedList.add(2);
        myLinkedList.add(3);
        Assert.assertEquals(Integer.valueOf(2), myLinkedList.remove(1));
        Assert.assertEquals(Integer.valueOf(2), myLinkedList.remove(2));
        Assert.assertEquals(Integer.valueOf(1), myLinkedList.remove(0));
    }

    @Test
    public void testRemoveObject() {
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(4);
        myLinkedList.add(2);
        myLinkedList.add(3);
        Assert.assertTrue(myLinkedList.remove(Integer.valueOf(1)));
        Assert.assertTrue(myLinkedList.remove(Integer.valueOf(2)));
        Assert.assertTrue(myLinkedList.remove(Integer.valueOf(2)));
        Assert.assertFalse(myLinkedList.remove(Integer.valueOf(2)));
    }

    @Test
    public void testRemoveAll() {
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(4);
        myLinkedList.add(2);
        myLinkedList.add(3);

        arrayList.add(6);

        Assert.assertFalse(myLinkedList.removeAll(arrayList));

        arrayList.add(2);
        arrayList.add(1);

        Assert.assertTrue(myLinkedList.removeAll(arrayList));

        Assert.assertFalse(myLinkedList.contains(2));
    }

    @Test
    public void testRetainAll() {
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(4);
        myLinkedList.add(2);
        myLinkedList.add(3);

        arrayList.add(6);

        Assert.assertTrue(myLinkedList.retainAll(arrayList));

        Assert.assertEquals(0, myLinkedList.size());

        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(4);
        myLinkedList.add(2);
        myLinkedList.add(3);

        arrayList.add(2);
        arrayList.add(3);

        Assert.assertTrue(myLinkedList.retainAll(arrayList));

        Assert.assertTrue(myLinkedList.contains(2));
        Assert.assertTrue(myLinkedList.contains(3));
        Assert.assertFalse(myLinkedList.contains(1));
        Assert.assertFalse(myLinkedList.contains(4));

        myLinkedList.clear();

        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(4);
        myLinkedList.add(2);
        myLinkedList.add(3);

        arrayList.add(1);
        arrayList.add(4);

        Assert.assertFalse(myLinkedList.retainAll(arrayList));
    }

    @Test
    public void testSet() {
        for (int i = 0; i < 32; i++) {
            myLinkedList.add(0);
        }

        for (int i = 0; i < 32; i++) {
            myLinkedList.set(i, i * 10);
        }

        for (int i = 0; i < 32; i++) {
            Assert.assertEquals(Integer.valueOf(i * 10), myLinkedList.get(i));
        }
    }

    @Test
    public void testSort() {
        for (int i = 31; i >= 0; i--) {
            myLinkedList.add(i);
        }

        myLinkedList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < 32; i++) {
            Assert.assertEquals(Integer.valueOf(i), myLinkedList.get(i));
        }
    }

    @Test
    public void testSublist() {
        for (int i = 0; i <= 32; i++) {
            myLinkedList.add(i);
        }

        List<Integer> subList = myLinkedList.subList(4, 7);

        for (int i = 0; i < 4; i++) {
            Assert.assertEquals(Integer.valueOf(i + 4), subList.get(i));
        }
    }

    @Test
    public void testToArray() {
        Object[] array = myLinkedList.toArray();
        Assert.assertEquals(0, array.length);

        for (int i = 0; i < 32; i++) {
            myLinkedList.add(i);
        }

        array = myLinkedList.toArray();

        for (int i = 0; i < 32; i++) {
            Assert.assertEquals(i, array[i]);
        }
    }

    @Test
    public void testToTheArray() {
        for (int i = 0; i < 32; i++) {
            myLinkedList.add(i);
        }

        Integer[] a = new Integer[16];

        Integer[] array = myLinkedList.toArray(a);

        for (int i = 0; i < 32; i++) {
            Assert.assertEquals(Integer.valueOf(i), array[i]);
        }

        a = new Integer[64];
        array = myLinkedList.toArray(a);

        for (int i = 0; i < 32; i++) {
            Assert.assertEquals(Integer.valueOf(i), array[i]);
        }
        for (int i = 32; i < 64; i++) {
            Assert.assertNull(array[i]);
        }
    }
}
