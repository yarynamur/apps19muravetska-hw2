package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    private Queue q;

    public void fill_queue(Queue my_queue, int size) {
        for (int i = 1; i < size + 1; i++) {
            my_queue.enqueue(i);
        }
    }

    @Before
    public void create_queue() {
        q = new Queue();
    }

    @Test
    public void testEnqueue(){
        fill_queue(q, 5);
        assertArrayEquals(new Object[]{1, 2, 3, 4, 5}, q.queue.toArray());
    }

    @Test
    public void testDequeue(){
        fill_queue(q, 3);
        assertEquals(1, q.dequeue());
        assertArrayEquals(new Object[]{2, 3}, q.queue.toArray());
    }

    @Test
    public void testPeek(){
        fill_queue(q, 2);
        assertEquals(1, q.peek());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testException() {
        q.dequeue();
    }

}
