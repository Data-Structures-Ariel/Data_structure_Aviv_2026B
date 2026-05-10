package Week08.students;

/**
 * Generic linked-list Node.
 * (Provided utility class — DO NOT modify.)
 * @param <T> type of value stored in the node
 */
public class Node<T> {
    private T _value;
    private Node<T> _next;

    public Node(T value) {
        _value = value;
        _next = null;
    }

    public Node(T value, Node<T> next) {
        _value = value;
        _next = next;
    }

    public T getValue() { return _value; }
    public void setValue(T value) { _value = value; }

    public Node<T> getNext() { return _next; }
    public void setNext(Node<T> next) { _next = next; }

    public boolean hasNext() { return _next != null; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        Node<T> cur = this;
        while (cur != null) {
            sb.append(cur._value);
            if (cur._next != null) sb.append(",");
            cur = cur._next;
        }
        sb.append(")");
        return sb.toString();
    }
}
