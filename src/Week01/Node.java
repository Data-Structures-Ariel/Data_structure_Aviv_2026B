package Week01;

public class Node<E> {

    private E val;
    private Node<E> next;


    public Node(E val) {
        this.val = val;
        this.next = null;
    }

    public Node(E val, Node<E> next) {
        this.val = val;
        this.next = next;
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


    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}