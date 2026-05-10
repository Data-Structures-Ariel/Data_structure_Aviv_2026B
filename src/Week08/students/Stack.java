package Week08.students;

/**
 * Generic LIFO Stack, implemented over Node<T>.
 * (Provided utility class — DO NOT modify.)
 */
public class Stack<T> {
    private Node<T> _top;

    public Stack() {
        _top = null;
    }

    /** Pushes a value on top of the stack. */
    public void push(T value) {
        _top = new Node<T>(value, _top);
    }

    /** Removes and returns the top value. Throws if empty. */
    public T pop() {
        if (_top == null) throw new RuntimeException("Stack is empty");
        T v = _top.getValue();
        _top = _top.getNext();
        return v;
    }

    /** Returns (without removing) the top value. Throws if empty. */
    public T top() {
        if (_top == null) throw new RuntimeException("Stack is empty");
        return _top.getValue();
    }

    public boolean isEmpty() { return _top == null; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> cur = _top;
        while (cur != null) {
            sb.append(cur.getValue());
            if (cur.getNext() != null) sb.append(",");
            cur = cur.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}
