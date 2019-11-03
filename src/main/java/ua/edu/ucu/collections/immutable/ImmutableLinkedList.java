package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableLinkedList implements ImmutableList{
    private Node head;
    private Node tail;
    public int len;

    public ImmutableLinkedList() {
        this.head = null;
        this.tail = null;
        this.len = 0;
    }

    private void checkSize(int index) throws IndexOutOfBoundsException {
        if (index >= this.len || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public ImmutableList add(Object e) {
        return add(this.len, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        checkSize(index);
        ImmutableLinkedList NewImmutableLinkedList = new ImmutableLinkedList();
        NewImmutableLinkedList.head = head;
        NewImmutableLinkedList.tail = tail;
        NewImmutableLinkedList.len = len+1;
        if (index==0){
            Node newNode = new Node(e, NewImmutableLinkedList.head);
            NewImmutableLinkedList.head = newNode;
        }
        else{
            Node temp = new Node(NewImmutableLinkedList.head.value, NewImmutableLinkedList.head.next);
            for (int i = 0; i < index - 1; i++){
                temp = temp.next;
            }
            Node newNode = temp.next;
            temp.next = new Node(e, newNode);
        }
        return NewImmutableLinkedList;
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(this.len, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        checkSize(index);
        ImmutableLinkedList TempImmutableLinkedList = new ImmutableLinkedList();
        ImmutableList NewImmutableLinkedList;
        TempImmutableLinkedList.head = head;
        TempImmutableLinkedList.tail = tail;
        TempImmutableLinkedList.len = len;
        NewImmutableLinkedList = TempImmutableLinkedList;
        for (int i = 0; i < c.length; i++) {
            NewImmutableLinkedList = NewImmutableLinkedList.add(index, c[i]);
            index++;
        }
        return NewImmutableLinkedList;
    }

    @Override
    public Object get(int index) {
        checkSize(index);
        if (index==len-1){
            return tail.value;
        }
        Node temp = new Node(head.value, head.next);
        for (int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp.value;
    }

    @Override
    public ImmutableList remove(int index) {
        checkSize(index);
        ImmutableLinkedList NewImmutableLinkedList = new ImmutableLinkedList();
        NewImmutableLinkedList.head = head;
        NewImmutableLinkedList.tail = tail;
        NewImmutableLinkedList.len = len;
        if (index==0){
            NewImmutableLinkedList.head = NewImmutableLinkedList.head.next;
        }
        else{
            for (int i = 0; i < index - 1; i++){
                NewImmutableLinkedList.tail = NewImmutableLinkedList.tail.next;
            }
            NewImmutableLinkedList.tail.next = NewImmutableLinkedList.tail.next.next;
            while (NewImmutableLinkedList.tail.next != null) {
                NewImmutableLinkedList.tail = NewImmutableLinkedList.tail.next;
            }
        }
        NewImmutableLinkedList.len = len - 1;
        return NewImmutableLinkedList;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        checkSize(index);
        ImmutableLinkedList NewImmutableLinkedList = new ImmutableLinkedList();
        NewImmutableLinkedList.head = head;
        NewImmutableLinkedList.tail = tail;
        NewImmutableLinkedList.len = len;
        return NewImmutableLinkedList.remove(index).add(index, e);
    }

    @Override
    public int indexOf(Object e) {
        Node temp;
        temp = head;
        for (int i = 0; i < len; i++) {
            if (temp.value == e) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    @Override
    public int size() {
        return len;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return len == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] NewImmutableLinkedList = new Object[len];
        Node temp = head;
        for (int i = 0; i < len; i++) {
            NewImmutableLinkedList[i] = temp.value;
            temp = temp.next;
        }
        return NewImmutableLinkedList;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) add(e);
    }

    public Object getFirst() {
        return head.value;
    }

    public Object getLast() {
        return tail.value;
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove(len - 1);
    }
}
