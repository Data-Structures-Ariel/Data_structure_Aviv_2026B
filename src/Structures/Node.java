package Structures;

public class Node<E> {

    private E val;
    private Node<E> next;
    private Node<E> prev;


    public Node(E val) {
        this.val = val;
        this.next = null;
        this.prev = null;

    }

    public Node(E val, Node<E> next,Node<E> prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    public E getVal() {
        return val;
    }

    public void setVal(E val) {
        this.val = val;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public boolean hasPrev() {
        return prev != null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                ", prev=" + prev +
                '}';
    }
}