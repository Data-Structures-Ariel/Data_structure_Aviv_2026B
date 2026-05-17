package Week09.Structure;

/**
 * חוליה גנרית - לפי הנספח.
 * אין להוסיף או להסיר פעולות.
 */
public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T x) {
        this.value = x;
        this.next = null;
    }

    public Node(T x, Node<T> next) {
        this.value = x;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setValue(T x) {
        this.value = x;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }

    @Override
    public String toString() {
        return value == null ? "null" : value.toString();
    }
}
