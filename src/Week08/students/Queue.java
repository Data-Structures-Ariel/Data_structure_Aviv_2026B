package Week08.students;

/**
 * Generic FIFO Queue, implemented over Node<T>.
 * (Provided utility class — DO NOT modify.)
 */
public class Queue<T> {
    private Node<T> _head;
    private Node<T> _tail;

    public Queue() {
        _head = null;
        _tail = null;
    }

    /** Inserts a value at the back of the queue. */
    public void insert(T value) {
        Node<T> n = new Node<T>(value);
        if (_head == null) {
            _head = n;
            _tail = n;
        } else {
            _tail.setNext(n);
            _tail = n;
        }
    }

    /** Removes and returns the value at the head. Throws if empty. */
    public T remove() {
        if (_head == null) throw new RuntimeException("Queue is empty");
        T v = _head.getValue();
        _head = _head.getNext();
        if (_head == null) _tail = null;
        return v;
    }

    /** Returns (without removing) the value at the head. Throws if empty. */
    public T head() {
        if (_head == null) throw new RuntimeException("Queue is empty");
        return _head.getValue();
    }

    public boolean isEmpty() { return _head == null; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        Node<T> cur = _head;
        while (cur != null) {
            sb.append(cur.getValue());
            if (cur.getNext() != null) sb.append(",");
            cur = cur.getNext();
        }
        sb.append(">");
        return sb.toString();
    }
}
