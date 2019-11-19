package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    private Stack s;

    public void fill_stack(Stack my_stack, int size) {
        for (int i = 1; i < size; i++) {
            my_stack.push(i);
        }
    }

    @Before
    public void create_stack() {
        s = new Stack();
    }

    @Test
    public void testPop() {
        fill_stack(s, 5);
        assertEquals(4, s.pop());
        assertArrayEquals(new Object[]{3, 2, 1}, s.stack.toArray());
    }

    @Test
    public void testPeek() {
        fill_stack(s, 15);
        assertEquals(14, s.peek());
    }

    @Test
    public void testPush() {
        fill_stack(s, 5);
        assertArrayEquals(new Object[]{4, 3, 2, 1}, s.stack.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testException() {
        s.peek();
    }

}
