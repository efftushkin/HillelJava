package MyMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

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

    @Test
    public void testRemoveNullKey() {
        boolean exceptionIsThrown = false;

        try {
            myMap.remove(null);
        } catch (NullPointerException e) {
            exceptionIsThrown = true;
        }

        Assert.assertTrue(exceptionIsThrown);
    }

    @Test
    public void testRemove() {
        Assert.assertNull(myMap.remove(1));

        for (int i = 1; i <= 512; i++) {
            myMap.put(i, i - 512);
        }

        for (int i = 1; i <= 512; i++) {
            Assert.assertEquals(i - 512, myMap.remove(i));
            Assert.assertFalse(myMap.containsKey(i));
            Assert.assertEquals(512 - i, myMap.size());
        }
    }

    @Test
    public void testValues() {
        Assert.assertEquals(0, myMap.values().size());

        for (int i = 1; i <= 512; i++) {
            myMap.put(i, i - 512);
        }

        Assert.assertEquals(512, myMap.values().size());

        Collection values = myMap.values();

        for (int i = 1; i <= 512; i++) {
            Assert.assertTrue(values.contains(i - 512));
        }
    }

    @Test
    public void testPutAllNullMapKeyValue() {
        boolean exceptionIsThrown = false;

        try {
            myMap.putAll(null);
        } catch (NullPointerException e) {
            exceptionIsThrown = true;
        }

        Assert.assertTrue(exceptionIsThrown);

        HashMap hashMap = new HashMap();
        hashMap.put(null, 0);

        exceptionIsThrown = false;

        try {
            myMap.putAll(hashMap);
        } catch (NullPointerException e) {
            exceptionIsThrown = true;
        }

        Assert.assertTrue(exceptionIsThrown);

        hashMap.clear();
        hashMap.put(0, null);

        exceptionIsThrown = false;

        try {
            myMap.putAll(hashMap);
        } catch (NullPointerException e) {
            exceptionIsThrown = true;
        }

        Assert.assertTrue(exceptionIsThrown);
    }

    @Test
    public void testPutAllWithoutIntersection() {
        for (int i = 1; i <= 64; i++) {
            myMap.put(i, i - 128);
        }

        HashMap hashMap = new HashMap();

        for (int i = 65; i <= 128; i++) {
            hashMap.put(i, i - 128);
        }

        myMap.putAll(hashMap);

        Assert.assertEquals(128, myMap.size());

        Collection values = myMap.values();

        for (int i = 1; i <= 128; i++) {
            Assert.assertTrue(values.contains(i - 128));
        }

        Set keySet = myMap.keySet();
        for (int i = 1; i <= 128; i++) {
            Assert.assertTrue(keySet.contains(i));
        }
    }

    @Test
    public void testPutAllWithIntersection() {
        for (int i = 1; i <= 64; i++) {
            myMap.put(i, i - 128);
        }

        HashMap hashMap = new HashMap();

        for (int i = 33; i <= 96; i++) {
            hashMap.put(i, i);
        }

        myMap.putAll(hashMap);

        Assert.assertEquals(96, myMap.size());

        Collection values = myMap.values();

        for (int i = 1; i <= 32; i++) {
            Assert.assertTrue(values.contains(i - 128));
        }
        for (int i = 33; i <= 96; i++) {
            Assert.assertFalse(values.contains(i - 128));
        }
        for (int i = 33; i <= 96; i++) {
            Assert.assertTrue(values.contains(i));
        }
    }

    @Test
    public void testEntrySet() {
        for (int i = 1; i <= 64; i++) {
            myMap.put(i, i - 128);
        }

        Set entrySet = myMap.entrySet();

        Object[] entries = entrySet.toArray();

        for (int i = 1; i <= 64; i++) {
            Map.Entry entry = (Map.Entry) entries[i - 1];
            Assert.assertEquals((Integer) entry.getKey() - 128, entry.getValue());
        }
    }
}
