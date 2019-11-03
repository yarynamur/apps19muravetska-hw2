package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    public ImmutableLinkedList stack;

    public Stack() {
        stack = new ImmutableLinkedList();
    }

    Object peek() {
        if (stack.len == 0){
            throw new IndexOutOfBoundsException();
        }
        return stack.getFirst();
    }

    Object pop() {
        Object e = stack.getFirst();
        stack = stack.removeFirst();
        return e;
    }

    void push(Object e) {
        stack = stack.addFirst(e);
    }


}
