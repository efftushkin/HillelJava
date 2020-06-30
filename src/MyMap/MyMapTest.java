package MyMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class MyMapTest {
    private MyMap myMap;

    @Before
    public void before() {
        myMap = new MyMap();
    }

    @Test
    public void testIsEmpty() {
        Assert.assertTrue(myMap.isEmpty());
        myMap.put("01 - First", 1);
        Assert.assertFalse(myMap.isEmpty());
        myMap.put("02 - Second", 3);
        Assert.assertFalse(myMap.isEmpty());
    }

    @Test
    public void testSize() {
        Assert.assertEquals(0, myMap.size());
        myMap.put("01 - First", 1);
        Assert.assertEquals(1, myMap.size());
        myMap.put("02 - Second", 3);
        Assert.assertEquals(2, myMap.size());
        myMap.put("02 - Second", 2);
        Assert.assertEquals(2, myMap.size());
    }

    @Test
    public void testAdd() {
        Assert.assertNull(myMap.put("01 - First", 1));
        Assert.assertNull(myMap.put("02 - Second", 3));
        Assert.assertEquals(3, myMap.put("02 - Second", 2));
    }

    @Test
    public void testAddNullKey() {
        boolean exceptionIsThrown = false;

        try {
            myMap.put(null, 1);
        } catch (NullPointerException e) {
            exceptionIsThrown = true;
        }

        Assert.assertTrue(exceptionIsThrown);

        exceptionIsThrown = false;

        try {
            myMap.put(1, null);
        } catch (NullPointerException e) {
            exceptionIsThrown = true;
        }

        Assert.assertTrue(exceptionIsThrown);
    }

    @Test
    public void testGetNullKey() {
        boolean exceptionIsThrown = false;

        try {
            myMap.get(null);
        } catch (NullPointerException e) {
            exceptionIsThrown = true;
        }

        Assert.assertTrue(exceptionIsThrown);
    }

    @Test
    public void testGet() {
        Assert.assertNull(myMap.get("01 - First"));

        for (int i = 1; i <= 512; i++) {
            myMap.put(i, i - 512);
        }
        for (int i = 1; i <= 512; i++) {
            Assert.assertEquals(i - 512, myMap.get(i));
        }
    }

    @Test
    public void testContainsNullKey() {
        boolean exceptionIsThrown = false;

        try {
            myMap.containsKey(null);
        } catch (NullPointerException e) {
            exceptionIsThrown = true;
        }

        Assert.assertTrue(exceptionIsThrown);
    }

    @Test
    public void testContainsKey() {
        Assert.assertFalse(myMap.containsKey("01 - First"));

        for (int i = 1; i <= 512; i++) {
            myMap.put(i, i - 512);
        }
        for (int i = 1; i <= 512; i++) {
            Assert.assertTrue(myMap.containsKey(i));
        }
    }

    @Test
    public void testContainsNullValue() {
        boolean exceptionIsThrown = false;

        try {
            myMap.containsValue(null);
        } catch (NullPointerException e) {
            exceptionIsThrown = true;
        }

        Assert.assertTrue(exceptionIsThrown);
    }

    @Test
    public void testContainsValue() {
        Assert.assertFalse(myMap.containsValue(1));

        for (int i = 1; i <= 512; i++) {
            myMap.put(i, i - 512);
        }
        for (int i = 1; i <= 512; i++) {
            Assert.assertTrue(myMap.containsValue(i - 512));
        }
    }

    @Test
    public void testClear() {
        for (int i = 1; i <= 512; i++) {
            myMap.put(i, i - 512);
        }

        Assert.assertEquals(512, myMap.size());
        Assert.assertFalse(myMap.isEmpty());

        myMap.clear();

        Assert.assertEquals(0, myMap.size());
        Assert.assertTrue(myMap.isEmpty());
        Assert.assertTrue(myMap.keySet().isEmpty());

        for (int i = 1; i <= 512; i++) {
            Assert.assertFalse(myMap.containsValue(i - 512));
        }
    }

    @Test
    public void testKeySet() {
        for (int i = 1; i <= 512; i++) {
            myMap.put(i, i - 512);
        }

        Set keySet = myMap.keySet();

        for (int i = 1; i <= 512; i++) {
            Assert.assertTrue(keySet.contains(i));
        }
    }
}
