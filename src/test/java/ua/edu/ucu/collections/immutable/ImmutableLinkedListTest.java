package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private ImmutableLinkedList list;
    private ImmutableLinkedList empty_list;


    @Before
    public void create_arr() {
        list = new ImmutableLinkedList();
        for (int i = 1; i < 6; i++) {
            list = list.add(i);
        }
        empty_list = new ImmutableLinkedList();
    }

    @Test
    public void testAddNoInd() {
        ImmutableList result = list.add(6);
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3, 4, 5});
        assertArrayEquals(result.toArray(), new Object[]{1, 2, 3, 4, 5, 6});

    }

    @Test
    public void testAddInd() {
        ImmutableList result = list.add(5,6);
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3, 4, 5});
        assertArrayEquals(result.toArray(), new Object[]{1, 2, 3, 4, 5, 6});

    }

    @Test
    public void testAddAllNoInd() {
        ImmutableList result = list.addAll(new Object[]{6, 7, 8});
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3, 4, 5});
        assertArrayEquals(result.toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7, 8});

    }

    @Test
    public void testAddAllInd() {
        ImmutableList result = list.addAll(1, new Object[]{6, 7, 8});
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3, 4, 5});
        assertArrayEquals(result.toArray(), new Object[]{1, 6, 7, 8, 2, 3, 4, 5});

    }

    @Test
    public void testAddFirst() {
        ImmutableList result = list.addFirst(0);
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3, 4, 5});
        assertArrayEquals(result.toArray(), new Object[]{0, 1, 2, 3, 4, 5});

    }

    @Test
    public void testAddLast() {
        ImmutableList result = list.addLast(6);
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3, 4, 5});
        assertArrayEquals(result.toArray(), new Object[]{1, 2, 3, 4, 5, 6});

    }

    @Test
    public void testSize() {
        assertEquals(empty_list.size(), 0);
    }

    @Test
    public void testClear() {
        ImmutableList result = list.clear();
        assertArrayEquals(result.toArray(), new Object[0]);
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testRemove() {
        ImmutableLinkedList result = (ImmutableLinkedList) list.remove(1);
        assertArrayEquals(result.toArray(), new Object[]{1, 3, 4, 5});
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testRemoveFirst() {
        ImmutableLinkedList result = list.removeFirst();
        assertArrayEquals(result.toArray(), new Object[]{2, 3, 4, 5});
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testRemoveLast() {
        ImmutableLinkedList actual = list.removeLast();
        System.out.println(actual.toArray());
        assertArrayEquals(actual.toArray(), new Object[]{1, 2, 3, 4});
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testSet() {
        ImmutableList result = list.set(1, 6);
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3, 4, 5});
        assertArrayEquals(result.toArray(), new Object[]{1, 6, 3, 4, 5});
    }

    @Test
    public void testGet() {
        assertEquals(list.get(3), 4);
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3, 4, 5});
    }


    @Test
    public void testGetFirst() {
        assertEquals(list.getFirst(), 1);
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testGetLast() {
        assertEquals(list.getLast(), 5);
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3, 4, 5});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetException() {
        list.get(10);
    }

    @Test
    public void testIndexOf(){
        assertEquals(list.indexOf(1), 0);
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testIsEmpty(){
        assertTrue(empty_list.isEmpty());
    }

    @Test
    public void testIsNotEmpty(){
        assertFalse(list.isEmpty());
    }
}
