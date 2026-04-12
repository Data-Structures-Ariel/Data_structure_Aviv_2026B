package Week04.tasks;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;



public class QueueWithStack<E> implements Queue<E> {

    static String ID;

    public QueueWithStack() {
    }

    @Override
    public int size() {
        //implement
        return 0;
    }

    @Override
    public boolean isEmpty() {
        //implement
        return false;
    }

    @Override
    public boolean contains(Object o) {
        //implement
        return false;
    }

    @Override
    public boolean add(E e) {
        //implement
        return false;
    }

    @Override
    public boolean remove(Object o) {
        //implement
        return false;
    }
    @Override
    public void clear() {
        //implement
    }
    @Override
    public E remove() {
        //implement
        return null;
    }

    @Override
    public E poll() {
        //implement
        return null;
    }
    @Override
    public E peek() {
        //implement
        return null;
    }
    //---------------------------------------------------------
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }


    @Override
    public boolean offer(E e) {
        return false;
    }


    @Override
    public E element() {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }
}
