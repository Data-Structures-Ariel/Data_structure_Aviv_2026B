package Week01.tasks;

import Structures.Node;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class MyDoublyLinkedList<E> implements List<E> {
    static String ID;
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyDoublyLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }
    @Override
    public int size() {
        //implement
        return size;
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
        return true;
    }

    //O(n)
    @Override
    public boolean remove(Object o) {
        //implement
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        //implement
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        //implement
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        //implement
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        //implement
        return false;
    }

    @Override
    public void clear() {
        //implement
    }

    @Override
    public E get(int index) {
        //implement
        return null;
    }

    @Override
    public E set(int index, E element) {
        //implement
        return null;
    }

    @Override
    public void add(int index, E element) {
        //implement
    }

    @Override
    public E remove(int index) {
        //implement
        return null;
    }

    @Override
    public int indexOf(Object o) {
        //implement
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        //implement
        return 0;
    }
    //----------------------------------------------------------------------------
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return List.of();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}