package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    public ImmutableLinkedList queue;

    public Queue(){
        queue = new ImmutableLinkedList();
    }

    public Object peek() {
        return queue.getFirst();
    }

    public Object dequeue() {
        if (queue.len == 0){
            throw new IndexOutOfBoundsException();
        }
        Object el = queue.getFirst();
        queue = queue.removeFirst();
        return el;
    }

    public void enqueue(Object e) {
        queue = queue.addLast(e);
    }
}
