package Week08.students;

/**
 * Generic Binary Tree Node.
 * (Provided utility class — DO NOT modify.)
 */
public class BinTreeNode<T> {
    private T _value;
    private BinTreeNode<T> _left;
    private BinTreeNode<T> _right;

    public BinTreeNode(T value) {
        _value = value;
        _left = null;
        _right = null;
    }

    public BinTreeNode(T value, BinTreeNode<T> left, BinTreeNode<T> right) {
        _value = value;
        _left = left;
        _right = right;
    }

    public T getValue() { return _value; }
    public void setValue(T value) { _value = value; }

    public BinTreeNode<T> getLeft() { return _left; }
    public void setLeft(BinTreeNode<T> left) { _left = left; }

    public BinTreeNode<T> getRight() { return _right; }
    public void setRight(BinTreeNode<T> right) { _right = right; }

    public boolean hasLeft() { return _left != null; }
    public boolean hasRight() { return _right != null; }
}
