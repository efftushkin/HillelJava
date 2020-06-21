package BinaryTree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {
    private BinaryTree binaryTree;

    @Before
    public void setUp() {
        binaryTree = new BinaryTree();
    }

    @Test
    public void testStatus_empty() {
        Assert.assertTrue(binaryTree.isEmpty());
        Assert.assertEquals(0, binaryTree.size());
        Assert.assertFalse(binaryTree.contains(8));
    }

    @Test
    public void testStatus_notEmpty() {
        binaryTree.add(3);
        Assert.assertFalse(binaryTree.isEmpty());
        Assert.assertEquals(1, binaryTree.size());
        Assert.assertFalse(binaryTree.contains(8));

        binaryTree.add(8);
        Assert.assertFalse(binaryTree.isEmpty());
        Assert.assertEquals(2, binaryTree.size());
        Assert.assertTrue(binaryTree.contains(8));

        binaryTree.add("qwerty");
        Assert.assertFalse(binaryTree.isEmpty());
        Assert.assertEquals(3, binaryTree.size());
    }

    @Test
    public void sortWhileAdding() {
        binaryTree.add(-2);
        binaryTree.add(-8);
        binaryTree.add(0.2);
        binaryTree.add(0.4);
        binaryTree.add("Zeta");
        binaryTree.add(0.3);
        binaryTree.add(0.1);
        binaryTree.add("Alpha");
        binaryTree.add("zeta");
        binaryTree.add("beta");
        Assert.assertArrayEquals(new Object[] {-8, -2, 0.1, 0.2, 0.3, 0.4, "Alpha", "Zeta", "beta", "zeta"}, binaryTree.toArray());
    }

    @Test
    public void noRepeats() {
        Assert.assertTrue(binaryTree.add(1));
        Assert.assertFalse(binaryTree.add(1));
        Assert.assertTrue(binaryTree.add("one"));
        Assert.assertFalse(binaryTree.add("one"));
    }

    @Test
    public void addNull() {
        Assert.assertFalse(binaryTree.add(null));
    }

    @Test
    public void addAll() {
        binaryTree.add(3);
        binaryTree.add(2);
        binaryTree.add(1);
        binaryTree.add(4);
        binaryTree.add(5);

        BinaryTree newBinaryTree = new BinaryTree();
        Assert.assertFalse(binaryTree.addAll(newBinaryTree));

        newBinaryTree.add(3);
        newBinaryTree.add(2);
        Assert.assertFalse(binaryTree.addAll(newBinaryTree));

        newBinaryTree.add(0);
        newBinaryTree.add(1.5);
        newBinaryTree.add(6);
        Assert.assertTrue(binaryTree.addAll(newBinaryTree));
        Assert.assertEquals(8, binaryTree.size());
    }

    @Test
    public void remove() {
        binaryTree.add(3);
        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(5);
        binaryTree.add(4);
        binaryTree.add(6);

        Assert.assertFalse(binaryTree.remove(null));
        Assert.assertTrue(binaryTree.remove(3));
        Assert.assertEquals(5, binaryTree.size());
        Assert.assertFalse(binaryTree.remove(7));
        Assert.assertEquals(5, binaryTree.size());
        Assert.assertTrue(binaryTree.remove(5));
        Assert.assertEquals(4, binaryTree.size());
        Assert.assertTrue(binaryTree.remove(1));
        Assert.assertEquals(3, binaryTree.size());
        Assert.assertTrue(binaryTree.remove(4));
        Assert.assertEquals(2, binaryTree.size());
        Assert.assertTrue(binaryTree.remove(2));
        Assert.assertEquals(1, binaryTree.size());
        Assert.assertFalse(binaryTree.remove(2));
        Assert.assertEquals(1, binaryTree.size());
        Assert.assertTrue(binaryTree.remove(6));
        Assert.assertEquals(0, binaryTree.size());
    }

    @Test
    public void retainAll() {
        BinaryTree newBinaryTree = new BinaryTree();
        Assert.assertFalse(binaryTree.retainAll(newBinaryTree));

        binaryTree.add(3);
        binaryTree.add(2);
        binaryTree.add(1);
        binaryTree.add(4);
        binaryTree.add(5);
        Assert.assertFalse(binaryTree.retainAll(newBinaryTree));

        newBinaryTree.add(3);
        newBinaryTree.add(2);

        Assert.assertTrue(binaryTree.retainAll(newBinaryTree));
        Assert.assertArrayEquals(new Object[] {2, 3}, binaryTree.toArray());
    }

    @Test
    public void containsAll() {
        binaryTree.add(3);
        binaryTree.add(2);
        binaryTree.add(1);
        binaryTree.add(4);
        binaryTree.add(5);

        BinaryTree newBinaryTree = new BinaryTree();
        Assert.assertFalse(binaryTree.containsAll(newBinaryTree));

        newBinaryTree.add(3);
        newBinaryTree.add(2);
        Assert.assertTrue(binaryTree.containsAll(newBinaryTree));

        newBinaryTree.add(0);
        Assert.assertFalse(binaryTree.containsAll(newBinaryTree));
    }

    @Test
    public void forEach() {
        binaryTree.add(3);
        binaryTree.add(2);
        binaryTree.add(1);
        binaryTree.add(4);
        binaryTree.add(5);

        int i = 1;

        for (Object data: binaryTree) {
            Assert.assertEquals(Integer.valueOf(i), data);
            i++;
        }
    }

    @Test
    public void toArrayWithParam() {
        binaryTree.add(3);
        binaryTree.add(2);
        binaryTree.add(1);
        binaryTree.add(4);
        binaryTree.add(5);

        Object[] array = new Object[] {1, 2, 2, 2, 2, 2};
        Assert.assertArrayEquals(new Object[] {1, 2, 3, 4, 5, null}, binaryTree.toArray(array));
        array = new Object[] {1, 2, 2, 2, 2};
        Assert.assertArrayEquals(new Object[] {1, 2, 3, 4, 5}, binaryTree.toArray(array));
        array = new Object[] {1, 2, 2};
        Assert.assertArrayEquals(new Object[] {1, 2, 3, 4, 5}, binaryTree.toArray(array));
    }

    @Test
    public void removeAll() {
        binaryTree.add(3);
        binaryTree.add(2);
        binaryTree.add(1);
        binaryTree.add(4);
        binaryTree.add(5);

        BinaryTree newBinaryTree = new BinaryTree();
        Assert.assertFalse(binaryTree.removeAll(newBinaryTree));

        newBinaryTree.add(3);
        newBinaryTree.add(2);
        Assert.assertTrue(binaryTree.removeAll(newBinaryTree));
        Assert.assertFalse(binaryTree.removeAll(newBinaryTree));

        Assert.assertArrayEquals(new Object[] {1, 4, 5}, binaryTree.toArray());
    }

    @Test
    public void clear() {
        binaryTree.add(3);
        binaryTree.add(2);
        binaryTree.add(1);
        binaryTree.add(4);
        binaryTree.add(5);

        binaryTree.clear();
        Assert.assertTrue(binaryTree.isEmpty());
    }
}
