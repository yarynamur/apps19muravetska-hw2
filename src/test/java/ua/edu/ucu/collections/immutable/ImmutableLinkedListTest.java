package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private ImmutableLinkedList list;
    private ImmutableLinkedList list2;
    private ImmutableLinkedList empty_list;


    @Before
    public void create_arr() {
        list = new ImmutableLinkedList();
        for (int i = 1; i < 5 + 1; i++) {
            list.add(i);
        }
        list2 = new ImmutableLinkedList();
        for (int i = 5; i < 8 + 1; i++) {
            list2.add(i);
        }
        empty_list = new ImmutableLinkedList();
    }

    @Test
    public void testAdd() {
        ImmutableList result = list.add(5);
        Object[] expected = new Object[]{1, 2, 3, 4, 5};
        assertArrayEquals(result.toArray(), expected);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllIndexOutOfRange() {
        ImmutableList actual = list.addAll(10, list.toArray());
    }

    @Test
    public void testGet() {
        assertEquals(list.get(3), 3);
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3, 4});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetException() {
        list.get(10);
    }

    @Test
    public void testSize() {
        assertEquals(empty_list.size(), 0);
    }

    @Test
    public void testClear() {
        ImmutableList result = list.clear();
        assertArrayEquals(result.toArray(), new Object[0]);
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3, 4});
    }

    @Test
    public void testRemoveFirst() {
        ImmutableLinkedList result = list.removeFirst();
        assertArrayEquals(result.toArray(), new Object[]{2, 3, 4});
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3, 4});
    }

    @Test
    public void testRemoveLast() {
        ImmutableLinkedList actual = list.removeLast();
        assertArrayEquals(actual.toArray(), new Object[]{1, 2, 3});
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3, 4});
    }


    @Test
    public void testGetFirst() {
        assertEquals(list.getFirst(), 1);
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3, 4});
    }

    @Test
    public void testGetLast() {
        assertEquals(list.getLast(), 4);
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3, 4});
    }
}
