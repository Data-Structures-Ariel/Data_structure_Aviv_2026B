package Week09.Structure;

/**
 * מחסנית גנרית עם פרוטוקול LIFO - לפי הנספח.
 * אין להוסיף או להסיר פעולות.
 */
public class Stack<T> {
    private Node<T> top;

    public Stack() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T x) {
        top = new Node<T>(x, top);
    }

    public T pop() {
        T v = top.getValue();
        top = top.getNext();
        return v;
    }

    public T top() {
        return top.getValue();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> p = top;
        while (p != null) {
            sb.append(p.getValue());
            if (p.hasNext()) sb.append(", ");
            p = p.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}
