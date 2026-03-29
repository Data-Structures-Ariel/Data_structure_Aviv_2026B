package Week03.tasks;

public interface IStack<E> {
    public E push(E item);

    public E pop();

    public E peek();

    public boolean empty();

    public int search(Object o);
}
