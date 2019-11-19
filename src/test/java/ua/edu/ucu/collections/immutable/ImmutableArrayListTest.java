package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private ImmutableArrayList array;
    private ImmutableArrayList empty_array;

    @Before
    public void create_arr() {
        array = new ImmutableArrayList();
        for (int i = 1; i < 5 + 1; i++) {
            array = array.add(i);
        }
        empty_array = new ImmutableArrayList();
    }

    @Test
    public void testArrayAddNoInd() {
        ImmutableList result = array.add(6);
        Object[] expected = new Object[]{1, 2, 3, 4, 5, 6};
        assertArrayEquals(array.toArray(), new Object[]{1, 2, 3, 4, 5});
        assertArrayEquals(result.toArray(), expected);

    }

    @Test
    public void testArrayAddInd() {
        ImmutableList result = array.add(2, 6);
        Object[] expected = new Object[]{1, 2, 6, 3, 4, 5};
        assertArrayEquals(array.toArray(), new Object[]{1, 2, 3, 4, 5});
        assertArrayEquals(result.toArray(), expected);

    }

    @Test
    public void testArrayAddAllNoInd() {
        ImmutableList result = array.addAll(new Object[]{6, 7, 8});
        Object[] expected = new Object[]{1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(array.toArray(), new Object[]{1, 2, 3, 4, 5});
        assertArrayEquals(result.toArray(), expected);

    }

    @Test
    public void testArrayAddAllInd() {
        ImmutableList result = array.addAll(3, new Object[]{6, 7, 8});
        Object[] expected = new Object[]{1, 2, 3, 6, 7, 8, 4, 5};
        assertArrayEquals(array.toArray(), new Object[]{1, 2, 3, 4, 5});
        assertArrayEquals(result.toArray(), expected);

    }

    @Test
    public void testArrayClear() {
        ImmutableList result = array.clear();
        assertArrayEquals(result.toArray(), new ImmutableArrayList().toArray());
        assertArrayEquals(array.toArray(), new Object[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testArrayGet() {
        assertEquals(array.get(0), 1);
        assertArrayEquals(array.toArray(), new Object[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testRemove(){
        Object[] expected = new Object[]{2, 3, 4, 5};
        assertArrayEquals(array.remove(0).toArray(), expected);
        assertArrayEquals(array.toArray(), new Object[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testSet() {
        ImmutableList result = array.set(1, 6);
        assertArrayEquals(array.toArray(), new Object[]{1, 2, 3, 4, 5});
        assertArrayEquals(result.toArray(), new Object[]{1, 6, 3, 4, 5});
    }

    @Test
    public void testSize() {
        assertEquals(array.size(), 5);
    }

    @Test
    public void testIsNotEmpty() {
        assertFalse(array.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(empty_array.isEmpty());
    }

    @Test
    public void testToString() {
        assertEquals("[1, 2, 3, 4, 5]", array.toString());
    }

    @Test
    public void testIndexOf(){
        assertEquals(array.indexOf(1), 0);
        assertArrayEquals(array.toArray(), new Object[]{1, 2, 3, 4, 5});
    }


    
}
