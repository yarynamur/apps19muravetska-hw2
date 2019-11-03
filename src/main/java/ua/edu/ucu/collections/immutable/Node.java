package ua.edu.ucu.collections.immutable;

public class Node {
    public Object value;
    public Node next;

    public Node(Object value, Node next){
        this.value = value;
        this.next = next;
    }

}
