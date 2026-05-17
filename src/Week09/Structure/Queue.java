package Week09.Structure;

/**
 * תור גנרי עם פרוטוקול FIFO - לפי הנספח.
 * אין להוסיף או להסיר פעולות.
 */
public class Queue<T> {
    private Node<T> head;
    private Node<T> tail;

    public Queue() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(T x) {
        Node<T> n = new Node<T>(x);
        if (tail == null) {
            head = n;
            tail = n;
        } else {
            tail.setNext(n);
            tail = n;
        }
    }

    public T remove() {
        T v = head.getValue();
        head = head.getNext();
        if (head == null) tail = null;
        return v;
    }

    public T head() {
        return head.getValue();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> p = head;
        while (p != null) {
            sb.append(p.getValue());
            if (p.hasNext()) sb.append(", ");
            p = p.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}
