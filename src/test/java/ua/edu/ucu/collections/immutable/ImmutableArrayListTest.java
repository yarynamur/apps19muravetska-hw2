package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private ImmutableArrayList array;
    private ImmutableArrayList array_2;
    private ImmutableArrayList empty_array;

    @Before
    public void create_arr() {
        array = new ImmutableArrayList();
        for (int i = 1; i < 5 + 1; i++) {
            array.add(i);
        }
        array_2 = new ImmutableArrayList();
        for (int i = 5; i < 8 + 1; i++) {
            array_2.add(i);
        }
        empty_array = new ImmutableArrayList();
    }

    @Test
    public void testArrayAdd() {
        ImmutableList result = array.add(5);
        Object[] expected = new Object[]{1, 2, 3, 4, 5};
        assertArrayEquals(array.toArray(), new Object[]{1, 2, 3, 4});
        assertArrayEquals(result.toArray(), expected);

    }

    @Test
    public void testArrayClear() {
        ImmutableList result = array.clear();
        assertArrayEquals(result.toArray(), new ImmutableArrayList().toArray());
        assertArrayEquals(array.toArray(), new Object[]{1, 2, 3, 4});
    }

    @Test
    public void testArrayGet() {
        assertEquals(array.get(1), 1);
        assertArrayEquals(array.toArray(), new Object[]{1, 2, 3, 4});
    }

    @Test
    public void testSize() {
        assertEquals(empty_array.size(), 0);
    }

    @Test
    public void testIsEmpty() {
        assertFalse(array.isEmpty());
    }

    @Test
    public void testIsNonEmpty() {
        assertTrue(empty_array.isEmpty());
    }

    @Test
    public void testToString() {
        assertEquals(array.toString(), "1, 2, 3, 4");
    }


    
}
