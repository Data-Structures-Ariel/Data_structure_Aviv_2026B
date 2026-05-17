package Week09.Structure;

/**
 * חוליה בינארית גנרית - לפי הנספח.
 * אין להוסיף או להסיר פעולות.
 */
public class BinNode<T> {
    private T value;
    private BinNode<T> left;
    private BinNode<T> right;

    public BinNode(T x) {
        this.value = x;
        this.left = null;
        this.right = null;
    }

    public BinNode(BinNode<T> left, T x, BinNode<T> right) {
        this.value = x;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T x) {
        this.value = x;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    public BinNode<T> getLeft() {
        return left;
    }

    public BinNode<T> getRight() {
        return right;
    }

    public void setLeft(BinNode<T> left) {
        this.left = left;
    }

    public void setRight(BinNode<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return value == null ? "null" : value.toString();
    }
}
